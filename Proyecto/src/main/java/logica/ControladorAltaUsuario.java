 package logica;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;
import excepciones.UsuarioRepetido;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private Instituto instituto;
	
	public ControladorAltaUsuario() {
		super();
	}
	
	@Override
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) throws UsuarioRepetido {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = null;
		user = mU.getUsuario(nick, correo);
		if(!(user == null)) {
			throw new UsuarioRepetido("El usuario " + nick + " ya se encuentra registrado");
		}	
		this.usuario = new DtUsuario(nick, correo, nombre, apellido, fechaNac);
	}
	
	@Override
	public void seleccionarInstituto(Instituto instituto) {
		Usuario user = new Usuario(usuario.getNick(), usuario.getCorreo(), usuario.getNombre(), usuario.getApellido(), usuario.getFechaNac());
		if (user instanceof Docente) {
			((Docente) user).setInstituto(instituto);
		}
	}
	
	/*@Override
	public void modificarAltaUsuario(String nuevoNick, String nuevoCorreo) throws UsuarioRepetido {
		this.usuario.setNick(nuevoNick);
		this.usuario.setCorreo(nuevoCorreo);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.getUsuario(nuevoNick, nuevoCorreo);
		if (user != null) {
			throw new UsuarioRepetido("El usuario " + nuevoNick + "con correo " + nuevoCorreo + " ya se encuentra registrado");
		}
	}*/
	
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
