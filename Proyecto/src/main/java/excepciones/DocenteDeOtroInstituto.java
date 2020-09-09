package excepciones;

public class DocenteDeOtroInstituto extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DocenteDeOtroInstituto(String texto) {
		super(texto);
	}

}
