package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import logica.Curso;
import logica.Edicion;

public interface IControladorListarAceptadosAUnaEdicionDeCurso {
	
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;
	
	public List<DtCursoBase> ingresarInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos;
	
	public List<DtEdicionBase> ingresarCurso(String curso) throws CursoNoExiste, EdicionNoExiste;
	
	public DtEdicionCompleta ingresarEdicion(String edicion) throws EdicionNoExiste;

}
