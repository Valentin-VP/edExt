package interfaces;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicion;
import java.util.ArrayList;
import excepciones.InstitutoInexistente;
import excepciones.CategoriaInexistente;
import excepciones.CursoNoExiste;

public interface IControladorConsultaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente;
	
	public ArrayList<DtCursoBase> seleccionarCategoria(String categoria) throws CategoriaInexistente;
	
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso, boolean conCategoria) throws CursoNoExiste;
	
	public DtEdicion seleccionarEdicion(String edicion);
	
	public void setEdicion(String edicion);
	
	public String getEdicion();

	public String getInstituto();
	
	public String getCurso();
	
	public DtEdicion getDtEdicion(String instituto, String curso, String edicion);

	public ArrayList<String> getDocentes(String edicion);

}
