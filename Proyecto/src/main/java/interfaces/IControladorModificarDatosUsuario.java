package interfaces;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import datatypes.DtUsuarioBase;
import java.util.*;


public interface IControladorModificarDatosUsuario {
	public ArrayList<DtUsuarioBase> mostrarUsuarios();
	
	public DtUsuario seleccionarUsuario(String nick, String correo);
	
	public void editarNombre(String nuevoNombre);
	
	public void editarApellido(String nuevoApellido);
	
	public void editarFNac(DtFecha nuevaFecha);

}
