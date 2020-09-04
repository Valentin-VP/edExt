package logica;

import java.util.ArrayList;
import datatypes.DtEdicion;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import excepciones.CursoNoExiste;
import datatypes.DtEdicionBase;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import interfaces.IControladorAltaEdicionCurso;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String instituto;
	private String curso;
	private boolean tieneCupos;
	private Integer cupos;
	private DtEdicion edicion;
	
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		this.instituto = i.getNombre();
		return i.getCursos();
	}
	
	@Override
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(this.instituto);
		this.curso = curso;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		if (c != null) {
			throw new CursoNoExiste("El curso" + curso + " no esta en el sistema");
		}
		for (DtCursoBase dtC: i.getCursos()) {
			if (dtC.getNombre() == curso) {
				throw new CursoNoExiste("El curso" + curso + " no esta en este instituto");
			}
		}
		for (DtEdicionBase e: c.getEdiciones()) {
			if (e.getNombre() == nombre) {
				throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso");
			}
		}
		edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, cupos, fechaPub);
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion ed = new Edicion(nombre, fechaI, fechaF, tieneCupos, cupos, fechaPub);
		mE.getEdiciones().add(ed);
		DtEdicionBase eBase = new DtEdicionBase(nombre);
		c.getEdiciones().add(eBase);
		//la coleccion de docentes... es un viaje
	}

	@Override
	public void ingresarCupos(Integer cupos) throws EdicionSinCupos {
		if (!edicion.isTieneCupos()) {
			throw new EdicionSinCupos("La edicion " + edicion.getNombre() + " no tiene cupos");
		}
		edicion.setCupo(cupos);
		//buscar edicion en coleccion global y cambiarla
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
