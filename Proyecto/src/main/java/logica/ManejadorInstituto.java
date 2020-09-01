package logica;

import java.util.Map;
import logica.Instituto;

public class ManejadorInstituto {
	private static ManejadorInstituto instancia;
	private Map<String,Instituto> institutos;
	
	public ManejadorInstituto() {}
	
	public static ManejadorInstituto getInstancia() {
		if(instancia == null)
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
//desde aca es mio
	public Instituto find(String instituto) {
		return this.institutos.get(instituto);
	}
	
	public Map<String, Instituto> getInstitutos() {
		return institutos;
	}

	public void setInstitutos(Map<String, Instituto> institutos) {
		this.institutos = institutos;
	}
	
}
