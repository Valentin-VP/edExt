package logica;

import datatypes.DtTime;
import datatypes.DtFecha;
import datatypes.DtCurso;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import java.util.*;

public class Curso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private DtTime cantHoras;
	private Integer creditos;
	private DtFecha fechaR;
	private String url;
	private ArrayList<String> previas;//visibilidad <-- Modifiqu� a String en vez de Curso, verificar (rcastro)
	private ArrayList<DtEdicionBase> ediciones;//visibilidad
	
	public Curso(String nombre, String descripcion, String duracion, DtTime cantHoras, Integer creditos, DtFecha fechaR,
			String url, List<String> list) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<String> getPrevias() {
		//Controlar en llamado si tiene elementos
		return previas;
	}

	public void setPrevias(ArrayList<String> previas) {
		this.previas = previas;
	}

	public ArrayList<DtEdicionBase> getEdiciones() {
		return ediciones;
	}
	
	// Para obtener la edicion vigente del curso -- Mauri
	public DtEdicionBase getEdicionVigente() {
		DtEdicionBase dteb=null;
			for(int i=0;i < ediciones.size();i++) {
				if(dteb instanceof DtEdicion) {
					if ( ((DtEdicion) ediciones.get(i)).getFechaPub().getAnio() == 2020 ) {
						return dteb;
					}
				}
			}
		return dteb;
	}
	
	public void setEdiciones(ArrayList<DtEdicionBase> ediciones) {
		this.ediciones = ediciones;
	}
	
}
