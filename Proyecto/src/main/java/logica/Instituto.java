package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtCursoBase;

@Entity
public class Instituto {
	@Id
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Curso> cursos = new ArrayList<Curso>();
	
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

	public List<Curso> getCursos() {
		return cursos;
	}
	
	public ArrayList<DtCursoBase> getDtCursosBase() {
		ArrayList<DtCursoBase> dtcursos = new ArrayList<DtCursoBase>();
		for (int i=0;i < cursos.size(); i++) {
			DtCursoBase dtc = new DtCursoBase(cursos.get(i).getNombre());
			dtcursos.add(dtc);
		}
		return dtcursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void agregarCurso(Curso curso) {
		this.cursos.add(curso);
	}
	
	public boolean existsCurso(String curso) {
		if(!cursos.isEmpty()) {
			for(Curso c: cursos) {
				if(c.getNombre().equals(curso))
					return true;
			}
		}
		return false;
	}
	
	public Curso findCurso(String curso) {
		Curso retorno = new Curso();
		for(Curso c: cursos){
			if(c.getNombre().equals(curso)){
				retorno=c;
			}
		}
		return retorno;
	}
}
