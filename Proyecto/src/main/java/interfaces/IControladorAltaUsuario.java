package interfaces;

import datatypes.DtFecha;
import logica.Instituto;

public interface IControladorAltaUsuario {
	public Boolean altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac);
	
	public void seleccionarInstituto(Instituto instituto);
	
	public Boolean modificarAltaUsuario(String nuevoNick, String nuevoCorreo);
	
	public void cancelarAltaUsuario();
	
	public void confirmarAltaUsuario();
	
}
