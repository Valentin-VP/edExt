package interfaces;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import datatypes.DtUsuarioBase;
import excepciones.SinUsuarios;

import java.util.ArrayList;

public interface IControladorModificarDatosUsuario {
	public ArrayList<DtUsuarioBase> mostrarUsuarios() throws SinUsuarios;
	
	public DtUsuario seleccionarUsuario(String nick, String correo);
	
	public void modificarDatosUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, char[] password);
	
	public void limpiar();

}
