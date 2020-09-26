package excepciones;

public class CategoriaSinCursos extends Exception{
	private static final long serialVersionUID = 1L;

	public CategoriaSinCursos(String message) {
		super(message);
	}
	
}