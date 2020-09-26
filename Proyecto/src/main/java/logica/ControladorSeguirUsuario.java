package logica;

import interfaces.IControladorSeguirUsuario;

public class ControladorSeguirUsuario implements IControladorSeguirUsuario {
	
	public void SeguirUsuario(String seguido, String seguidor) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u= mU.findUsuario(seguido);
		u.addSeguidor(seguidor);
	}
	
	public void DejarDeSeguir(String seguido, String seguidor) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u= mU.findUsuario(seguido);
		u.removeSeguidor(seguidor);
	}

}
