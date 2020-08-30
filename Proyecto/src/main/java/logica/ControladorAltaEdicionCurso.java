package logica;

import java.util.ArrayList;
import datatypes.DtEdicion;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import interfaces.IControladorAltaEdicionCurso;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String instituto;
	private String curso;
	private Integer cupos;
	private DtEdicion edicion;
	
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) {
		return null;
	}

	@Override
	public Boolean altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF,
			ArrayList<String> docentes) {
		return null;
	}

	@Override
	public void ingresarCupos(Integer cupos) {
		
	}

	@Override
	public Boolean modificarAltaEdicion(String nuevoNombre) {
		return null;
	}

	@Override
	public void cancelarAltaEdicion() {
		
	}

	@Override
	public void confirmarAltaEdicion() {
		
	}

}
