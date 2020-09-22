package interfaces;

import excepciones.CategoriaRepetidaException;

public interface IControladorAltaCategoria {
	
	public void darAltaCategoria(String nombre) throws CategoriaRepetidaException;

}
