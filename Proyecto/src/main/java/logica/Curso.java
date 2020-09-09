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
	private int cantHoras;
	private Integer creditos;
	private DtFecha fechaR;
	private String url;
	private ArrayList<Curso> previas = new ArrayList<Curso>();
	private ArrayList<Edicion> ediciones = new ArrayList<Edicion>();
	
	public Curso(String nombre, String descripcion, String duracion, int cantHoras, Integer creditos, DtFecha fechaR,
			String url, ArrayList<Curso> previas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.previas = previas;
	}
	
	public Edicion findEdicion(String edicion) {
		for (Edicion e: ediciones) {
			if (e.getNombre().equals(edicion)) {
				return e;
			}
		}
		return null;
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

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
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

	public ArrayList<Curso> getPrevias() {
		//Controlar en llamado si tiene elementos
		return previas;
	}

	public void setPrevias(ArrayList<Curso> previas) {
		this.previas = previas;
	}

	public ArrayList<Edicion> getEdiciones() {
		return ediciones;
	}
	
	// Para obtener la edicion vigente del curso -- Mauri
		// Revisar
		public DtEdicionBase getEdicionVigente() {
			DtEdicionBase dteb=new DtEdicionBase();
				for(int i=0;i < ediciones.size();i++) {
					//if(dteb instanceof DtEdicion) {
						if (ediciones.get(i).getFechaPub().getAnio() == 2020 ) {
							dteb.setNombre(ediciones.get(i).getNombre());
							return dteb;
						//}
					}
				}
			return null;
		}
		
	
	public void setEdiciones(ArrayList<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
}
