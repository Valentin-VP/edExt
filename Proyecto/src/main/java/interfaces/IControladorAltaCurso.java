package interfaces;

import java.util.*;
import datatypes.DtTime;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import datatypes.DtFecha;

public interface IControladorAltaCurso {
	public void altaCurso (String instituto,String nombre,String descripcion,String duracion,DtTime cantHoras,int creditos,String url,DtFecha fechaR) throws CursoRepetido, InstitutoInexistente;
	
	public boolean modificarAltacurso (String nombre);
	
	public void confirmarAltaCurso();
	
	public void cancelarAltaCurso();

	public void setPrevias(List<String> previas);
	
}
