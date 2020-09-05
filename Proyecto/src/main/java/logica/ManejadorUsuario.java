package logica;

import java.util.*;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private ArrayList<Usuario> usuarios = null;
	
	private ManejadorUsuario() {
		super();
	}
	public static ManejadorUsuario getInstancia() {
		if(instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public Usuario getUsuario(String nick, String correo) {
		Usuario retorno = null;
		if (!usuarios.isEmpty()){
			for (Usuario u: usuarios) {
				if ((u.getNick().equals(nick)) || (u.getCorreo().equals(correo))) {
					retorno = u;
				}
			}
		}
		
		return retorno;
	}
	public void removerUsuario(Usuario usuario) {
		//hacer remove
	}
	public void agregarUsuario(Usuario usuario) {
		//hacer add
	}
}
