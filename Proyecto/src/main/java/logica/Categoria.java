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
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public String getInstitutoCurso(String curso) {
		String retorno = new String();
		for(Curso c: cursos) {
			if(c.getNombre().equals(curso)) {
				retorno = c.getInstituto().getNombre();
			}
		}
		return retorno;
	}
	
	public Curso findCurso(String curso, String instituto) {
		Curso retorno = new Curso();
		for(Curso c:cursos) {
			if(c.getNombre().equals(curso) && (c.getInstituto().getNombre().equals(instituto))) {
				retorno = c;
			}
		}
		return retorno;
	}
}
