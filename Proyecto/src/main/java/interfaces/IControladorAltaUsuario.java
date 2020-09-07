package interfaces;

import java.util.ArrayList;

import datatypes.DtFecha;
//import logica.Instituto;
import excepciones.UsuarioRepetido;
import logica.Instituto;

public interface IControladorAltaUsuario {
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) throws UsuarioRepetido; 
	
	public void seleccionarInstituto(String instituto);
	
	//public void modificarAltaUsuario(String nuevoNick, String nuevoCorreo) throws UsuarioRepetido;
	
	public void cancelarAltaUsuario();
	
	public void confirmarAltaUsuario(boolean esDocente);
	
	public ArrayList<Instituto> getInstitutos();
	
}
