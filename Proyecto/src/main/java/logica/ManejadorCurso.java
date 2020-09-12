package logica;

import java.util.ArrayList;

public class ManejadorCurso {
	private static ManejadorCurso instancia = null;
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	private ManejadorCurso() {}
	
	public static ManejadorCurso getInstancia() {
		if(instancia == null)
			instancia = new ManejadorCurso();
		return instancia;
	}
	
	public boolean exists(String nombre) {
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}

	public Curso find(String curso) {
		Curso retorno = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(curso)) {
				retorno =c ;
			}
		}
		return retorno;
	}
	
	public ArrayList<Curso> getCursos() { 
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) { 
		this.cursos = cursos;
	}
}
