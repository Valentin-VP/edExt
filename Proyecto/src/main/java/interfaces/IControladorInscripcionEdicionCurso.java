package interfaces;

import java.util.ArrayList;
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

public interface IControladorInscripcionEdicionCurso {
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;
	
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) throws CursoNoExiste;
	
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste;
	
	public void registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws InscripcionEdRepetido, UsuarioNoExiste, UsuarioNoEstudiante;
	
	public void cancelar();
	
	public void confirmar();
}
