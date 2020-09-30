package logica;

import javax.persistence.EntityManager;

import interfaces.IControladorSeguirUsuario;
import persistencia.Conexion;

public class ControladorSeguirUsuario implements IControladorSeguirUsuario {
	
	public void SeguirUsuario(String seguido, String seguidor) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario yo = mU.findUsuario(seguidor);
		Usuario aquiensigo = mU.findUsuario(seguido);
		yo.addSeguido(aquiensigo);
		aquiensigo.addSeguidor(yo);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(yo);
		em.persist(aquiensigo);
		
		em.getTransaction().commit();
		
	}
	
	public void DejarDeSeguir(String seguido, String seguidor) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario yo = mU.findUsuario(seguidor);
		Usuario aquiensigo = mU.findUsuario(seguido);
		yo.removeSeguido(aquiensigo);
		aquiensigo.removeSeguidor(yo);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(yo);
		em.persist(aquiensigo);
		
		em.getTransaction().commit();
	}

}
