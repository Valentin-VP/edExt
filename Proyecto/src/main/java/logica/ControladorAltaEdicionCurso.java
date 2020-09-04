package logica;

import java.util.ArrayList;
import datatypes.DtEdicion;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import datatypes.DtEdicionBase;
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
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, Integer cupos, boolean tieneCupos, DtFecha fechaPub) throws EdicionRepetida {
		this.curso = curso;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		if (c != null) {
			//throw new agregar exception de rodri
		}
		for (DtEdicionBase e: c.getEdiciones()) {
			if (e.getNombre() == nombre) {
				throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso");
			}
		}
		edicion = new DtEdicion(nombre, fechaI, fechaF, cupos, fechaPub, tieneCupos);//creo el datatytpe
		DtEdicionBase eBase = new DtEdicionBase(nombre);
		c.getEdiciones().add(eBase);//agrego la edicion a las lista de ediciones del curso
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion ed = new Edicion(nombre, fechaI, fechaF, cupos, fechaPub, tieneCupos);
		mE.getEdiciones().put(nombre, ed);//agrego la edicion a la coleccion global de ediciones
		//la coleccion de docentes... es un viaje
	}

	@Override
	public void ingresarCupos(Integer cupos) throws EdicionSinCupos {
		if (!edicion.isTieneCupos()) {
			throw new EdicionSinCupos("La edicion " + edicion.getNombre() + " no tiene cupos");
		}
		edicion.setCupo(cupos);
	}

	/*@Override
	public void modificarAltaEdicion(String nuevoNombre) throws EdicionRepetida {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		if (mE.exists(nuevoNombre)) {
			throw new EdicionRepetida("La edicion " + nuevoNombre + " ya se encuentra en el sistema");
		}
		mE.find(edicion.getNombre()).setNombre(nuevoNombre);
		this.edicion.setNombre(nuevoNombre);
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		for (DtEdicionBase e: c.getEdiciones()) {
			if (e.getNombre() == nuevoNombre) {
				throw new EdicionRepetida("La edicion " + nuevoNombre + " ya se encuentra integrada al curso");
			}
		}
		for (DtEdicionBase e: c.getEdiciones()) {
			if (e.getNombre() == edicion.getNombre()) {
				e.setNombre(nuevoNombre);
			}
		}
	}*/

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
