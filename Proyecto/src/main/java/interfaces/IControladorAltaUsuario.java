package interfaces;

import datatypes.DtFecha;
import logica.Instituto;
import excepciones.UsuarioRepetido;

public interface IControladorAltaUsuario {
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) throws UsuarioRepetido; 
	
	public void seleccionarInstituto(Instituto instituto);
	
	//public void modificarAltaUsuario(String nuevoNick, String nuevoCorreo) throws UsuarioRepetido;
	
	public void cancelarAltaUsuario();
	
	public void confirmarAltaUsuario();
	
}
