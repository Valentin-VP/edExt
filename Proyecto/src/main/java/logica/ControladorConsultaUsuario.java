package logica;

import logica.ManejadorUsuario;
import interfaces.IControladorConsultaUsuario;

@SuppressWarnings("unused")
public class ControladorConsultaUsuario implements IControladorConsultaUsuario {
	private Usuario user;
	
	public void listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.getUsuarios();//aca tengo la lista de usuarios a listar
	}
	
	public void ElegirUsuario(String nick, String correo) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.findUsuario(nick);
		//aca habria que ver que tipo de usuario es y depende de lo que elija el usuario el caso de uso con el que se procede
	}
}
