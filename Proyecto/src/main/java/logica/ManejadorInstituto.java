package logica;

import java.util.HashMap;


public class ManejadorInstituto {
    private static ManejadorInstituto instancia;
    private HashMap<String,Instituto> institutos = new HashMap<>();

    public ManejadorInstituto() {}

    public static ManejadorInstituto getInstancia() {
        if(instancia == null)
            instancia = new ManejadorInstituto();
        return instancia;
    }

    public boolean exists(String nombre) {
        if(institutos.containsKey(nombre)) {
            return true;
        }else { 
           return false;
        }
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