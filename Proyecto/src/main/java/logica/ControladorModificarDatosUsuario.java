package logica;

import java.util.ArrayList;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import datatypes.DtUsuarioBase;
import interfaces.IControladorModificarDatosUsuario;

public class ControladorModificarDatosUsuario implements IControladorModificarDatosUsuario {
	private String usuario;
	private String nombre;
	private String apellido;
	private DtFecha fechaNac;
	
	@Override
	public ArrayList<DtUsuarioBase> mostrarUsuarios() {
		return null;
	}
	@Override
	public DtUsuario seleccionarUsuario(String usuario) {
		return null;
	}
	@Override
	public void editarNombre(String nuevoNombre) {
		
	}
	@Override
	public void editarApellido(String nuevoApellido) {
		
	}
	@Override
	public void editarFNac(DtFecha nuevaFecha) {
		
	}
	
	
}
