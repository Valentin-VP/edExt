package logica;

import java.util.*;

import datatypes.DtProgramaBase;

public class ProgFormacion {
	private String nombre;
	private String desc;
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	private ArrayList<Curso> cursos;
	public ProgFormacion(String nombre, String desc, Date fechaI, Date fechaF, Date fechaAlta,
			ArrayList<Curso> cursos) {
		super();
		this.nombre = nombre;
		this.desc = desc;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
		this.cursos = cursos;
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
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public DtProgramaBase getDtProgBase() {
		DtProgramaBase dtpb = new DtProgramaBase(this.nombre);
		return dtpb;
	}
	
}
