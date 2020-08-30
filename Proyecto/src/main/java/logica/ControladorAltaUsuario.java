package logica;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private String instituto;
	
	public ControladorAltaUsuario() {
		super();
	}
	
	@Override
	public Boolean altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) {
		//fijarme si el usuario ya esta en el sistema
		//crear un DtUsuario
		return null;
	}
	
	@Override
	public void seleccionarInstituto(String instituto) {
		//hago un set en la clase Docente(falta)
		
	}
	
	@Override
	public Boolean modificarAltaUsuario(String nuevoNick, String nuevoCorreo) {
		//hago un set en la clase Usuario
		//me fijo si la modificacion es valida
		return null;
	}
	
	@Override
	public void cancelarAltaUsuario() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void confirmarAltaUsuario() {
		//crea la instancia
		//cre el link
		
	}
	
	public DtUsuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(DtUsuario usuario) {
		this.usuario = usuario;
	}
	
	public String getInstituto() {
		return instituto;
	}
	
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	
	
}
