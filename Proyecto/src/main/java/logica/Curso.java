package logica;

import datatypes.DtTime;
import datatypes.DtFecha;
import datatypes.DtCurso;
import datatypes.DtEdicionBase;
import java.util.*;

public class Curso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private DtTime cantHoras;
	private Integer creditos;
	private DtFecha fechaR;
	private String URL;
	private ArrayList<DtCurso> previas;//visibilidad
	private ArrayList<DtEdicionBase> ediciones;//visibilidad
	
	public Curso(String nombre, String descripcion, String duracion, DtTime cantHoras, Integer creditos, DtFecha fechaR,
			String uRL) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		URL = uRL;
	}

	public Curso() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public ArrayList<DtCurso> getPrevias() {
		return previas;
	}

	public void setPrevias(ArrayList<DtCurso> previas) {
		this.previas = previas;
	}

	public ArrayList<DtEdicionBase> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(ArrayList<DtEdicionBase> ediciones) {
		this.ediciones = ediciones;
	}
	
}
