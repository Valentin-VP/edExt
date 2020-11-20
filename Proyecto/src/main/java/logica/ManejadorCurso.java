package logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorCurso {
	
	private static ManejadorCurso instancia;

    private ManejadorCurso() {}
    
    public static ManejadorCurso getInstancia() {
        if(instancia == null)
            instancia = new ManejadorCurso();
        return instancia;
    }
    
    public boolean existeCurso(String nombre) {
    	List<Curso> cursos = getCursos();
    	if(cursos.size()!=0) {//cursos!=null
    		for(Curso c: cursos) {
        		if(c.getNombre().equals(nombre)) {
        			return true;
        		}
        	}
    	}
    	return false;
    }
    
    public Curso find(String nombre) { 
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Curso curso = em.find(Curso.class, nombre);
		return curso;
    }

    public void agregarCurso(Curso c) {
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(c);
		
		em.getTransaction().commit();
    }


    public List<Curso> getCursos() {
        
    	Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select c from Curso c");
		@SuppressWarnings("unchecked")
		List<Curso> listCursos = (List<Curso>) query.getResultList();
		return listCursos;
    }

    
    /*public ArrayList<DtCursoBase> getDtCursos() {
        ArrayList<DtCursoBase> dtcur = new ArrayList<DtCursoBase>();
        List<Curso> cursos = getCursos();
    	for(int i=0; i < cursos.size();i++) {
        	DtCursoBase dtc = new DtCursoBase(cursos.get(i).getNombre());
    		dtcur.add(dtc);
        }
    	return dtcur;
    } Lo comento porque no se como se lo usa, si alguien lo usa que lo cambie*/
    
    

}