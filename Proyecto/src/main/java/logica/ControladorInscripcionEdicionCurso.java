package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.InstitutoInexistente;
import interfaces.IControladorInscripcionEdicionCurso;

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

	@Override
	public ArrayList<DtInstituto> listarInstitutos() throws InstitutoInexistente {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if (mI.getDtInstitutos().isEmpty()) {
			throw new InstitutoInexistente("No hay institutos ingresados");
		}
		return mI.getDtInstitutos();
	}

	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) throws CursoNoExiste{
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList<DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.find(nomIns);
		this.nomIns = nomIns;
		//ArrayList <Curso> cursos = mI.find(nomIns).getCursos();
		ArrayList <Curso> cursos = ins.getCursos();
		for(int i=0;i < cursos.size();i++) {
			DtCursoBase dtcb = new DtCursoBase (cursos.get(i).getNombre());
			cursosinstituto.add(dtcb);
		}
		return cursosinstituto;
	}

	@Override
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste{
		this.nomCurso = nomCurso;
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.find(this.nomIns);
		//ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = ins.findCurso(nomCurso);
		DtEdicionBase dteb = c.getEdicionVigente();
		if (dteb == null) {
			throw new EdicionVigenteNoExiste("No existe una edicion vigente para el curso seleccionado");
		}
		this.nombreEd = dteb.getNombre();
		return dteb;
	}

	@Override
	public boolean registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws InscripcionEdRepetido {
		// TODO Auto-generated method stub
		this.nick = nick;
		this.correo = correo;
		this.nomCurso = nomCurso;
		this.fecha = fecha;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(nick, correo);
		if(u instanceof Estudiante) {
			boolean existe = ((Estudiante) u).existeInscripcion(nomCurso);
			if (existe == true) {
				throw new InscripcionEdRepetido("Ya existe una inscripcion a la edicion");
			}
		}
		return false;
	}

	@Override
	public void modificarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) {
		// TODO Auto-generated method stub
		this.nick = nick;
		this.correo = correo;
		this.nomCurso = nomCurso;
		this.fecha = fecha;
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		this.nomIns=null;
		this.nomCurso=null;
		this.nick=null;
		this.correo=null;
		this.nombreEd=null;
		this.fecha=null;
	}

	@Override
	public void confirmar() {
		// TODO Auto-generated method stub
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion ed = mE.find(this.nombreEd);
		InscripcionEd ie=new InscripcionEd(this.fecha,ed);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(this.nick, this.correo);
		if(u instanceof Estudiante) {
			((Estudiante) u).agregarInscripcionEd(ie);
		}
	}

}
