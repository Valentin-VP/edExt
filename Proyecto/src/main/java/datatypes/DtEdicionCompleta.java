package datatypes;

import java.util.ArrayList;
import java.util.List;

public class DtEdicionCompleta extends DtEdicion{
	private List<DtInscripcionEd> inscripciones = new ArrayList<>();

	public DtEdicionCompleta() {
		super();
	}

	public DtEdicionCompleta(String nombre, DtFecha fechaI, DtFecha fechaF, boolean tieneCupos, Integer cupo, DtFecha fechaPub,List<DtInscripcionEd> inscripciones) {
		super(nombre,fechaI,fechaF,tieneCupos,cupo,fechaPub);
		this.inscripciones = inscripciones;
	}

	public List<DtInscripcionEd> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<DtInscripcionEd> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	
}
