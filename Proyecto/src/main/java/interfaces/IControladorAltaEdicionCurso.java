package interfaces;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import excepciones.CursoNoExiste;
import datatypes.DtUsuarioBase;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;

public interface IControladorAltaEdicionCurso {
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente;
	
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<DtUsuarioBase> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente;
	
	//public void ingresarCupos(Integer cupos) throws EdicionSinCupos;
	
	//public void modificarAltaEdicion(String nuevoNombre) throws EdicionRepetida;
	
	//public void cancelarAltaEdicion();
	
	//public void confirmarAltaEdicion();
	
	public ArrayList<DtUsuarioBase> getUsuarios();
	
	public void listarEdiciones();
}
