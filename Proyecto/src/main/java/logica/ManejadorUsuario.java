package logica;

import java.util.*;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private ArrayList<Usuario> usuarios;
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
		for (Usuario u: usuarios) {
			if ((u.getNick() == nick) || (u.getCorreo() == correo)) {
				return u;
			}
		}
		return null;
	}
	public void removerUsuario(Usuario usuario) {
		//hacer remove
	}
	public void agregarUsuario(Usuario usuario) {
		//hacer add
	}
}
