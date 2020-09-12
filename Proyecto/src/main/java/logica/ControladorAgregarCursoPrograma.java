package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;

public class ControladorAgregarCursoPrograma implements interfaces.IControladorAgregarCursoPrograma{
	private String programa;
	private String curso;
	
	public ControladorAgregarCursoPrograma() {
		super();
	}
	
	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public ArrayList<DtCursoBase> listarCursos() {
		/*instanciar manejadorCursos
		 * lista DtCursoBase
		 * lista = manejador.getCursos()
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
	public void seleccionarPrograma(String programa) {
		this.setPrograma(programa);
	}
	@Override
	public void seleccionarCurso(String curso) {
		this.setCurso(curso);
		//agregar un confirmar/cancelar???
		//crear el link desde Prog a Curso.
	}
	
	

}
