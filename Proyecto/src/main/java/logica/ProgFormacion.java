package logica;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtFecha;
import datatypes.DtProgramaBase;
@Entity
public class ProgFormacion {
	@Id
	private String nombre;
	private String descripcion;
	private LocalDate fechaI;
	private LocalDate fechaF;
	private LocalDate fechaAlta;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Curso> cursos = new ArrayList<Curso>();
	
	@OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
	private List<InscripcionPF> inscripciones = new ArrayList <InscripcionPF>();
	
	public ProgFormacion() {
		super();
	}
	public ProgFormacion(String nombre, String descripcion, LocalDate fechaI, LocalDate fechaF, LocalDate fechaAlta) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return descripcion;
	}
	public void setDesc(String descripcion) {
		this.descripcion = descripcion;
	}
	public DtFecha getFechaI() {
		DtFecha fechaI = new DtFecha(this.fechaI.getDayOfMonth(),this.fechaI.getMonthValue(),this.fechaI.getYear());
		return fechaI;
	}
	public void setFechaI(LocalDate fechaI) {
		this.fechaI = fechaI;
	}
	public DtFecha getFechaF() {
		DtFecha fechaF = new DtFecha(this.fechaF.getDayOfMonth(),this.fechaF.getMonthValue(),this.fechaF.getYear());
		return fechaF;
	}
	public void setFechaF(LocalDate fechaF) {
		this.fechaF = fechaF;
	}
	public DtFecha getFechaAlta() {
		DtFecha fechaA = new DtFecha(this.fechaAlta.getDayOfMonth(),this.fechaAlta.getMonthValue(),this.fechaAlta.getYear());
		return fechaA;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void addCursos(Curso cursos) {
		this.cursos.add(cursos);
	}
	public DtProgramaBase getDtProgBase() {
		DtProgramaBase dtpb = new DtProgramaBase(this.nombre);
		return dtpb;
	}
}
