package logica;

import interfaces.IControladorAltaInstituto;
import logica.ManejadorInstituto;

public class ControladorAltaInstituto implements IControladorAltaInstituto{
	private String nombre;
	
	public ControladorAltaInstituto(){}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean darAltaInstituto(String nombre){//retorna true si el nick esta disponible en el sistema
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		this.nombre = nombre;
		return !mI.exists(nombre);
	}
	
	/*public boolean iNuevoNombre(String nombre) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.exists(nombre)) {
			this.nombre = nombre;
		}
		return mI.exists(nombre);
	}*/
	
	@Override
	public void confirmar() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		mI.agregarInstituto(this.nombre);
	}
	
	
}	

