package logica;

import datatypes.DtFecha;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtEdicion;

@Entity
public class Edicion {
	@Id
	private String nombre;
	
	private Date fechaI;
	private Date fechaF;
	private boolean tieneCupos;
	private Integer cupos;
	private Date fechaPub;
	
	@OneToMany(mappedBy = "edicion", cascade = CascadeType.ALL)
	private List<InscripcionEd> inscripciones = new ArrayList<>();
	
	public Edicion () {
		super();
	}
	public Edicion(String nombre, Date fechaI, Date fechaF, boolean tieneCupos, Integer cupos, Date fechaPub) {
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

	public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public Date getFechaF() {
		return fechaF;
	}

	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	public Date getFechaPub() {
		return fechaPub;
	}

	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}
	
	public List<InscripcionEd> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(List<InscripcionEd> inscripciones) {
		this.inscripciones = inscripciones;
	}
	public DtEdicion getDtEdicion() {
		
		DtFecha dtfechaI= convertToDtFecha(fechaI);
		DtFecha dtfechaF= convertToDtFecha(fechaF);
		DtFecha dtfechaPub = convertToDtFecha(fechaPub);
		
		DtEdicion edicion = new DtEdicion(this.nombre, dtfechaI, dtfechaF, this.tieneCupos, this.cupos, dtfechaPub);
		return edicion;
	}

	public DtFecha convertToDtFecha(Date fecha){
		ArrayList<Integer> datos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(fecha); 
		String valores [] = (date).split("/");
		for(String s: valores) {
			int temp = Integer.parseInt(s);
			datos.add(temp);
		}
		DtFecha dtfecha = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
		return dtfecha;
	}
	
	
	public boolean isTieneCupos() {
		return tieneCupos;
	}

	public void setTieneCupos(boolean tieneCupos) {
		this.tieneCupos = tieneCupos;
	}
	
	public void addInscripcion(InscripcionEd inscripcionEd) {
		this.inscripciones.add(inscripcionEd);
	}
}
