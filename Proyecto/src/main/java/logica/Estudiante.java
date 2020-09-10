package logica;

import java.util.ArrayList;

import datatypes.DtFecha;

public class Estudiante extends Usuario {
	ArrayList<InscripcionEd> inscripciones = new ArrayList<InscripcionEd>();
	
	public Estudiante(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public void agregarInscripcionEd(InscripcionEd i) {
		inscripciones.add(i);
	}
	
	public boolean existeInscripcion(String nomEd) {
		for(InscripcionEd i: inscripciones) {
	    		if(i.getEdicion().getNombre().equals(nomEd)) {
	    			return true;
	    		}
	    }
	    return false;
	}

}
