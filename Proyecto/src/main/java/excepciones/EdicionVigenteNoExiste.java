package excepciones;

public class EdicionVigenteNoExiste extends Exception{
	private static final long serialVersionUID = 1L;
	
	public EdicionVigenteNoExiste(String mensaje) {
		super(mensaje);
	}
}
