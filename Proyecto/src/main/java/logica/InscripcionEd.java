package logica;

import datatypes.DtFecha;

public class InscripcionEd {
	private DtFecha fecha;
	private Edicion edicion;
	private Estudiante estudiante;
	
	public InscripcionEd(DtFecha fecha, Edicion edicion, Estudiante estudiante) {
		super();
		this.fecha = fecha;
		this.edicion = edicion;
		this.estudiante = estudiante;
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
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
}
