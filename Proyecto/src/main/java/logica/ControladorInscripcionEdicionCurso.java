package logica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
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

	public String getNomCurso() {
		return nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
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
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) throws CursoNoExiste, SinInstitutos{
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList<DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.find(nomIns);
		if (ins == null) {
			throw new SinInstitutos("No hay institutos ingresados");
		}
		this.nomIns = ins.getNombre();
		List <Curso> cursos = ins.getCursos();
		if (cursos.isEmpty()) {
			throw new CursoNoExiste("El instituto no tiene cursos ingresados");
		}
		for(int i=0;i < cursos.size();i++) {
			DtCursoBase dtcb = new DtCursoBase (cursos.get(i).getNombre());
			cursosinstituto.add(dtcb);
		}
		return cursosinstituto;
		
	}

	@Override
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.find(this.nomIns);
		Curso c = ins.findCurso(nomCurso);
		this.setNomCurso(c.getNombre());
		DtEdicionBase dteb = c.getEdicionVigente();
		if (dteb == null) {
			throw new EdicionVigenteNoExiste("No existe una edicion vigente para el curso seleccionado");
		}
		this.nombreEd = dteb.getNombre();
		return dteb;
	}

	@Override
	public boolean registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws InscripcionEdRepetido, UsuarioNoExiste, UsuarioNoEstudiante {
		this.nick = nick;
		this.correo = correo;
		this.setNomCurso(nomCurso);
		this.fecha = fecha;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.findUsuario(nick);
		if (u == null) {
			throw new UsuarioNoExiste("No existe el usuario ingresado");
		}
		if(u instanceof Estudiante) {
			boolean existeInscripcion = ((Estudiante) u).existeInscripcion(this.nombreEd);
			if (existeInscripcion) {
				throw new InscripcionEdRepetido("Ya existe una inscripcion a la edicion");
			}
		} else {
			throw new UsuarioNoEstudiante("El usuario ingresado es un docente");
		}
		return false;
	}

	@Override
	public void limpiar() {
		this.nomIns=null;
		this.setNomCurso(null);
		this.nick=null;
		this.correo=null;
		this.nombreEd=null;
		this.fecha=null;
	}

	@Override
	public void confirmar() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.find(nomIns);
		Curso c = ins.findCurso(nomCurso);
		Edicion ed = c.findEdicion(nombreEd);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.findUsuario(this.nick);
		Date datefecha = null;
		try {
			datefecha = this.fecha.DtFechaToDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InscripcionEd ie=new InscripcionEd(datefecha,ed,(Estudiante) u);
		if(u instanceof Estudiante) {
			((Estudiante) u).agregarInscripcionEd(ie);
			
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			
			em.persist(u);
			
			em.getTransaction().commit();
			
		}
	}

}
