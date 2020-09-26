package interfaces;

import java.util.ArrayList;
import datatypes.DtInstituto;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;
import datatypes.DtProgramaBase;
import datatypes.DtCurso;
import datatypes.DtCursoBase;

public interface IControladorConsultaCurso {
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos;
	
	public ArrayList<DtCursoBase> listarCursosCategoria(String categoria) throws CategoriaInexistente, CategoriaSinCursos;
	
	public DtCurso consultarCurso(String curso);
	
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;
	
	public ArrayList<String> listarCategorias() throws SinCategorias;

	public ArrayList<DtProgramaBase> getProgramas();
}
