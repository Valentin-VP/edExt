package logica;

import java.util.ArrayList;


public class ManejadorInstituto {
    private static ManejadorInstituto instancia;
    private ArrayList<Instituto> institutos = new ArrayList<>();

    public ManejadorInstituto() {}

    public static ManejadorInstituto getInstancia() {
        if(instancia == null)
            instancia = new ManejadorInstituto();
        return instancia;
    }
    
    public Instituto find(String nombre) { //aca es ell problema
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