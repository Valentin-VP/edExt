package interfaces;

import java.util.*;
import datatypes.DtInstituto;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import datatypes.DtProgramaBase;
import datatypes.DtCurso;
import datatypes.DtCursoBase;

public interface IControladorConsultaCurso {
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos;
	
	public DtCurso consultarCurso(String curso);
	
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;

	public ArrayList<DtProgramaBase> getProgramas();
}
