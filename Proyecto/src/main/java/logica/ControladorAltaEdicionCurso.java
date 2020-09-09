package logica;

import java.util.ArrayList;
import datatypes.DtEdicion;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import excepciones.CursoNoExiste;
import datatypes.DtUsuarioBase;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import interfaces.IControladorAltaEdicionCurso;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String instituto;
	private String curso;
	private boolean tieneCupos;//no lo uso
	private Integer cupos;//no lo uso
	private DtEdicion dtEdi;
	
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente {
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList <DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		if (i == null) {
			throw new InstitutoInexistente("El instituto " + instituto + " no esta en el sistema");
		}
		this.instituto = i.getNombre();
		ArrayList<Curso> cursos = mI.find(instituto).getCursos();
		for(Curso c: cursos) {
			DtCursoBase dtcb = new DtCursoBase (c.getNombre());
			cursosinstituto.add(dtcb);
		}
		return cursosinstituto;
	}
	
	@Override
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<DtUsuarioBase> docentes, boolean tieneCupos, Integer cantCupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(this.instituto);
		if (i.equals(null)) {
			throw new InstitutoInexistente("El instituto " + instituto + " no esta en el sistema");
		}
		Curso c = new Curso();
		c = i.findCurso(curso);
		if (c == null) {
			throw new CursoNoExiste("El curso " + curso + " no esta en el sistema");
		}
		Edicion edicion;
		edicion = c.findEdicion(nombre);
		if(edicion != null) {
			throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso:" + c.getNombre());
		}
		if (!tieneCupos) {
			edicion = new Edicion(nombre, fechaI, fechaF, tieneCupos, 0, fechaPub);
		} else {
			edicion = new Edicion(nombre, fechaI, fechaF, tieneCupos, cantCupos, fechaPub);
		}
		c.addEdicion(edicion);
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		for (Usuario u: mU.getUsuarios()) {
			if (u instanceof Docente) {
				((Docente) u).addDictaEdicion(edicion);
			}else {
				throw new UsuarioNoDocente("El usuario " + u.getNick() + " no es un doncente");
			}		
		}
	}	

	/*@Override
	public void ingresarCupos(Integer cupos) throws EdicionSinCupos {
		if (!edicion.isTieneCupos()) {
			throw new EdicionSinCupos("La edicion " + edicion.getNombre() + " no tiene cupos");
		}
		edicion.setCupo(cupos);
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(this.edicion.getNombre());
		e.setCupos(cupos);
	}*/

	/*@Override
	public void modificarAltaEdicion(String nuevoNombre) throws EdicionRepetida {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		if (mE.exists(nuevoNombre)) {
			throw new EdicionRepetida("La edicion " + nuevoNombre + " ya se encuentra en el sistema");
		}
		mE.find(edicion.getNombre()).setNombre(nuevoNombre);
		this.edicion.setNombre(nuevoNombre);
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		for (DtEdicionBase e: c.getEdiciones()) {
			if (e.getNombre() == nuevoNombre) {
				throw new EdicionRepetida("La edicion " + nuevoNombre + " ya se encuentra integrada al curso");
			}
		}
		for (DtEdicionBase e: c.getEdiciones()) {
			if (e.getNombre() == edicion.getNombre()) {
				e.setNombre(nuevoNombre);
			}
		}
	}*/


	/*@Override
	public void confirmarAltaEdicion() {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		mE.agregarEdicion(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(), edicion.isTieneCupos(), edicion.getCupo(), edicion.getFechaPub());
	}*/
	
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
	
	public void listarEdiciones() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		ArrayList<Instituto> institutos = mI.getInstitutos();
		for(Instituto i: institutos) {
			ArrayList<Curso> cursos = i.getCursos();
			for(Curso c: cursos) {
				ArrayList<Edicion> ediciones = c.getEdiciones();
				for(Edicion e: ediciones) {
					System.out.println(i.getNombre() + " " + c.getNombre() + " " + e.getNombre());
				}
			}
		}
	}
	
}









