package logica;

import java.util.ArrayList;
import datatypes.DtEdicion;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import excepciones.CursoNoExiste;
import datatypes.DtEdicionBase;
import datatypes.DtUsuarioBase;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import interfaces.IControladorAltaEdicionCurso;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String instituto;
	private String curso;
	private boolean tieneCupos;//no lo uso
	private Integer cupos;//no lo uso
	private DtEdicion edicion;
	
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();//falta controlar que exista el instituto
		Instituto i = mI.find(instituto);
		this.instituto = i.getNombre();
		return i.getCursos();
	}
	
	@Override
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<DtUsuarioBase> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();//falta controlar que exista el instituto
		Instituto i = mI.find(this.instituto);
		this.curso = curso;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		if (mC.find(curso) != null) {//cambios
			throw new CursoNoExiste("El curso" + curso + " no esta en el sistema");
		}
		for (DtCursoBase dtC: i.getCursos()) {
			if (dtC.getNombre() == curso) {
				throw new CursoNoExiste("El curso" + curso + " no esta en este instituto");
			}
		}
		for (DtEdicionBase e: mC.find(curso).getEdiciones()) {
			if (e.getNombre() == nombre) {
				throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso");
			}
		}
		if (!tieneCupos) {
			Integer misCupos = 0;
			edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, misCupos, fechaPub);
		} else 	edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, cupos, fechaPub);
		
		DtEdicionBase eBase = new DtEdicionBase(nombre);
		mC.find(curso).getEdiciones().add(eBase);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		for (Usuario u: mU.getUsuarios()) {
			if (u instanceof Docente) {
				for (DtUsuarioBase nick: docentes) {
					if (u.getNick() == nick.getNick()) {
						if (!((Docente) u).find(this.edicion)) {
							((Docente) u).getEdiciones().add(edicion);
						} else throw new EdicionRepetida("El docente " + nick + " ya dicta la edicion " + this.edicion.getNombre());
					}
				}
			}
		}
	}

	@Override
	public void ingresarCupos(Integer cupos) throws EdicionSinCupos {
		if (!edicion.isTieneCupos()) {
			throw new EdicionSinCupos("La edicion " + edicion.getNombre() + " no tiene cupos");
		}
		edicion.setCupo(cupos);
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(this.edicion.getNombre());
		e.setCupos(cupos);
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
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion ed = new Edicion(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(), edicion.isTieneCupos(), edicion.getCupo(), edicion.getFechaPub());
		mE.getEdiciones().add(ed);
	}

}
