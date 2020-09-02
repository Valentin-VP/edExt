package interfaces;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;

public interface IControladorInscripcionEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns);
	
	public DtEdicionBase seleccionarCurso(String nomC);
	
	public boolean registrarInscripcionEd(String nick, String nombreEd, Date fecha);
	
	public void modificarInscripcionEd(String nick, String nombreEd, Date fecha);
	
	public void cancelar();
	
	public void confirmar();
}
