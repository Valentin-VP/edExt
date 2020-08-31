package datatypes;

import datatypes.DtFecha;
import datatypes.DtTime;

public class DtCurso extends DtCursoBase {
	private String descripcion;
	private String duracion;
	private DtTime cantHoras;
	private Integer creditos;
	private DtFecha fechaR;
	private String URL;
	
	public DtCurso() {
		super();
	}

	public DtCurso(String descripcion, String duracion, DtTime cantHoras, Integer creditos, DtFecha fechaR,
			String uRL, String nombre) {
		super(nombre);
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		URL = uRL;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDuracion() {
		return duracion;
	}
	
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public DtTime getCantHoras() {
		return cantHoras;
	}
	
	public void setCantHoras(DtTime cantHoras) {
		this.cantHoras = cantHoras;
	}
	
	public Integer getCreditos() {
		return creditos;
	}
	
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	public DtFecha getFechaR() {
		return fechaR;
	}
	
	public void setFechaR(DtFecha fechaR) {
		this.fechaR = fechaR;
	}
	
	public String getURL() {
		return URL;
	}
	
	public void setURL(String uRL) {
		URL = uRL;
	}
	
}