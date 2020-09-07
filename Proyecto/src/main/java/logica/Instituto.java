package logica;

import java.util.*;
import datatypes.DtCursoBase;

public class Instituto {
	private String nombre;
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
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

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void agregarCurso(Curso curso) {
		this.cursos.add(curso);
	}
	
}
