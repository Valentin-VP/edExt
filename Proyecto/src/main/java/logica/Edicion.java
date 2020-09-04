package logica;

import datatypes.DtFecha;
import datatypes.DtEdicion;

public class Edicion {
	private String nombre;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private boolean tieneCupos;
	private Integer cupos;
	private DtFecha fechaPub;
	
	public Edicion(String nombre, DtFecha fechaI, DtFecha fechaF, boolean tieneCupos, Integer cupos, DtFecha fechaPub) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.tieneCupos = tieneCupos;
		this.cupos = cupos;
		this.fechaPub = fechaPub;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DtFecha getFechaI() {
		return fechaI;
	}

	public void setFechaI(DtFecha fechaI) {
		this.fechaI = fechaI;
	}

	public DtFecha getFechaF() {
		return fechaF;
	}

	public void setFechaF(DtFecha fechaF) {
		this.fechaF = fechaF;
	}

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	public DtFecha getFechaPub() {
		return fechaPub;
	}

	public void setFechaPub(DtFecha fechaPub) {
		this.fechaPub = fechaPub;
	}
	
	public DtEdicion getDtEdicion() {
		DtEdicion edicion = new DtEdicion(this.nombre, this.fechaI, this.fechaF, this.tieneCupos, this.cupos, this.fechaPub);
		return edicion;
	}

	public boolean isTieneCupos() {
		return tieneCupos;
	}

	public void setTieneCupos(boolean tieneCupos) {
		this.tieneCupos = tieneCupos;
	}
	
}
