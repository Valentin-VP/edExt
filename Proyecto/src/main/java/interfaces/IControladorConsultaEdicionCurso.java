package interfaces;

import logica.Edicion;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicion;
import java.util.*;
import excepciones.InstitutoInexistente;
import excepciones.CursoNoExiste;

public interface IControladorConsultaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente;
	
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso) throws CursoNoExiste;
	
	public DtEdicion seleccionarEdicion(String edicion);
	
	public void setEdicion(String edicion);
	
	public String getEdicion();
	
	public DtEdicion getDtEdicion();

	public ArrayList<String> getDocentes(String edicion);

}
