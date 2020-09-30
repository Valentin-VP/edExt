package logica;

import java.util.ArrayList;
import java.util.List;

import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.InstitutoInexistente;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;

public class ControladorListarAceptadosAUnaEdicionDeCurso implements IControladorListarAceptadosAUnaEdicionDeCurso{
	
	public List<Curso> IngresarInstituto(String instituto) throws InstitutoInexistente{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		if(i == null)
			throw new InstitutoInexistente("El instituto ingresado no existe en el sistema");
		return i.getCursos();
	}
	
	public List<Edicion> IngresarCurso(String curso) throws CursoNoExiste{
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		if(c == null)
			throw new CursoNoExiste("El curso seleccionado no existe en el sistema");
		return c.getEdiciones();
	}
	
	public List<String> IngresarEdicion(String edicion) throws EdicionNoExiste{
		List<String> inscripciones = new ArrayList<>();
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(edicion);
		if(e == null)
			throw new EdicionNoExiste("La edicion seleccionada no existe en el sistema");
		for(InscripcionEd i: e.getInscripciones()) {
			if(i.getEstado().equals("Aceptada"))
				inscripciones.add(i.getEstudiante().getNick());
		}
		return inscripciones;
	}
}
