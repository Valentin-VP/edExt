package logica;

import java.util.ArrayList;


public class ManejadorInstituto {
    private static ManejadorInstituto instancia;
    private ArrayList<Instituto> institutos = new ArrayList<>();

    public ManejadorInstituto() {}
    
    
    public boolean existeInstituto(String nombre) {
    	if(institutos!=null) {
    		for(Instituto i: institutos) {
        		if(i.getNombre().equals(nombre)) {
        			return true;
        		}
        	}
    	}
    	return false;
    }
    
    
    public static ManejadorInstituto getInstancia() {
        if(instancia == null)
            instancia = new ManejadorInstituto();
        return instancia;
    }
    
    public Instituto find(String nombre) { 
    	Instituto aretornar = null;
    	for(Instituto i: institutos) {
    		if(i.getNombre().equals(nombre)) {
    			aretornar=i;
    		}
    	}
    	return aretornar;
    }

    public void agregarInstituto(String ins) {
        Instituto i = new Instituto(ins);
        institutos.add(i);
    }


    public ArrayList<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(ArrayList<Instituto> institutos) {
        this.institutos = institutos;
    }

    
}