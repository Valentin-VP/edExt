package interfaces;

import java.util.List;

import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.InstitutoInexistente;
import logica.Curso;
import logica.Edicion;

public interface IControladorListarAceptadosAUnaEdicionDeCurso {
	
	public List<Curso> IngresarInstituto(String instituto) throws InstitutoInexistente;
	
	public List<Edicion> IngresarCurso(String curso) throws CursoNoExiste;
	
	public List<String> IngresarEdicion(String edicion) throws EdicionNoExiste;

}
