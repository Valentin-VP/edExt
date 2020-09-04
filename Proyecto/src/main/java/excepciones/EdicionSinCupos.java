package excepciones;

public class EdicionSinCupos extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EdicionSinCupos (String string) {
		super(string);
	}
}
