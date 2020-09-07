package interfaces;

import datatypes.DtCursoBase;
import logica.Edicion;
import datatypes.DtEdicion;
import java.util.*;

public interface IControladorConsultaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto);
	
	public ArrayList<Edicion> seleccionarCurso(String curso);
	
	public DtEdicion seleccionarEdicion(String edicion);
}
