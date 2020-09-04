package excepciones;

public class EdicionRepetida extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EdicionRepetida(String string) {
		super(string);
	}
}
