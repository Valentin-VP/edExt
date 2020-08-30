package logica;

import datatypes.DtFecha;
import datatypes.DtUsuarioBase;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuarioBase usuario;
	private String instituto;
	
	public ControladorAltaUsuario() {
		super();
	}
	
	@Override
	public Boolean altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void seleccionarInstituto(String instituto) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Boolean modificarAltaUsuario(String nuevoNick, String nuevoCorreo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void cancelarAltaUsuario() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void confirmarAltaUsuario() {
		// TODO Auto-generated method stub
		
	}
	
	public DtUsuarioBase getUsuario() {
		return usuario;
	}
	
	public void setUsuario(DtUsuarioBase usuario) {
		this.usuario = usuario;
	}
	
	public String getInstituto() {
		return instituto;
	}
	
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	
	
}
