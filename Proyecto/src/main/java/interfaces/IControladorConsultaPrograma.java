package interfaces;

import java.util.*;

import datatypes.DtCurso;
import datatypes.DtPrograma;
import datatypes.DtProgramaBase;

public interface IControladorConsultaPrograma {
	public ArrayList<DtProgramaBase> listarProgramas();
	
	public DtPrograma seleccionarPrograma(String nombre);
	
	public DtCurso seleccionarCurso(String nombre);
}
