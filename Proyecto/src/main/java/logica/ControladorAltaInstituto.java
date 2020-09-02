package logica;

import interfaces.IControladorAltaInstituto;
import logica.ManejadorInstituto;

public class ControladorAltaInstituto implements IControladorAltaInstituto{
	private String nombre;
	
	public ControladorAltaInstituto(){}

	public String getNombre() {
		return nombre;
	}
	
	public boolean darAltaInstituto(String nombre){//retorna true si el nick esta disponible en el sistema
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.exists(nombre)) {
			this.nombre = nombre;
		}
		return mI.exists(nombre);
	}
	
	/*public boolean iNuevoNombre(String nombre) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.exists(nombre)) {
			this.nombre = nombre;
		}
		return mI.exists(nombre);
	}*/
	
	public void confirmar() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		mI.agregarInstituto(this.nombre);
	}
	
	
}	

