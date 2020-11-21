package logica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.EstadoInscripcion;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoEstudiante;
import excepciones.UsuarioNoExiste;
import interfaces.IControladorInscripcionEdicionCurso;
import persistencia.Conexion;

public class ControladorInscripcionEdicionCurso implements IControladorInscripcionEdicionCurso{
	private String nomIns;
	private String nomCurso;
	private String nick;
	private String correo;
	private String nombreEd;
	private DtFecha fecha;
	
	public ControladorInscripcionEdicionCurso() {
		super();
	}

	public void setNomIns(String nomIns) {
		this.nomIns = nomIns;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if (mI.getDtInstitutos().isEmpty()) {
			throw new SinInstitutos("No hay institutos ingresados");
		}
		return mI.getDtInstitutos();
	}

	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) throws CursoNoExiste {
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList<DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.find(nomIns);
		this.setNomIns(ins.getNombre());
		for(Curso c: ins.getCursos()) {
			DtCursoBase dtcb = new DtCursoBase(c.getNombre());
			cursosinstituto.add(dtcb);
		}
		if (cursosinstituto.isEmpty()) {
			throw new CursoNoExiste("El instituto no tiene cursos ingresados");
		}
		return cursosinstituto;
	}

	@Override
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste{
		//ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		//Instituto ins = mI.find(this.nomIns);
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(nomCurso);//ins.findCurso(nomCurso);
		this.setNomCurso(c.getNombre());
		DtEdicionBase dteb = c.getEdicionVigente();
		if (dteb == null) {
			throw new EdicionVigenteNoExiste("No existe una edicion vigente para el curso seleccionado");
		}
		this.nombreEd = dteb.getNombre();
		return dteb;
	}

	@Override
	public void registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws UsuarioNoExiste, UsuarioNoEstudiante {
		this.nick = nick;
		this.setCorreo(correo);
		this.setNomCurso(nomCurso);
		this.fecha = fecha;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.findUsuario(nick);
		if (u == null) {
			throw new UsuarioNoExiste("No existe el usuario ingresado");
		}
		if (!u.getCorreo().equals(correo)) {
			throw new UsuarioNoExiste("No existe un usuario con el nick y correo ingresados");
		}
		if(u instanceof Estudiante) {
		} else {
			throw new UsuarioNoEstudiante("El usuario ingresado es un docente");
		}
	}

	@Override
	public void cancelar() {
		this.setNomIns(null);
		this.setNomCurso(null);
		this.nick=null;
		this.setCorreo(null);
		this.nombreEd=null;
		this.fecha=null;
	}

	@Override
	public void confirmar() throws InscripcionEdRepetido, EdicionVigenteNoExiste, UsuarioNoExiste {
		//ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		//Instituto ins = mI.find(nomIns);
		//ManejadorCurso mC = ManejadorCurso.getInstancia();
		//Curso c = mC.find(nomCurso);//ins.findCurso(nomCurso);
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		if (nombreEd == null) {
			throw new EdicionVigenteNoExiste("No existe una edicion vigente para el curso seleccionado");
		}
		Edicion ed = mE.find(nombreEd);//c.findEdicion(nombreEd);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if (this.nick == null) {
			throw new UsuarioNoExiste("No existe un usuario con el nick y correo ingresados");
		}
		Usuario u = mU.findUsuario(this.nick);
		Date datefecha = null;
		EstadoInscripcion estado = EstadoInscripcion.Inscripto;
		try {
			datefecha = this.fecha.DtFechaToDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(u instanceof Estudiante) {
			boolean existeInscripcion = ((Estudiante) u).existeInscripcion(this.nombreEd);
			if (existeInscripcion) {
				throw new InscripcionEdRepetido("Ya existe una inscripcion a la edicion");
			} else {
				
				InscripcionEd ie=new InscripcionEd(datefecha,estado,ed,(Estudiante) u);
				((Estudiante) u).agregarInscripcionEd(ie);
				ed.addInscripcion(ie);
				
				Conexion conexion = Conexion.getInstancia();
				EntityManager em = conexion.getEntityManager();
				em.getTransaction().begin();
				
				em.persist(ed);
				em.persist(u);
				em.persist(ie);
				
				em.getTransaction().commit();
				
			}
		}
		
	}

}
