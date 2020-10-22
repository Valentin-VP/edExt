package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtFecha;
import datatypes.DtInscripcionEd;
import datatypes.DtInstituto;
import datatypes.DtUsuarioBase;
import datatypes.EstadoInscripcion;
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;

public class ControladorListarAceptadosAUnaEdicionDeCurso implements IControladorListarAceptadosAUnaEdicionDeCurso{
	
	@Override
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if (mI.getDtInstitutos().isEmpty()) {
			throw new SinInstitutos("No hay institutos ingresados");
		}
		return mI.getDtInstitutos();
	}
	
	@Override
	public List<DtCursoBase> ingresarInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		if(i == null) //no deberia suceder
			throw new InstitutoInexistente("El instituto ingresado no existe en el sistema");
		if (i.getCursos().isEmpty()) {
			throw new InstitutoSinCursos("El Instituto seleccionado no posee cursos aun");
		}else {
			ArrayList <DtCursoBase> cursosinstituto = new ArrayList<DtCursoBase>();
			for(Curso c: i.getCursos()) {
				DtCursoBase dtcb = new DtCursoBase(c.getNombre());
				cursosinstituto.add(dtcb);
			}
			return cursosinstituto;
		}
	}
	
	@Override
	public List<DtEdicionBase> ingresarCurso(String curso) throws CursoNoExiste, EdicionNoExiste{
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		//Sin comprobar pertenencia
		if(c == null) //no deberia suceder
			throw new CursoNoExiste("El curso seleccionado no existe en el sistema");
		if (c.getEdiciones().isEmpty()) {
			throw new EdicionNoExiste("El curso seleccionado no posee ediciones aun");
		}else {
			ArrayList <DtEdicionBase> edCursos = new ArrayList<DtEdicionBase>();
			for(Edicion e: c.getEdiciones()) {
				DtEdicionBase dteb = new DtEdicionBase(e.getNombre());
				edCursos.add(dteb);
			}
			return edCursos;
		}
	}
	
	@Override
	public DtEdicionCompleta ingresarEdicion(String edicion) throws EdicionNoExiste{
		List<DtInscripcionEd> dtinsc = new ArrayList<DtInscripcionEd>();
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(edicion);
		//Sin comprobar pertenencia
		if(e == null) //no deberia suceder
			throw new EdicionNoExiste("La edicion seleccionada no existe en el sistema");
		for(InscripcionEd i: e.getInscripciones()) {
			if(i.getEstado().equals(EstadoInscripcion.Aceptada)) {
				DtInscripcionEd dteb = new DtInscripcionEd(i.getDtFecha(), i.getEstado(), new DtEdicionBase(e.getNombre()),
								new DtUsuarioBase(i.getEstudiante().getNombre(), i.getEstudiante().getCorreo()));
				dtinsc.add(dteb);
			}
		}	
		//public DtEdicionCompleta(String nombre, DtFecha fechaI, DtFecha fechaF, boolean tieneCupos, Integer cupo, DtFecha fechaPub,List<DtInscripcionEd> inscripciones) {

		DtEdicionCompleta dtec = new DtEdicionCompleta(e.getNombre(), e.convertToDtFecha(e.getFechaI()),
						e.convertToDtFecha(e.getFechaF()), e.isTieneCupos(), e.getCupos(), e.convertToDtFecha(e.getFechaPub()), dtinsc);
		return dtec;
	}
}
