package excepciones;

public class InstitutoSinCursos extends Exception{
	private static final long serialVersionUID = 1L;

	public InstitutoSinCursos(String message) {
		super(message);
	}
	
}

