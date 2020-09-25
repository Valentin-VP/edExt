package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtInstituto;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstituto {
    private static ManejadorInstituto instancia;

    private ManejadorInstituto() {}
    
    public static ManejadorInstituto getInstancia() {
        if(instancia == null)
            instancia = new ManejadorInstituto();
        return instancia;
    }
    
    public boolean existeInstituto(String nombre) {
    	List<Instituto> institutos = getInstitutos();
    	if(institutos!=null) {
    		for(Instituto i: institutos) {
        		if(i.getNombre().equals(nombre)) {
        			return true;
        		}
        	}
    	}
    	return false;
    }
    
    public Instituto find(String nombre) { 
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Instituto instituto = em.find(Instituto.class, nombre);
		return instituto;
    }

    public void agregarInstituto(Instituto i) {
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(i);
		
		em.getTransaction().commit();
    }


    public List<Instituto> getInstitutos() {
        
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select i from Instituto i");
		@SuppressWarnings("unchecked")
		List<Instituto> listInstitutos = (List<Instituto>) query.getResultList();
		return listInstitutos;
    }

    
    public ArrayList<DtInstituto> getDtInstitutos() {
        ArrayList<DtInstituto> dtins = new ArrayList<DtInstituto>();
        List<Instituto> institutos = getInstitutos();
    	for(int i=0; i < institutos.size();i++) {
        	DtInstituto dti = new DtInstituto(institutos.get(i).getNombre());
    		dtins.add(dti);
        }
    	return dtins;
    }

    
    /*public void agregarCurso(Curso c) {//esta funcion hay que sacarla de aca, ya esta en ManejadorCurso
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(c);
		
		em.getTransaction().commit();
    }*/
}