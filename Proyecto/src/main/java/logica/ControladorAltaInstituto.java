package logica;

import interfaces.IControladorAltaInstituto;
import logica.ManejadorInstituto;
import excepciones.InstitutoRepetidoExeption;


@SuppressWarnings("unused")
public class ControladorAltaInstituto implements IControladorAltaInstituto{
	
	public ControladorAltaInstituto(){}

	
	@Override
	public void darAltaInstituto(String nombre) throws InstitutoRepetidoExeption{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto I = mI.find(nombre);
		if (I != null)
			throw new InstitutoRepetidoExeption("El instituto " + nombre +" ya esta registrado");
		Instituto i = new Instituto(nombre);
		mI.agregarInstituto(i);
	}
	
}	

