package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import excepciones.CursoNoExiste;

public interface IControladorAltaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto);
	
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste;
	
	public void ingresarCupos(Integer cupos) throws EdicionSinCupos;
	
	//public void modificarAltaEdicion(String nuevoNombre) throws EdicionRepetida;
	
	public void cancelarAltaEdicion();
	
	public void confirmarAltaEdicion();
}
