package excepciones;

public class SinUsuarios extends Exception{
	private static final long serialVersionUID = 1L;
	
	public SinUsuarios(String mensaje) {
		super(mensaje);
	}

}
