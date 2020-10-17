package interfaces;

import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;
import excepciones.SinCursos;
import excepciones.SinProgramas;

public interface IControladorAgregarCursoProgFormacion {

	public List<DtProgramaBase> getDtPFs() throws SinProgramas;
	
	public List<DtCursoBase> getDtCurso() throws SinCursos;
	
	public void agregarCurso(String prog, String curso);
}
