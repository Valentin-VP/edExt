package datatypes;

import java.util.ArrayList;

public class DtCurso extends DtCursoBase {
	private String descripcion;
	private String duracion;
	private int cantHoras;
	private Integer creditos;
	private DtFecha fechaR;
	private String url;
	private ArrayList<DtEdicionBase> ediciones = new ArrayList<DtEdicionBase>();
	private ArrayList<DtCursoBase> previas = new ArrayList<DtCursoBase>();
	private ArrayList <String> categorias;
	
	public DtCurso() {
		super();
	}

	public DtCurso(String descripcion, String duracion, int cantHoras, Integer creditos, DtFecha fechaR, String url, String nombre, ArrayList<DtEdicionBase> ediciones, ArrayList<DtCursoBase> previas, ArrayList <String> categorias) {
		super(nombre);
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.ediciones = ediciones;
		this.previas = previas;
		this.categorias = categorias;
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

	public ArrayList<DtEdicionBase> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(ArrayList<DtEdicionBase> ediciones) {
		this.ediciones = ediciones;
	}

	public ArrayList<DtCursoBase> getPrevias() {
		return previas;
	}

	public void setPrevias(ArrayList<DtCursoBase> previas) {
		this.previas = previas;
	}


	public ArrayList<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
	}

	
}
