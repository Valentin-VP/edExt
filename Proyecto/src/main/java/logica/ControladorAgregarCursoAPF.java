package logica;

import java.util.ArrayList;
import java.util.List;


import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;
import excepciones.AgregarCursoAPFException;
import interfaces.IControladorAgregarCursoAPF;

public class ControladorAgregarCursoAPF implements IControladorAgregarCursoAPF {

	
	public List<DtProgramaBase> getDtPFs() throws AgregarCursoAPFException {
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		List<DtProgramaBase> programas = new ArrayList<>();
		List<ProgFormacion> progForm = mP.getProgramas();
		if(progForm.size() > 0) {
			for(ProgFormacion p: progForm) {
				programas.add(new DtProgramaBase(p.getNombre()));
			}
			return programas;
		}
		throw new AgregarCursoAPFException("No existen Programas de formacion registrados");
	}
	
	public List<DtCursoBase> getDtCurso() throws AgregarCursoAPFException {
		List<DtCursoBase> cursos = new ArrayList<>();
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		for(Curso c: mC.getCursos()) {
			cursos.add(new DtCursoBase(c.getNombre()));
		}
		if(cursos.size()>0) {
			return cursos;
		}
		throw new AgregarCursoAPFException("No existen cursos registrados");
	}
	
	public void agregarCurso(String prog, String curso) {
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mP.find(prog);
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		p.addCursos(c);
	}
}

	