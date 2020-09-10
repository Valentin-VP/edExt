package excepciones;

public class UsuarioNoEstudiante extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UsuarioNoEstudiante(String mensaje) {
		super(mensaje);
	}
	
}
