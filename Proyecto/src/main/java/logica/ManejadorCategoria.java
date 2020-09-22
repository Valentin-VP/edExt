package logica;

import java.util.List;
import java.util.ArrayList;

public class ManejadorCategoria {
	 private static ManejadorCategoria instancia;
	 
	 private List<Categoria> categorias = new ArrayList<>();

	 private ManejadorCategoria() {}
	    
	    public static ManejadorCategoria getInstancia() {
	        if(instancia == null)
	            instancia = new ManejadorCategoria();
	        return instancia;
	    }
	    
	    public Categoria find(String nombre) {
	    	if(this.categorias != null) {
	    		for(Categoria c: categorias) {
	        		if(c.getNombre().equals(nombre)) {
	        			return c;
	        		}
	        	}
	    	}
	    	return null;
	    }
	    
	    public void agregarCategoria(Categoria C) {
	    	categorias.add(C);
	    }
	    
}
