package interfaces;

import excepciones.InstitutoRepetidoExeption;

public interface IControladorAltaInstituto {

	public void darAltaInstituto(String nombre) throws InstitutoRepetidoExeption;

}
