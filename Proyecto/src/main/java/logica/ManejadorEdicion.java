package logica;

import java.util.List;
import java.util.ArrayList;
import datatypes.DtFecha;

public class ManejadorEdicion {
	private static ManejadorEdicion instancia = null;
    private List<Edicion> ediciones = new ArrayList<>();
	
	public ManejadorEdicion() {}
	
	public static ManejadorEdicion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorEdicion();
		return instancia;
	}
	
	public boolean exists(String nombre) {
		for (Edicion e: ediciones) {
			if (e.getNombre() == nombre) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarEdicion(String nombre, DtFecha fechaI, DtFecha fechaF, boolean tieneCupos, Integer cupos, DtFecha fechaPub) {
		Edicion e = new Edicion(nombre, fechaI, fechaF,  tieneCupos, cupos, fechaPub);
		ediciones.add(e);
	}

	public Edicion find(String edicion) {
		for (Edicion e: ediciones) {
			if (e.getNombre() == edicion) {
				return e;
			}
		}
		return null;
	}
	
	public List<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
}
