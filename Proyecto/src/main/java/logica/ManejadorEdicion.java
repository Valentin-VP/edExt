package logica;

import java.util.*;
import datatypes.DtFecha;

public class ManejadorEdicion {
	private static ManejadorEdicion instancia = null;
	private Map<String, Edicion> ediciones;
	
	public ManejadorEdicion() {}
	
	public static ManejadorEdicion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorEdicion();
		return instancia;
	}
	
	public void agregarEdicion(String nombre, DtFecha fechaI, DtFecha fechaF, Integer cupos, DtFecha fechaPub) {
		Edicion e = new Edicion(nombre, fechaI, fechaF, cupos, fechaPub);
		ediciones.put(e.getNombre(), e);
	}
//desde aca es mio
	public Edicion find(String edicion) {
		return this.ediciones.get(edicion);
	}
	
	public Map<String, Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(Map<String, Edicion> ediciones) {
		this.ediciones = ediciones;
	}
}
