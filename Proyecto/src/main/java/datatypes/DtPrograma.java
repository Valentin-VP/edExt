package datatypes;

import java.util.*;

import datatypes.DtCursoBase;

public class DtPrograma extends DtProgramaBase{
	private String desc;
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	private ArrayList<DtCursoBase> cursos;
	public DtPrograma(String nombre, String desc, Date fechaI, Date fechaF, Date fechaAlta,
			ArrayList<DtCursoBase> cursos) {
		super(nombre);
		this.desc = desc;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
		this.cursos = cursos;
	}
	public String getDesc() {
		return desc;
	}
	public Date getFechaI() {
		return fechaI;
	}
	public Date getFechaF() {
		return fechaF;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public ArrayList<DtCursoBase> getCursos() {
		return cursos;
	}

}
