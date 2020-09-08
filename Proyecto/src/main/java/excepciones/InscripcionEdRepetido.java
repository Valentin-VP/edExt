package excepciones;

public class InscripcionEdRepetido extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InscripcionEdRepetido(String mensaje) {
		super(mensaje);
	}
}
