package logica;

import java.util.ArrayList;
import java.util.List;


public class ManejadorInstituto {
    private static ManejadorInstituto instancia;
    private List<Instituto> institutos = new ArrayList<>();

    public ManejadorInstituto() {}

    public static ManejadorInstituto getInstancia() {
        if(instancia == null)
            instancia = new ManejadorInstituto();
        return instancia;
    }

    public boolean exists(String nombre) {
    	for(Instituto i: institutos) {
    		if(i.getNombre()==nombre) {
    			return true;
    		}
    	}
    	return false;
    }

    public void agregarInstituto(String nombre) {
        Instituto i = new Instituto(nombre);
        institutos.put(i.getNombre(), i);
    }
//desde aca es mio
    public Instituto find(String instituto) {
        return this.institutos.get(instituto);
    }

    public HashMap<String, Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(HashMap<String, Instituto> institutos) {
        this.institutos = institutos;
    }

}