package excepciones;

public class CategoriaInexistente extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CategoriaInexistente(String string) {
		super(string);
	}

}
