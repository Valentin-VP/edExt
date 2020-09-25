package excepciones;

public class SinProgramas extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SinProgramas(String string) {
		super(string);
	}
}
