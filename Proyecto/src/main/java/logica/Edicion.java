package logica;

import datatypes.DtFecha;
import datatypes.DtEdicion;

public class Edicion {
	private String nombre;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private Integer cupos;
	private DtFecha fechaPub;
	
	public Edicion(String nombre, DtFecha fechaI, DtFecha fechaF, Integer cupos, DtFecha fechaPub) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
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
	
	/*public DtEdicion getDtEdicion(String edicion) {
		//retorna un datatype con la informacion de "edicion"
	}*/
	
}
