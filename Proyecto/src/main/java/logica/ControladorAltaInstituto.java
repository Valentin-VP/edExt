package logica;

import interfaces.IControladorAltaInstituto;
import logica.ManejadorInstituto;

public class ControladorAltaInstituto implements IControladorAltaInstituto{
	private String nombre;
	
	public ControladorAltaInstituto(){}

	public String getNombre() {
		return nombre;
	}
	
	public boolean darAltaInstituto(String nombre){
		ManejadorInstituto mI = null;//mI.getInstancia();no me deja inicializar asi la clase
		this.nombre = nombre;
		return mI.exists(nombre);
	}
	
	public boolean iNuevoNombre(String nombre) {
		ManejadorInstituto mI = null;// mI.getInstancia();no me deja inicializar asi la clase
		if(mI.exists(nombre)) {
			this.nombre = nombre;
		}
		return mI.exists(nombre);
	}
	
	public void confirmar() {
		ManejadorInstituto mI = null;// mI.getInstancia();no me deja inicializar asi la clase
		mI.agregarInstituto(this.nombre);
	}
	
	
}
