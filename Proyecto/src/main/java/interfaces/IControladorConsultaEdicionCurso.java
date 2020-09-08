package interfaces;

import logica.Edicion;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicion;
import java.util.*;
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;

public interface IControladorConsultaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws CursoNoExiste;
	
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso) throws EdicionNoExiste;
	
	public DtEdicion seleccionarEdicion(String edicion);
}
