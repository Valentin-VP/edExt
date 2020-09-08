package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.InstitutoInexistente;

public interface IControladorInscripcionEdicionCurso {
	public ArrayList<DtInstituto> listarInstitutos() throws InstitutoInexistente;
	
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) throws CursoNoExiste;
	
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste;
	
	public boolean registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws InscripcionEdRepetido;
	
	public void modificarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha);
	
	public void cancelar();
	
	public void confirmar();
}
