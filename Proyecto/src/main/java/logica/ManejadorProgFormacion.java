package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtProgramaBase;
import persistencia.Conexion;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia;
	//private List<ProgFormacion> programas = new ArrayList<ProgFormacion>();
	
	public static ManejadorProgFormacion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorProgFormacion();
		return instancia;
	}
	
	public boolean existePrograma(String nombre) {
    	List<ProgFormacion> programas = getProgramas();
    	if(programas!=null) {
    		for(ProgFormacion pf: programas) {
        		if(pf.getNombre().equals(nombre)) {
        			return true;
        		}
        	}
    	}
    	return false;
    }
    
    public ProgFormacion find(String nombre) { 
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		ProgFormacion pf = em.find(ProgFormacion.class, nombre);
		return pf;
    }

    public void agregarProgFormacion(ProgFormacion pf) {
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(pf);
		
		em.getTransaction().commit();
    }

    public List<ProgFormacion> getProgramas() {
        
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select pf from ProgFormacion pf");
		@SuppressWarnings("unchecked")
		List<ProgFormacion> listProgramas = (List<ProgFormacion>) query.getResultList();
		return listProgramas;
    }
    
    public ArrayList<DtProgramaBase> getDtProgramasBase() {
        ArrayList<DtProgramaBase> dtpfs = new ArrayList<DtProgramaBase>();
        List<ProgFormacion> programas = getProgramas();
    	for(int i=0; i < programas.size();i++) {
    		DtProgramaBase dtpf = new DtProgramaBase(programas.get(i).getNombre());
        	dtpfs.add(dtpf);
        }
    	return dtpfs;
    }
	
	/*
	public boolean exists(String nombre) {
		if(programas != null) {
			for(ProgFormacion pf: programas) {
				if(pf.getNombre().equals(nombre)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void agregarProgFormacion(ProgFormacion pf) {
		programas.add(pf);
	}
	
	public ProgFormacion getProgFormacion(String nombre) {
		ProgFormacion retorno=null;
		for(ProgFormacion pf: programas) {
			if(pf.getNombre()==nombre) {
				retorno = pf;
			}
		}
		return retorno;
	}
	
    public ArrayList<DtProgramaBase> getDtProgramasBase() {
        ArrayList<DtProgramaBase> dtpbs = new ArrayList<DtProgramaBase>();
        List<ProgFormacion> prog = getProgramas();
    	for(int i=0; i < prog.size();i++) {
    		DtProgramaBase dti = new DtProgramaBase(prog.get(i).getNombre());
        	dtpbs.add(dti);
        }
    	return dtpbs;
    }

	public List<ProgFormacion> getProgramas() {
		return programas;
	}

	public void setProgramas(List<ProgFormacion> programas) {
		this.programas = programas;
	}
	
	public ProgFormacion find(String nombre) {
		for(ProgFormacion pf: this.programas) {
			if(pf.getNombre().equals(nombre)) {
				return pf;
			}
		}
		return null;
	}
	*/

}
