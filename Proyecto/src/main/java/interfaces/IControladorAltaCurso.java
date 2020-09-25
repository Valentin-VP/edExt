package interfaces;

import java.util.ArrayList;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.SinCategorias;
import datatypes.DtCursoBase;
import datatypes.DtFecha;

public interface IControladorAltaCurso {
	public void altaCurso (String instituto,String nombre,String descripcion,String duracion,int cantHoras,int creditos,String url,DtFecha fechaR) throws CursoRepetido, InstitutoInexistente;
	
	public void confirmarAltaCurso();
	
	public void cancelarAltaCurso();

	public void setPrevias(ArrayList<DtCursoBase> previas);
	
	public void agregarPrevia(String previa);
	
	public ArrayList<String> listarCategorias() throws SinCategorias;

	public void agregarCategoria(String categoria);

	public void cleanCategorias();
	
}
