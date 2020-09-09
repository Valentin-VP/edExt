package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import excepciones.EdicionRepetida;
import excepciones.CursoNoExiste;
import datatypes.DtUsuarioBase;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioNoExiste;
import excepciones.DocenteDeOtroInstituto;

public interface IControladorAltaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente;
	
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente;
	
	public ArrayList<DtUsuarioBase> getUsuarios();
	
	public void listarEdiciones();
	
	public void verificarUsuario(String nick, String correo) throws UsuarioNoExiste, UsuarioNoDocente, DocenteDeOtroInstituto;
}
