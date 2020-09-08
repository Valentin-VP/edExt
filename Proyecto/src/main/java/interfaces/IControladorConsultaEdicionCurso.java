package interfaces;

import logica.Edicion;
import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import java.util.*;
import excepciones.CursoNoExiste;

public interface IControladorConsultaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws CursoNoExiste;
	
	public ArrayList<Edicion> seleccionarCurso(String curso);
	
	public DtEdicion seleccionarEdicion(String edicion);
}
