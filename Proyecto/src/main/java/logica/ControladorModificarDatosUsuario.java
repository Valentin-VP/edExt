package logica;

import java.util.*;
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
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuarioBase> usuarios = null;
		for (Usuario u: mU.getUsuarios()) {
			DtUsuarioBase dtUsuarioBase = new DtUsuarioBase(u.getNombre());
			usuarios.add(dtUsuarioBase);
		}
		return usuarios;
	}
	@Override
	public DtUsuario seleccionarUsuario(String usuario) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.getUsuario(usuario);
		return user.getDtUsuario();
	}
	@Override
	public void editarNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;//??
	}
	@Override
	public void editarApellido(String nuevoApellido) {
		this.apellido = nuevoApellido;//??
	}
	@Override
	public void editarFNac(DtFecha nuevaFecha) {
		this.fechaNac = nuevaFecha;//??
	}
	
	
}
