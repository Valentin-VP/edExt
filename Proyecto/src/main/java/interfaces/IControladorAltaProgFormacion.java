package interfaces;

import datatypes.DtFecha;

public interface IControladorAltaProgFormacion {
	public boolean ingresarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, DtFecha fechaA);
	
	public void modificarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, DtFecha fechaA);
	
	public void cancelar();
	
	public void confirmar();
}
