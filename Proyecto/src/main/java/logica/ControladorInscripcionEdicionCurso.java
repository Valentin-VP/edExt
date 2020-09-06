package logica;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import interfaces.IControladorInscripcionEdicionCurso;

public class ControladorInscripcionEdicionCurso implements IControladorInscripcionEdicionCurso{
	private String nomIns;
	private String nomC;
	private String nick;
	private String correo;
	private String nombreEd;
	private Date fecha;
	
	@Override
	public ArrayList<Instituto> listarInstitutos() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		return mI.getInstitutos();
	}

	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) {
		this.nomIns = nomIns;
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(nomIns);
		return i.getCursos();
	}

	@Override
	public DtEdicionBase seleccionarCurso(String nomC) {
		this.nomC = nomC;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(nomC);
		return c.getEdicionVigente();
	}

	@Override
	public boolean registrarInscripcionEd(String nick, String correo, String nombreEd, Date fecha) {
		// TODO Auto-generated method stub
		this.nick = nick;
		this.correo = correo;
		this.nombreEd = nombreEd;
		this.fecha = fecha;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(nick, correo);
		if(u instanceof Estudiante) {
			return ((Estudiante) u).existeInscripcion(nombreEd);
		}
		return false;
	}

	@Override
	public void modificarInscripcionEd(String nick, String correo, String nombreEd, Date fecha) {
		// TODO Auto-generated method stub
		this.nick = nick;
		this.correo = correo;
		this.nombreEd = nombreEd;
		this.fecha = fecha;
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		this.nomIns=null;
		this.nomC=null;
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
		Usuario u = mU.getUsuario(nick, correo);
		if(u instanceof Estudiante) {
			((Estudiante) u).agregarInscripcionEd(ie);
		}
	}

}
