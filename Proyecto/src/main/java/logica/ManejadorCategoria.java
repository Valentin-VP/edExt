package logica;

import java.util.List;

public class ManejadorCategoria {
	 private static ManejadorCategoria instancia;
	 
	 private List<Categoria> categorias;

	 private ManejadorCategoria() {}
	    
	    public static ManejadorCategoria getInstancia() {
	        if(instancia == null)
	            instancia = new ManejadorCategoria();
	        return instancia;
	    }
	    
	    public Categoria find(String nombre) {
	    	if(categorias != null) {
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
