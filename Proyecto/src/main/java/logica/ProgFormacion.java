package logica;

import java.time.LocalDate;
import java.util.List;

import datatypes.DtFecha;
import datatypes.DtProgramaBase;

public class ProgFormacion {
	private String nombre;
	private String desc;
	private LocalDate fechaI;
	private LocalDate fechaF;
	private LocalDate fechaAlta;
	private List<Curso> cursos;
	public ProgFormacion(String nombre, String desc, LocalDate fechaI, LocalDate fechaF, LocalDate fechaAlta) {
		super();
		this.nombre = nombre;
		this.desc = desc;
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
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public DtProgramaBase getDtProgBase() {
		DtProgramaBase dtpb = new DtProgramaBase(this.nombre);
		return dtpb;
	}
}
