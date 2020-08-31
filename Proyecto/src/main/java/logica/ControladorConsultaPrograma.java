package logica;

import java.util.ArrayList;

import datatypes.DtCurso;
import datatypes.DtPrograma;
import datatypes.DtProgramaBase;

public class ControladorConsultaPrograma implements interfaces.IControladorConsultaPrograma{
	private String programa;
	private String curso;
	
	
	public ControladorConsultaPrograma() {
		super();
	}
	@Override
	public ArrayList<DtProgramaBase> listarProgramas() {
		/*instanciar manejadorPrograma
		 * lista DtProgramaBase
		 * lista = manejador.getProgramas()
		 * 
		 * recorrer lista
		 * {
		 *  	for each c in lista{
		 *  		lista.add(c)
		 *  	}
		 * }
		 * return lista
		 */
		return null;
	}
	@Override
	public DtPrograma seleccionarPrograma(String nombre) {
		//busca un objeto programa con ese nombre en el manejadorPrograma.
		//construye el DtPrograma incluyendo todos los nombres de los cursos que este contiene
		//se necesita algo en la clase ProgFormacion (un getCursos) que devuelva los objetos Curso asociados a el
		//tambien getDtCursoBase en Curso.
		return null;
	}
	@Override
	public DtCurso seleccionarCurso(String nombre) {
		
		return null;
	}
}
