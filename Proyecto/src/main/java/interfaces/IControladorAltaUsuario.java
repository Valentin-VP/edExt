package interfaces;

import datatypes.DtFecha;

public interface IControladorAltaUsuario {
	public Boolean altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac);
	
	public void seleccionarInstituto(String instituto);
	
	public Boolean modificarAltaUsuario(String nuevoNick, String nuevoCorreo);
	
	public void cancelarAltaUsuario();
	
	public void confirmarAltaUsuario();
	
}
