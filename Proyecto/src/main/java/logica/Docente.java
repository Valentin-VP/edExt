package logica;

import java.util.*;
//import datatypes.DtEdicion;
import datatypes.DtFecha;

public class Docente extends Usuario {
	private Instituto instituto;//visibilidad
	private ArrayList<Edicion> dicta;//visibilidad
	
	public Docente(String nick, String nombre, String apellido, String correo, DtFecha fechaNac, Instituto instituto) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto = instituto;
	}

	public Docente(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public boolean find(Edicion edicion) {
		for (Edicion e: dicta) {
			if (e.getNombre() == edicion.getNombre()) {
				return true;
			}
		}
		return false;
	}
	
	public void addDictaEdicion(Edicion edi) {
		this.dicta.add(edi);
	}

	public Instituto getInstituto() {
		return this.instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}

	public ArrayList<Edicion> getEdiciones() {
		return dicta;
	}

	public void setEdiciones(ArrayList<Edicion> ediciones) {
		this.dicta = ediciones;
	}
	
}
