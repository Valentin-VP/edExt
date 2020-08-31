package logica;

import java.util.Map;
import logica.Instituto;

public class ManejadorInstituto {
	private ManejadorInstituto instancia;
	private Map<String,Instituto> institutos;
	
	public ManejadorInstituto() {}
	
	public ManejadorInstituto getInstancia() {
		if(this.instancia == null)
			instancia = new ManejadorInstituto();
		return instancia;
	}
	
	public boolean exists(String nombre) {
		if(institutos.containsKey(nombre))
			return true;
		else 
			return false;
	}
	
	public void agregarInstituto(String nombre) {
		Instituto i = new Instituto(nombre);
		institutos.put(i.getNombre(), i);
	}
	
}
