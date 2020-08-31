package interfaces;

import java.util.*;
import datatypes.DtTime;
import datatypes.DtFecha;

public interface IControladorAltaCurso {
	public boolean altaCurso (String instituto,String nombre,String descripcion,String duracion,DtTime cantHoras,int creditos,String url,DtFecha fechaR);
	
	public void setPrevias (String previas);
	
	public boolean modificarAltacurso (String nombre);
	
	public void confirmarAltaCurso();
	
	public void cancelarAltaCurso();
	
}
