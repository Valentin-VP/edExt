package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtInscripcionEd;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;

public interface IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso {

	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos;
	
	public DtEdicionCompleta seleccionarCurso(String nomCurso, String nick) throws EdicionVigenteNoExiste;
	
	public List<DtInscripcionEd> ordenarInscripciones(String ordenarpor);
	
	public void cambiarEstadoInscripcion(String nick, String estado);
	
	public void confirmarSeleccion();
	
	public void limpiar();
	
}
