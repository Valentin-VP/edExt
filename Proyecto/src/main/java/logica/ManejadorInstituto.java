package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtInstituto;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstituto {
    private static ManejadorInstituto instancia;
    private List<Instituto> institutos = new ArrayList<Instituto>();

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


    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(List<Instituto> institutos) {
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