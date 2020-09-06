package logica;

import java.util.ArrayList;
import java.util.List;
import datatypes.DtFecha;
import datatypes.DtTime;

public class ManejadorCurso {
	private static ManejadorCurso instancia = null;
	private List<Curso> cursos = new ArrayList<>();
	
	public ManejadorCurso() {}
	
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
//desde aca es mio  ***Completé este método como ejemplo de los find con List, pero podemos dejarlo como Map (rcastro)***
	public Curso find(String curso) {
		Curso retorno = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(curso)) {
				retorno =c ;
			}
		}
		return retorno;
	}
	
	public List<Curso> getCursos() { // Modifiqué a List en vez de Map, revisar en equipo (rcastro)
		return cursos;
	}

	public void setCursos(List<Curso> cursos) { // Modifiqué a List en vez de Map, revisar en equipo (rcastro)
		this.cursos = cursos;
	}
}
