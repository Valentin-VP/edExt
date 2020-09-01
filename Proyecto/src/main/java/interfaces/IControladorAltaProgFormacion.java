package interfaces;

import java.util.Date;

public interface IControladorAltaProgFormacion {
	public boolean ingresarProgFormacion(String nom, String des, Date fechaI, Date fechaF, Date fechaA);
	
	public void modificarProgFormacion(String nom, String des, Date fechaI, Date fechaF, Date fechaA);
	
	public void cancelar();
	
	public void confirmar();
}
