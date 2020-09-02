package logica;

import logica.ManejadorUsuario;

@SuppressWarnings("unused")
public class ControladorConsultaUsuario {
	private Usuario user;
	
	public void listarUsuarios() {
		ManejadorUsuario mI = ManejadorUsuario.getInstancia();
		mI.getUsuarios();//aca tengo la lista de usuarios a listar
	}
	
	public void ElejirUsuario(String nick) {
		ManejadorUsuario mI = ManejadorUsuario.getInstancia();
		mI.getUsuario(nick);
		//aca habria que ver que tipo de usuario es y depende de lo que elija el usuario el caso de uso con el que se procede
	}
}
