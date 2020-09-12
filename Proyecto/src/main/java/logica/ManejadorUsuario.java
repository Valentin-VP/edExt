package logica;

import java.util.ArrayList;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
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
				if ((u.getNick().toLowerCase().equals(nick.toLowerCase())) || (u.getCorreo().toLowerCase().equals(correo.toLowerCase()))) {
					retorno = u;
				}
			}
		}
		
		return retorno;
	}
	public void removerUsuario(Usuario usuario) {
		//
	}
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public Usuario findUsuario(String nick) {
		for(Usuario u: usuarios) {
			if(u.getNick().equals(nick))
				return u;
		}
		return null;
	}
}
