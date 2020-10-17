package interfaces;

import excepciones.InstitutoRepetidoException;

public interface IControladorAltaInstituto {

	public void darAltaInstituto(String nombre) throws InstitutoRepetidoException;

}
