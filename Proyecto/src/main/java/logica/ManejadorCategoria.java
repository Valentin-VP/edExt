package logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;


public class ManejadorCategoria {
	 private static ManejadorCategoria instancia;

	 private ManejadorCategoria() {}
	    
	    public static ManejadorCategoria getInstancia() {
	        if(instancia == null)
	            instancia = new ManejadorCategoria();
	        return instancia;
	    }
	    
	    public Categoria find(String nombre) {
	    	Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			
			Categoria categoria = em.find(Categoria.class, nombre);
			return categoria;
	    }
	    
	    public void agregarCategoria(Categoria c) {
	    	Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			
			em.persist(c);
			
			em.getTransaction().commit();
	    }

	    
	    public List<Categoria> getCategorias() {
	        
	    	Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			
			Query query = em.createQuery("select c from Categoria c");
			@SuppressWarnings("unchecked")
			List<Categoria> listCategorias = (List<Categoria>) query.getResultList();
			return listCategorias;
	    }
}
