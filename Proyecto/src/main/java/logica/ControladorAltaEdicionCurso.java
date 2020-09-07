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
import excepciones.InstitutoInexistente;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String instituto;
	private String curso;
	private boolean tieneCupos;//no lo uso
	private Integer cupos;//no lo uso
	private DtEdicion edicion;
	
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente {
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList <DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		if (i.equals(null)) {
			throw new InstitutoInexistente("El instituto " + instituto + " no esta en el sistema");
		}
		this.instituto = i.getNombre();
		ArrayList<Curso> cursos = mI.find(instituto).getCursos();
		for(Curso c: cursos) {
			DtCursoBase dtcb = new DtCursoBase (c.getNombre());
			cursosinstituto.add(dtcb);
		}
		return cursosinstituto;
	}
	
	@Override
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<DtUsuarioBase> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(this.instituto);
		if (i.equals(null)) {
			throw new InstitutoInexistente("El instituto " + instituto + " no esta en el sistema");
		}
		this.curso = curso;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		if (mC.find(curso) == null) {
			throw new CursoNoExiste("El curso" + curso + " no esta en el sistema");
		}
		DtCursoBase dtC = new DtCursoBase(curso);//
		boolean cursoValido = false;
		if (i.getCursos().contains(dtC)) {
			cursoValido = true;
		}
		if (!cursoValido) {
			throw new CursoNoExiste("El curso " + curso + " no esta en el instituto");
		} else {
			for (Edicion e: mC.find(curso).getEdiciones()) {
				if (e.getNombre().equals(nombre)) {
					throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso");
				}
			}
			if (!tieneCupos) {
				Integer misCupos = 0;
				edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, misCupos, fechaPub);
			} else 	{ edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, cupos, fechaPub); }
			
			Edicion edi = new Edicion(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(), edicion.isTieneCupos(), edicion.getCupo(), edicion.getFechaPub());
			ArrayList<Edicion> edis = mC.find(curso).getEdiciones();
			edis.add(edi);
			mC.find(curso).setEdiciones(edis);
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			for (Usuario u: mU.getUsuarios()) {
				if (u instanceof Docente) {
					for (DtUsuarioBase nick: docentes) {
						if (u.getNick() == nick.getNick()) {
							if (!((Docente) u).find(this.edicion)) {
								((Docente) u).agregarEdicion(edi);
							} else throw new EdicionRepetida("El docente " + nick + " ya dicta la edicion " + this.edicion.getNombre());
						}
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
		mE.agregarEdicion(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(), edicion.isTieneCupos(), edicion.getCupo(), edicion.getFechaPub());
	}

}
