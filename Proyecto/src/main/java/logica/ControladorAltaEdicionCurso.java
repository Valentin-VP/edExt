package logica;

import java.util.ArrayList;
import datatypes.DtEdicion;
import excepciones.EdicionRepetida;
import excepciones.EdicionSinCupos;
import excepciones.CursoNoExiste;
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
		if (i == null) {
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
		Curso c = mC.find(curso);
		if (c == null) {
			throw new CursoNoExiste("El curso " + curso + " no esta en el sistema");
		}
		boolean cursoValido = false;
		if (i.getCursos().contains(c)) {
			cursoValido = true;
		}
		if (!cursoValido) {
			throw new CursoNoExiste("El curso " + curso + " no esta en el instituto");
		} else {
			for (Edicion e: c.getEdiciones()) {
				if (e.getNombre().equals(nombre)) {
					throw new EdicionRepetida("La edicion " + nombre + " ya se encuentra integrada al curso");
				}
			}
			if (!tieneCupos) {
				Integer misCupos = 0;
				edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, misCupos, fechaPub);
			} else 	{ edicion = new DtEdicion(nombre, fechaI, fechaF, tieneCupos, cupos, fechaPub); }
			
			Edicion edi = new Edicion(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(), edicion.isTieneCupos(), edicion.getCupo(), edicion.getFechaPub());
			ArrayList<Edicion> edis = new ArrayList<Edicion>();
			edis = mC.find(curso).getEdiciones();
			edis.add(edi);
			c.setEdiciones(edis);
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			for (Usuario u: mU.getUsuarios()) {
				if (u instanceof Docente) {
					for (DtUsuarioBase profe: docentes) {
						if (u.getNick().equals(profe.getNick()) && u.getCorreo().equals(profe.getCorreo())) {
							if (!((Docente) u).find(edi)) {
								((Docente) u).agregarEdicion(edi);
							} else throw new EdicionRepetida("El docente " + profe + " ya dicta la edicion " + this.edicion.getNombre());
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
	
	@Override
	public ArrayList<DtUsuarioBase> getUsuarios(){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuarioBase> users = new ArrayList<>();
		for (Usuario u: mU.getUsuarios()) {
			DtUsuarioBase user = new DtUsuarioBase(u.getNick(), u.getCorreo());
			users.add(user);
		}
		return users;
	}

}
