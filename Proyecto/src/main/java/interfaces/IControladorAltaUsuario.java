package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.SinInstitutos;
import excepciones.UsuarioRepetido;
import logica.Instituto;

public interface IControladorAltaUsuario {
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) throws UsuarioRepetido; 
	
	public void seleccionarInstituto(String instituto);
	
	//public void modificarAltaUsuario(String nuevoNick, String nuevoCorreo) throws UsuarioRepetido;
	
	public void cancelarAltaUsuario();
	
	public void confirmarAltaUsuario(boolean esDocente);
	
	public List<Instituto> getInstitutos();
	
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;
	
}
