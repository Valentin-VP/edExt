package interfaces;

import java.time.LocalDate;

import datatypes.DtFecha;
import excepciones.ProgramaRepetido;

public interface IControladorAltaProgFormacion {
	public boolean ingresarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, LocalDate fechaA) throws ProgramaRepetido;
	
	//public void modificarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, DtFecha fechaA);
	
	public void cancelar();
	
	public void confirmar();
}
