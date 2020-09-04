package excepciones;

public class InstitutoInexistente extends Exception{
	private static final long serialVersionUID = 1L;

	public InstitutoInexistente(String message) {
		super(message);
	}
	
}
