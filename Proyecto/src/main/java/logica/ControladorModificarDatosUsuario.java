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
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public DtFecha getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(DtFecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	@Override
	public ArrayList<DtUsuarioBase> mostrarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuarioBase> usuarios = new ArrayList<DtUsuarioBase>();
		for (Usuario u: mU.getUsuarios()) {
			DtUsuarioBase dtUsuarioBase = new DtUsuarioBase(u.getNick(), u.getCorreo());
			usuarios.add(dtUsuarioBase);
		}
		return usuarios;
	}
	@Override
	public DtUsuario seleccionarUsuario(String nick, String correo) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.getUsuario(nick, correo);
		return user.getDtUsuario();
	}
	@Override
	public void editarNombre(String nuevoNombre) {
		this.setNombre(nuevoNombre);//??
	}
	@Override
	public void editarApellido(String nuevoApellido) {
		this.setApellido(nuevoApellido);//??
	}
	@Override
	public void editarFNac(DtFecha nuevaFecha) {
		this.setFechaNac(nuevaFecha);//??
	}
	
}
