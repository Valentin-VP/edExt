package logica;

import interfaces.IControladorAltaInstituto;
import logica.Instituto;
import logica.ManejadorInstituto;

public class ControladorAltaInstituto extends IControladorAltaInstituto{
	private Instituto instituto;
	private String nombre;
	
	public ControladorAltaInstituto(){}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean darAltaInstituto(String nombre){
		
	}
}
