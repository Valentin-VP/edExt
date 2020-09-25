package interfaces;

import java.util.ArrayList;
import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtPrograma;
import datatypes.DtProgramaBase;
import excepciones.ProgramaSinCursos;
import excepciones.SinProgramas;

public interface IControladorConsultaPrograma {
	public ArrayList<DtProgramaBase> listarProgramas() throws SinProgramas;
	
	public ArrayList<DtCurso> listarCursosPrograma(String programa) throws ProgramaSinCursos;
	
	public DtPrograma seleccionarPrograma(String nombre)  throws ProgramaSinCursos;
	
	public DtCurso seleccionarCurso(String nombre);
}
