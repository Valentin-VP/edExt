package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtFecha;

public interface IControladorAltaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto);
	
	public Boolean altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes);
	
	public void ingresarCupos(Integer cupos);
	
	public Boolean modificarAltaEdicion(String nuevoNombre);
	
	public void cancelarAltaEdicion();
	
	public void confirmarAltaEdicion();
}
