package logica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEdicion;
import excepciones.EdicionRepetida;
import excepciones.CursoNoExiste;
import excepciones.DocenteDeOtroInstituto;
import excepciones.DocenteYaAgregado;
import datatypes.DtUsuarioBase;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import interfaces.IControladorAltaEdicionCurso;
import persistencia.Conexion;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioNoExiste;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String instituto;
	private String curso;
	private boolean tieneCupos;
	private Integer cupos;
	private DtEdicion dtEdi;
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isTieneCupos() {
		return tieneCupos;
	}

	public void setTieneCupos(boolean tieneCupos) {
		this.tieneCupos = tieneCupos;
	}

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	public DtEdicion getDtEdi() {
		return dtEdi;
	}

	public void setDtEdi(DtEdicion dtEdi) {
		this.dtEdi = dtEdi;
	}

	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente {//mod
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList <DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		if (i == null) {
			throw new InstitutoInexistente("El instituto " + instituto + " no esta en el sistema");
		}
		this.instituto = i.getNombre();
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		List<Curso> cursos = mC.getCursos();
		for(Curso c: cursos) {
			DtCursoBase dtcb = new DtCursoBase (c.getNombre());
			cursosinstituto.add(dtcb);
		}
		return cursosinstituto;
	}
	
	@Override//mod, verificar con vale
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cantCupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(this.instituto);
		Edicion edicion;
		if (i.equals(null)) {
			throw new InstitutoInexistente("El instituto " + instituto + " no esta en el sistema");
		}
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		if(mC.existeCurso(curso)) {
			ManejadorEdicion mE = ManejadorEdicion.getInstancia();
			if(mE.find(nombre) == null) {
				
				Date fechaIdate = null;
				Date fechaFdate = null;
				Date fechaPubdate = null;
				try {
					fechaIdate = fechaI.DtFechaToDate();
					fechaFdate = fechaF.DtFechaToDate();
					fechaPubdate = fechaPub.DtFechaToDate();
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (!tieneCupos) {
					edicion = new Edicion(nombre, fechaIdate, fechaFdate, tieneCupos, 0, fechaPubdate);
				} else {
					edicion = new Edicion(nombre, fechaIdate, fechaFdate, tieneCupos, cantCupos, fechaPubdate);
				}
				// Agregar edicion al curso
				mE.agregarEdicion(edicion);
				mC.find(curso).addEdicion(edicion);//agrego a la coleccion de ediciones de el curso
				i.agregarCurso(i.findCurso(curso));// necesario??... el curso no existe en la base de datos ya??
			}
			else {
				throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso:" + i.findCurso(curso).getNombre());
			}
		}
		else {
			throw new CursoNoExiste("El curso " + curso + " no esta en el sistema");
		}
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		for(String user: docentes) {
			
			if (mU.findUsuario(user) instanceof Docente) {
				((Docente) mU.findUsuario(user)).addDictaEdicion(edicion);
				
				Conexion conexion = Conexion.getInstancia();	
				EntityManager em = conexion.getEntityManager();	
				em.getTransaction().begin();	
				
				em.persist(mU.findUsuario(user));	
				
				em.getTransaction().commit();	
			}
		}
	}	

	
	@Override
	public ArrayList<DtUsuarioBase> getUsuarios(){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuarioBase> users = new ArrayList<>();
		for (Usuario u: mU.getUsuarios()) {
			DtUsuarioBase user = new DtUsuarioBase(u.getNick(), u.getCorreo());
			users.add(user);
		}
		return users;
	}
	
	
	public void verificarUsuario(String nick, String correo, ArrayList<String> docentes) throws UsuarioNoExiste, UsuarioNoDocente, DocenteDeOtroInstituto, DocenteYaAgregado {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.findUsuario(nick);
		boolean docenteDeInstituto;
		if(u == null)
			throw new UsuarioNoExiste("El usuario " + nick + " no se encuentra en el sistema");
		if(u instanceof Docente) { 
			if(!(u.getCorreo().equals(correo)))
				throw new UsuarioNoExiste("Correo incorrecto");
			docenteDeInstituto = ((Docente) u).getInstituto().getNombre().equals(this.instituto);
			if(!docenteDeInstituto) 
				throw new DocenteDeOtroInstituto("El usuario " + nick + " no es de ese instituto");
			if(docenteEnArray(nick, docentes))
				throw new DocenteYaAgregado("El usuario " + nick + " ya fue agregado como docente de la edicion");
		}else
			throw new UsuarioNoDocente("El usuario " + nick + " no es un docente");
	}

	
	public boolean docenteEnArray(String nick, ArrayList<String> docentes) {
		for(String d: docentes) {
			if(d.equals(nick))
				return true;
		}
		return false;
	}
	
}









