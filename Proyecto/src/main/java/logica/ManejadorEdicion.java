package logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorEdicion {
	
	private static ManejadorEdicion instancia;

    private ManejadorEdicion() {}
    
    public static ManejadorEdicion getInstancia() {
        if(instancia == null)
            instancia = new ManejadorEdicion();
        return instancia;
    }
    
    public boolean existeEdicion(String nombre) {
    	List<Edicion> ediciones = getEdiciones();
    	if(ediciones!=null) {
    		for(Edicion e: ediciones) {
        		if(e.getNombre().equals(nombre)) {
        			return true;
        		}
        	}
    	}
    	return false;
    }
    
    public Edicion find(String nombre) { 
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Edicion edicion = em.find(Edicion.class, nombre);
		return edicion;
    }

    public void agregarEdicion(Edicion e) {
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(e);
		
		em.getTransaction().commit();
    }


    public List<Edicion> getEdiciones() {
        
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select e from Edicion e");
		@SuppressWarnings("unchecked")
		List<Edicion> listEdiciones = (List<Edicion>) query.getResultList();
		return listEdiciones;
    }

    
    /*public ArrayList<DtEdicionBase> getDtEdiciones() {
        ArrayList<DtEdicionBase> dteds = new ArrayList<DtEdicionBase>();
        List<Edicion> ediciones = getEdiciones();
    	for(int i=0; i < ediciones.size();i++) {
        	DtEdicionBase dte = new DtEdicionBase(ediciones.get(i).getNombre());
    		dteds.add(dte);
        }
    	return dteds;
    } Lo comento porque no se como se lo usa, si alguien lo usa que lo cambie*/

}
