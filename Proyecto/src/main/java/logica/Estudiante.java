package logica;

import java.util.ArrayList;

public class Estudiante extends Usuario {
	ArrayList<InscripcionEd> inscripciones = new ArrayList<InscripcionEd>();
	
	public void agregarInscripcionEd(InscripcionEd i) {
		inscripciones.add(i);
	}
	
	public boolean existeInscripcion(String nomEd) {
		for(InscripcionEd i: inscripciones) {
	    		if(i.getEdicion().getNombre()==nomEd) {
	    			return true;
	    		}
	    }
	    return false;
	}

}
