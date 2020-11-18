package logica;

import java.util.ArrayList;
import java.util.List;


import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.ProgramaInexistente;
import excepciones.SinCursos;
import excepciones.SinProgramas;
import interfaces.IControladorAgregarCursoProgFormacion;

public class ControladorAgregarCursoProgFormacion implements IControladorAgregarCursoProgFormacion {
	
	private String programa = null;
	private String cursoc = null;
	@Override
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
	@Override
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
	@Override
	public void agregarCurso(String prog, String curso) throws CursoNoExiste, CursoRepetido, ProgramaInexistente{
		this.programa = prog;
		this.cursoc=curso;
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mP.find(prog);
		if (p==null) {
			throw new ProgramaInexistente("Ese programa no existe en el sistema.");
		}else {
			ManejadorCurso mC = ManejadorCurso.getInstancia();
			Curso c = mC.find(curso);
			if (c==null) {
				throw new CursoNoExiste("Ese curso no existe en el sistema.");
			}
			List<DtCursoBase> cursos = p.getCursosBase();
			for (DtCursoBase dtcb: cursos) {
				if (dtcb.getNombre().equals(curso)) 
					throw new CursoRepetido("El programa posee el curso ingresado.");
			}
		}
		
	}
	@Override
	public void confirmar() {
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		ProgFormacion p = mP.find(programa);
		
		Curso c = mC.find(cursoc);
		p.addCursos(c);
		mP.agregarProgFormacion(p);
		this.programa = null;
		this.cursoc = null;
	}
	
}

	