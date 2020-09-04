package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;

public interface IControladorAltaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto);
	
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, Integer cupos, boolean tieneCupos, DtFecha fechaPub) throws EdicionRepetida;
	
	public void ingresarCupos(Integer cupos) throws EdicionSinCupos;
	
	//public void modificarAltaEdicion(String nuevoNombre) throws EdicionRepetida;
	
	public void cancelarAltaEdicion();
	
	public void confirmarAltaEdicion();
}
