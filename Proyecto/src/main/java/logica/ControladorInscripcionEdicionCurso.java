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
	private String nombreEd;
	private Date fecha;
	
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
	public boolean registrarInscripcionEd(String nick, String nombreEd, Date fecha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modificarInscripcionEd(String nick, String nombreEd, Date fecha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmar() {
		// TODO Auto-generated method stub
		
	}

}
