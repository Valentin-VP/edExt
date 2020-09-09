package excepciones;

public class UsuarioNoExiste extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNoExiste(String texto) {
		super(texto);
	}
}
