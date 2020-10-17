package logica;

import java.util.ArrayList;
import java.util.List;


import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;
import excepciones.SinCursos;
import excepciones.SinProgramas;
import interfaces.IControladorAgregarCursoProgFormacion;

public class ControladorAgregarCursoProgFormacion implements IControladorAgregarCursoProgFormacion {
	
	public List<DtProgramaBase> getDtPFs() throws SinProgramas {
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		List<DtProgramaBase> programas = new ArrayList<>();
		List<ProgFormacion> progForm = mP.getProgramas();
		if(progForm.isEmpty()) {
			throw new SinProgramas("No existen Programas de formacion registrados");
		}
		for(ProgFormacion p: progForm) {
			programas.add(new DtProgramaBase(p.getNombre()));
		}
		return programas;
	}
	
	public List<DtCursoBase> getDtCurso() throws SinCursos {
		List<DtCursoBase> cursos = new ArrayList<>();
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		if(mC.getCursos().isEmpty()) {
			throw new SinCursos("No existen cursos registrados");
		}
		for(Curso c: mC.getCursos()) {
			cursos.add(new DtCursoBase(c.getNombre()));
		}
		return cursos;
	}
	
	public void agregarCurso(String prog, String curso) {
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mP.find(prog);
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		p.addCursos(c);
	}
}

	