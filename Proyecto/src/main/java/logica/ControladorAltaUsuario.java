 package logica;

import java.util.ArrayList;

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
	public void seleccionarInstituto(String instituto) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		this.instituto = mI.find(instituto);
	}
	
	
	@Override
	public void cancelarAltaUsuario() {
		
	}
	
	@Override
	public void confirmarAltaUsuario(boolean esDocente) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user;
		if (esDocente) {
			user = new Docente(usuario.getNick(), usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(), usuario.getFechaNac(), this.instituto);
		} else {
			user = new Estudiante(usuario.getNick(), usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(), usuario.getFechaNac());
		}	
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
	
	public ArrayList<Instituto> getInstitutos() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		return mI.getInstitutos();
	}
}
