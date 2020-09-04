package excepciones;

public class CursoRepetido extends Exception{
	private static final long serialVersionUID = 1L;

	public CursoRepetido(String message) {
		super(message);
	}
	
}
