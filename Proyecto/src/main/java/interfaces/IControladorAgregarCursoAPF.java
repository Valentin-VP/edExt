package interfaces;

import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;
import excepciones.AgregarCursoAPFException;

public interface IControladorAgregarCursoAPF {

	public List<DtProgramaBase> getDtPFs() throws AgregarCursoAPFException;
	
	public List<DtCursoBase> getDtCurso() throws AgregarCursoAPFException;
	
	public void agregarCurso(String prog, String instituto, String curso);
}
