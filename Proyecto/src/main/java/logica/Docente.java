package logica;

import java.util.*;
import datatypes.DtEdicion;
import datatypes.DtFecha;

public class Docente extends Usuario {
	private Instituto instituto;//visibilidad
	private ArrayList<Edicion> ediciones;//visibilidad
	
	public Docente(String nick, String nombre, String apellido, String correo, DtFecha fechaNac, Instituto instituto, ArrayList<Edicion> ediciones) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto = instituto;
		this.ediciones = ediciones;
	}

	public Docente(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public boolean find(DtEdicion edicion) {
		for (Edicion e: ediciones) {
			if (e.getNombre() == edicion.getNombre()) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarEdicion(Edicion edicion) {
		ediciones.add(edicion);
	}

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}

	public ArrayList<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(ArrayList<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
}
