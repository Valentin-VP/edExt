package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;

public class ControladorSeleccionarEstudiantesParaUnaEdicionDeCurso implements IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso{

	/*Actores Docente
	Descripci�n El caso de uso comienza cuando un docente desea seleccionar los
	estudiantes para una edici�n de curso en que participa. En primer lugar, el
	docente indica el instituto que brinda el curso y el sistema muestra los
	cursos asociados al mismo. OK
	
	El docente elige uno y el sistema muestra los
	datos b�sicos de la edici�n vigente de curso asociado, si existe. El sistema
	muestra todas las inscripciones de estudiantes a la edici�n de curso
	seleccionada, as� como el estado de cada una. Las inscripciones pueden ser
	ordenadas como se indica en el Requerimiento Especial 7.5 Ranking
	inscriptos a Edici�n de Curso. 
	
	El docente puede seleccionar el estado
	�Aceptada� o �Rechazada� para cada inscripci�n a la edici�n del curso.
	
	Finalmente, el sistema registra la selecci�n de estudiantes realizada para la
	edici�n del curso.*/
	
	private String institutoCon;
	private ArrayList<DtCursoBase> cursos = new ArrayList<DtCursoBase>();
	private String curso;
	private String edicion;
	
	public ArrayList<DtCursoBase> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<DtCursoBase> cursos) {
		this.cursos = cursos;
	}

	@Override
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos{
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList <DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.existeInstituto(instituto)) {
			throw new InstitutoInexistente("No existe el Instituto seleccionado.");
		}
		if(mI.find(instituto).getCursos().isEmpty()) {
			throw new InstitutoSinCursos("El Instituto seleccionado no posee cursos aun");
		}
		else {
			for(Curso c: mI.find(instituto).getCursos()) {
				DtCursoBase dtcb = new DtCursoBase(c.getNombre());
				cursosinstituto.add(dtcb);
			}
		}
		institutoCon = instituto;
		setCursos(cursosinstituto);
		return getCursos();		
	}
	
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste{
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(nomCurso);
		this.curso = c.getNombre();
		DtEdicionBase dteb = c.getEdicionVigente();
		if (dteb == null) {
			throw new EdicionVigenteNoExiste("No existe una edicion vigente para el curso seleccionado");
		}
		this.edicion = dteb.getNombre();
		return dteb;
	}
	
}
