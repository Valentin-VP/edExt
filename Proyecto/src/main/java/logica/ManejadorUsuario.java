package logica;

import java.util.*;
import logica.Usuario;

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
	public Usuario getUsuario(String nick) {//correo?
		//hacer find
		return null;
	}
	public void removerUsuario(Usuario usuario) {
		//hacer remove
	}
	public void agregarUsuario(Usuario usuario) {
		//hacer add
	}
}
