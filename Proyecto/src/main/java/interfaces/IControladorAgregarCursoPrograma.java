package interfaces;

import java.util.*;

import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;

public interface IControladorAgregarCursoPrograma {
	public ArrayList<DtCursoBase> listarCursos();
	
	public ArrayList<DtProgramaBase> listarProgramas();
	
	public void seleccionarPrograma(String programa);
	
	public void seleccionarCurso(String curso);
}
