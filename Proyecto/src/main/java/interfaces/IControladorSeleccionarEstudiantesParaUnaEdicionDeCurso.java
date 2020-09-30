package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;

public interface IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso {

	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos;
	
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste;
}
