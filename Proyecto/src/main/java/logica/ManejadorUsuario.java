package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	private ManejadorUsuario() {
		super();
	}
	
	public static ManejadorUsuario getInstancia() {
		if(instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public List<Usuario> getUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		return listUsuario;
	}
	
	public ArrayList<String> getUsuariosCorreo() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		ArrayList<String> ret = new ArrayList<>();
		for(Usuario u: listUsuario) {
			ret.add(u.getCorreo());
		}
		return ret;
	}
	/*
	 * public Usuario getUsuario(String nick, String correo) { Usuario retorno =
	 * null; if (!usuarios.isEmpty()){ for (Usuario u: usuarios) { if
	 * ((u.getNick().toLowerCase().equals(nick.toLowerCase())) ||
	 * (u.getCorreo().toLowerCase().equals(correo.toLowerCase()))) { retorno = u; }
	 * } }
	 * 
	 * return retorno; }
	 */

	public void agregarUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
	}
	
	public Usuario findUsuario(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Usuario usuario = em.find(Usuario.class, nick);
		return usuario;
	}
	
	public Usuario findUsuarioCorreo(String correo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Usuario usuario = em.find(Usuario.class, correo);
		return usuario;
	}
	
	public void actualizarUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.merge(usuario);
		
		em.getTransaction().commit();
	}
}
