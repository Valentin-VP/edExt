package excepciones;

public class ProgramaSinCursos extends Exception{
	private static final long serialVersionUID = 1L;

	public ProgramaSinCursos(String mensaje) {
		super(mensaje);
	} 
}
