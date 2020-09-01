package logica;

import java.util.Map;
import datatypes.DtFecha;
import datatypes.DtTime;

public class ManejadorCurso {
	private static ManejadorCurso instancia = null;
	private Map<String, Curso> cursos;
	
	public ManejadorCurso() {}
	
	public static ManejadorCurso getInstancia() {
		if(instancia == null)
			instancia = new ManejadorCurso();
		return instancia;
	}
	
	public void agregarCurso(String nombre, String descripcion, String duracion, DtTime cantHoras, Integer creditos, DtFecha fechaR, String URL) {
		Curso c = new Curso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, URL);
		cursos.put(c.getNombre(), c);
	}
//desde aca es mio
	public Curso find(String curso) {
		return this.cursos.get(curso);
	}
	
	public Map<String, Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Map<String, Curso> cursos) {
		this.cursos = cursos;
	}
}
