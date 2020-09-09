package excepciones;

public class UsuarioNoDocente extends Exception {
	private static final long serialVersionUID = 1L;

	public UsuarioNoDocente(String texto) {
		super(texto);
	} 
}
