package logica;

import javax.persistence.Entity;
import javax.persistence.IdClass;

import datatypes.DtFecha;
import persistencia.InscripcionEdID;

@Entity
@IdClass(InscripcionEdID.class)
public class InscripcionEd { //faltan los @Id
	private DtFecha fecha;
	private Edicion edicion;
	private Estudiante estudiante;
	
	public InscripcionEd () {
		super();
	}
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
