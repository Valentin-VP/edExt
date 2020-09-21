package interfaces;

import java.time.LocalDate;

import datatypes.DtFecha;
import excepciones.ProgramaRepetido;

public interface IControladorAltaProgFormacion {
	public void ingresarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, LocalDate fechaA) throws ProgramaRepetido;

	public void cancelar();
	
	public void confirmar();
}
