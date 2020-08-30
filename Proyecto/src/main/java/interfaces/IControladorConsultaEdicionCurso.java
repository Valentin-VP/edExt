package interfaces;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicion;
import java.util.*;

public interface IControladorConsultaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto);
	
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso);
	
	public DtEdicion seleccionarEdicion(String edicion);
}
