package logica;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private Instituto instituto;
	
	public ControladorAltaUsuario() {
		super();
	}
	
	@Override
	public Boolean altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Boolean esValido = true;
		for (Usuario u: mU.getUsuarios()) {
			if ((u.getNick() == nick) || (u.getCorreo() == correo)) {
				esValido = false;
			}
		}
		this.usuario = new DtUsuario(nick, correo, nombre, apellido, fechaNac);
		return esValido;
	}
	
	@Override
	public void seleccionarInstituto(Instituto instituto) {//arreglado??
		Usuario user = new Usuario(usuario.getNick(), usuario.getCorreo(), usuario.getNombre(), usuario.getApellido(), usuario.getFechaNac());
		if (user instanceof Docente) {
			((Docente) user).setInstituto(instituto);
		}
	}
	
	@Override
	public Boolean modificarAltaUsuario(String nuevoNick, String nuevoCorreo) {
		this.usuario.setNick(nuevoNick);
		this.usuario.setCorreo(nuevoCorreo);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Boolean esValido = true;
		for (Usuario u: mU.getUsuarios()) {
			if ((u.getNick() == nuevoNick) || (u.getCorreo() == nuevoCorreo)) {
				esValido = false;
			}
		}
		return esValido;
	}
	
	@Override
	public void cancelarAltaUsuario() {
		//nose
	}
	
	@Override
	public void confirmarAltaUsuario() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = new Usuario(usuario.getNick(), usuario.getCorreo(), usuario.getNombre(), usuario.getApellido(), usuario.getFechaNac());
		mU.agregarUsuario(user);
	}
	
	public DtUsuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(DtUsuario usuario) {
		this.usuario = usuario;
	}
	
	public Instituto getInstituto() {
		return instituto;
	}
	
	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	
	
}
