package logica;

import java.util.ArrayList;
import datatypes.DtFecha;
import datatypes.DtProgramaBase;

public class ProgFormacion {
	private String nombre;
	private String desc;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private DtFecha fechaAlta;
	private ArrayList<Curso> cursos;
	public ProgFormacion(String nombre, String desc, DtFecha fechaI, DtFecha fechaF, DtFecha fechaAlta) {
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
		return fechaI;
	}
	public void setFechaI(DtFecha fechaI) {
		this.fechaI = fechaI;
	}
	public DtFecha getFechaF() {
		return fechaF;
	}
	public void setFechaF(DtFecha fechaF) {
		this.fechaF = fechaF;
	}
	public DtFecha getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(DtFecha fechaAlta) {
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
