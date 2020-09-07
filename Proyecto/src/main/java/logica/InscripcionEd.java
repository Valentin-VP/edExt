package logica;

import datatypes.DtFecha;

public class InscripcionEd {
	private DtFecha fecha;
	private Edicion edicion;
	
	public InscripcionEd(DtFecha fecha, Edicion edicion) {
		super();
		this.fecha = fecha;
		this.edicion = edicion;
	}
	public DtFecha getFecha() {
		return fecha;
	}
	public void setFecha(DtFecha fecha) {
		this.fecha = fecha;
	}
	public Edicion getEdicion() {
		return edicion;
	}
	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}
	
}
