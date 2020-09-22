package logica;

import excepciones.CategoriaRepetidaException;
import interfaces.IControladorAltaCategoria;


public class ControladorAltaCategoria implements IControladorAltaCategoria{
	
	public ControladorAltaCategoria() {}

	public void darAltaCategoria(String nombre) throws CategoriaRepetidaException{
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria C = mC.find(nombre);
		if (C != null)
			throw new CategoriaRepetidaException("La categoria " + nombre +" ya esta registrada");
		Categoria c = new Categoria(nombre);
		mC.agregarCategoria(c);
	}
	
}
