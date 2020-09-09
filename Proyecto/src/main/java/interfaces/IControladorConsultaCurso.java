package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtInstituto;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import datatypes.DtCurso;

public interface IControladorConsultaCurso {
	public ArrayList<DtCurso> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos;
	
	public DtCurso consultarCurso(String curso);
	
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;
}
