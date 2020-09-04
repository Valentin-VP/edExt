package excepciones;

public class CursoNoExiste extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CursoNoExiste(String string) {
		super(string);
	}

}
