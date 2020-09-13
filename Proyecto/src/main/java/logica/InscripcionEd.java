package logica;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import datatypes.DtFecha;
import persistencia.InscripcionEdID;

@Entity
@IdClass(InscripcionEdID.class)
public class InscripcionEd { 
	private DtFecha fecha;
	
	@Id
	@ManyToOne
	private Edicion edicion;
	
	@Id
	@ManyToOne
	private Estudiante nick;
	
	public InscripcionEd () {
		super();
	}
	public InscripcionEd(DtFecha fecha, Edicion edicion, Estudiante nick) {
		super();
		this.fecha = fecha;
		this.edicion = edicion;
		this.nick = nick;
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
		return nick;
	}
	public void setEstudiante(Estudiante nick) {
		this.nick = nick;
	}
	
}
