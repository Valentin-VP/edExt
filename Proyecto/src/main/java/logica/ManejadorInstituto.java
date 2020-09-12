package logica;

import java.util.ArrayList;
import datatypes.DtInstituto;

public class ManejadorInstituto {
    private static ManejadorInstituto instancia;
    private ArrayList<Instituto> institutos = new ArrayList<Instituto>();

    private ManejadorInstituto() {}
    
    public static ManejadorInstituto getInstancia() {
        if(instancia == null)
            instancia = new ManejadorInstituto();
        return instancia;
    }
    
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
    
    public ArrayList<DtInstituto> getDtInstitutos() {
        ArrayList<DtInstituto> dtins = new ArrayList<DtInstituto>();
    	for(int i=0; i < institutos.size();i++) {
        	DtInstituto dti = new DtInstituto(institutos.get(i).getNombre());
    		dtins.add(dti);
        }
    	return dtins;
    }

}