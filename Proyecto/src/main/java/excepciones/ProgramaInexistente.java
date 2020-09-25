package excepciones;

public class ProgramaInexistente  extends Exception{
	private static final long serialVersionUID = 1L;

	public ProgramaInexistente(String message) {
		super(message);
	}
}
