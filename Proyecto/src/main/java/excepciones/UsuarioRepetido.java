package excepciones;

public class UsuarioRepetido extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UsuarioRepetido(String string) {
		super(string);
	} 
}
