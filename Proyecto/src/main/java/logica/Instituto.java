package logica;

import java.util.*;
import datatypes.DtCursoBase;

public class Instituto {
	private String nombre;
	private ArrayList<DtCursoBase> cursos = new ArrayList<DtCursoBase>();
	
	public Instituto() {
		super();
	}
	
	public Instituto(String nombre) {
		super();
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<DtCursoBase> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<DtCursoBase> cursos) {
		this.cursos = cursos;
	}
	
}
