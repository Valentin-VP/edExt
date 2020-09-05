package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import excepciones.InstitutoInexistente;
import datatypes.DtCurso;

public interface IControladorConsultaCurso {
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente;
	
	public DtCurso consultarCurso(String curso);
	
}
