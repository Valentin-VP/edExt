package logica;

import java.util.Map;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia;
	private Map<String,ProgFormacion> programas;
	
	public static ManejadorProgFormacion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorProgFormacion();
		return instancia;
	}
	
	public boolean exists(String nombre) {
		if(programas.containsKey(nombre))
			return true;
		else 
			return false;
	}
	
	public void agregarProgFormacion(ProgFormacion pf) {
		programas.put(pf.getNombre(), pf);
	}
	
	public ProgFormacion getProgFormacion(String nombre) {
		return programas.get(nombre); 
	}
}
