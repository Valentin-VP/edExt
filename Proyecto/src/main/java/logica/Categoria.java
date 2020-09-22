package logica;

import java.util.ArrayList;

import java.util.List;

public class Categoria {
	private String nombre;
	private List<Curso> cursos = new ArrayList<>();
	
	public Categoria() {
		super();
	}
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void addCurso(Curso c) {
		cursos.add(c);
	}
}
