package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;

public interface IControladorInscripcionEdicionCurso {
	public ArrayList<DtInstituto> listarInstitutos();
	
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns);
	
	public DtEdicionBase seleccionarCurso(String nomCurso);
	
	public boolean registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha);
	
	public void modificarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha);
	
	public void cancelar();
	
	public void confirmar();
}
