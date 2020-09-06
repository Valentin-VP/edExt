package interfaces;

import java.util.*;
import datatypes.DtTime;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import logica.Curso;
import datatypes.DtFecha;

public interface IControladorAltaCurso {
	public void altaCurso (String instituto,String nombre,String descripcion,String duracion,int cantHoras,int creditos,String url,DtFecha fechaR) throws CursoRepetido, InstitutoInexistente;
	
	public void confirmarAltaCurso();
	
	public void cancelarAltaCurso();

	public void setPrevias(ArrayList<Curso> previas);
	
}
