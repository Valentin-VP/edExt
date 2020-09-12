package logica;

import datatypes.DtFecha;
import datatypes.DtEdicionBase;

import java.time.LocalDate;
import java.util.ArrayList;

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
	private Instituto instituto;
	
	public Curso(String nombre, String descripcion, String duracion, int cantHoras, Integer creditos, DtFecha fechaR,
			String url, ArrayList<Curso> previas,Instituto instituto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.previas = previas;
		this.setInstituto(instituto);
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
	public DtEdicionBase getEdicionVigente() {
		LocalDate date = LocalDate.now();
		DtEdicionBase dteb=new DtEdicionBase();
		for(int i=0;i < ediciones.size();i++) {
			if (fechaValidaInicio(ediciones.get(i).getFechaI(),date) && fechaValidaFin(ediciones.get(i).getFechaF(),date)) {
			dteb.setNombre(ediciones.get(i).getNombre());
			return dteb;
			}
		}
		return null;
	}
		
	// if (ediciones.get(i).getFechaPub().getAnio().intValue() == 2000) {
	
	public void addEdicion(Edicion edi) {
		this.ediciones.add(edi);
	}
	
	public boolean fechaValidaInicio(DtFecha fecha,LocalDate date) {
		if(fecha.getAnio().intValue() > date.getYear()) {
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() > date.getMonthValue()) {
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() == date.getMonthValue() && fecha.getDia().intValue() > date.getDayOfMonth()) {
			return false;
		}
		return true;
	}
	
	public boolean fechaValidaFin(DtFecha fecha,LocalDate date) {
		if(fecha.getAnio().intValue() < date.getYear()) {
			System.out.print("Un anio antes");
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() < date.getMonthValue()) {
			System.out.print("Un mes antes");
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() == date.getMonthValue() && fecha.getDia().intValue() < date.getDayOfMonth()) {
			System.out.print("Un dia antes");
			return false;
		}
		return true;
	}

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	
}
