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
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		return i.getCursos();
	}

	@Override
	public Boolean altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes) {
		//la coleccion de docentes es un viaje... despues
		return null;
	}

	@Override
	public void ingresarCupos(Integer cupos) {
		//booleano en Edicion??
	}

	@Override
	public Boolean modificarAltaEdicion(String nuevoNombre) {
		this.edicion.setNombre(nuevoNombre);
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		return mE.exists(nuevoNombre);
	}

	@Override
	public void cancelarAltaEdicion() {
		//nose
	}

	@Override
	public void confirmarAltaEdicion() {
		//creo instancia
		//creo link
	}

}
