package logica;

import logica.ManejadorUsuario;
import interfaces.IControladorConsultaUsuario;

@SuppressWarnings("unused")
public class ControladorConsultaUsuario implements IControladorConsultaUsuario {
	private Usuario user;
	
	public void listarUsuarios() {
		ManejadorUsuario mI = ManejadorUsuario.getInstancia();
		mI.getUsuarios();//aca tengo la lista de usuarios a listar
	}
	
	public void ElejirUsuario(String nick, String correo) {
		ManejadorUsuario mI = ManejadorUsuario.getInstancia();
		mI.getUsuario(nick, correo);
		//aca habria que ver que tipo de usuario es y depende de lo que elija el usuario el caso de uso con el que se procede
	}
}
