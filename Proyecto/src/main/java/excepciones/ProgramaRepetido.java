package excepciones;

public class ProgramaRepetido extends Exception{
	private static final long serialVersionUID = 1L;

	public ProgramaRepetido(String nombre) {
		super(nombre);
	} 
}
