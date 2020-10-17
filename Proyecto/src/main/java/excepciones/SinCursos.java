package excepciones;

public class SinCursos extends Exception{
	private static final long serialVersionUID = 1L;

	public SinCursos(String mensaje) {
		super(mensaje);
	}
	
}
