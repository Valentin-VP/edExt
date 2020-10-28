package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.LinkedHashMap;
 
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

import datatypes.DtEdicionBase;
import datatypes.DtUsuarioBase;
import datatypes.EstadoInscripcion;
import datatypes.DtCursoBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtFecha;
import datatypes.DtInscripcionEd;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;

public class ControladorSeleccionarEstudiantesParaUnaEdicionDeCurso implements IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso{

	/*Actores Docente
	Descripción El caso de uso comienza cuando un docente desea seleccionar los
	estudiantes para una edición de curso en que participa. En primer lugar, el
	docente indica el instituto que brinda el curso y el sistema muestra los
	cursos asociados al mismo. OK
	
	El docente elige uno y el sistema muestra los
	datos básicos de la edición vigente de curso asociado, si existe. OK
	
	El sistema
	muestra todas las inscripciones de estudiantes a la edición de curso
	seleccionada, así como el estado de cada una. OK 
	
	Las inscripciones pueden ser
	ordenadas como se indica en el Requerimiento Especial 7.5 Ranking
	inscriptos a Edición de Curso. OK
	
	El docente puede seleccionar el estado
	“Aceptada” o “Rechazada” para cada inscripción a la edición del curso. OK
	
	Finalmente, el sistema registra la selección de estudiantes realizada para la
	edición del curso. OK*/
	
	private ArrayList<DtCursoBase> cursos = new ArrayList<DtCursoBase>();
	private Edicion edicion;
	private DtEdicionCompleta edicioncompleta;
	private Curso c;
	private List<DtInscripcionEd> dtinscripcionesed = new ArrayList<DtInscripcionEd>();
	
	public ArrayList<DtCursoBase> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<DtCursoBase> cursos) {
		this.cursos = cursos;
	}

	@Override
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos{
		limpiar();
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
		setCursos(cursosinstituto);
		return getCursos();		
	}
	
	public DtEdicionCompleta seleccionarCurso(String curso, String nick) throws EdicionVigenteNoExiste{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.findUsuario(nick);
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		this.c = mC.find(curso);
		DtEdicionBase dteb = new DtEdicionBase();
		List<Edicion> ediciones = new ArrayList<Edicion>();
		if(u instanceof Docente) {
			ediciones = ((Docente) u).getEdiciones();
			dteb = ((Docente) u).getDtEdicionVigente();
		} else {
			throw new EdicionVigenteNoExiste("No es un docente");
		}
		if (ediciones.isEmpty()) {
			throw new EdicionVigenteNoExiste("No dicta ninguna edicion");
		}
		if (dteb == null) {
			throw new EdicionVigenteNoExiste("No existe una edicion vigente para el curso seleccionado");
		}
		List <DtInscripcionEd> dtinscripciones = new ArrayList <DtInscripcionEd>();
		for(Edicion ed: ediciones) {
			if (ed.getNombre()==dteb.getNombre()) {
				this.edicion = ed;
				System.out.print("la edicion guardada es"+this.edicion.getNombre());
				dtinscripciones = getDtInscripciones(ed.getInscripciones());
				DtFecha dtfi = ed.convertToDtFecha(ed.getFechaI());
				DtFecha dtff = ed.convertToDtFecha(ed.getFechaF());
				DtFecha dtfp = ed.convertToDtFecha(ed.getFechaPub());
				this.edicioncompleta = new DtEdicionCompleta (ed.getNombre(),dtfi,dtff,ed.isTieneCupos(),ed.getCupos(),dtfp,dtinscripciones);
			}
		}
		return this.edicioncompleta;
	}
	
	private List <DtInscripcionEd> getDtInscripciones(List <InscripcionEd> inscripciones) {
		for(InscripcionEd inscripcioned: inscripciones) {
			DtFecha dtfecha = inscripcioned.getDtFecha();
			DtEdicionBase dteb = new DtEdicionBase (inscripcioned.getEdicion().getNombre());
			DtUsuarioBase dtub = new DtUsuarioBase (inscripcioned.getEstudiante().getNick(),inscripcioned.getEstudiante().getCorreo());
			DtInscripcionEd dtied = new DtInscripcionEd (dtfecha,inscripcioned.getEstado(),dteb,dtub);
			dtinscripcionesed.add(dtied);
		}
		return this.dtinscripcionesed;
	}
	
	Comparator<InscripcionEd> ordenarPorFecha = new Comparator<InscripcionEd>() {
		public int compare(InscripcionEd ins1, InscripcionEd ins2) {
			return Long.valueOf(ins1.getFecha().getTime()).compareTo(ins2.getFecha().getTime());
	    }
	};
	
	public List<DtInscripcionEd> ordenarInscripciones(String ordenarpor){
		if(ordenarpor.equals("fecha")) {
			Collections.sort(this.edicion.getInscripciones(), ordenarPorFecha);
		}
		else if(ordenarpor.equals("prioridad")) {
			//obtener lista de nicks de estudiantes con contadores en 0
			HashMap<String, Integer> estudiantes = new HashMap<String, Integer>();
			for(InscripcionEd ins: this.edicion.getInscripciones()) {
				estudiantes.put(ins.getEstudiante().getNick(),0);
			}
			//para cada uno, contar inscripciones previas rechazadas (IPR) a una edicion ya finalizada del mismo curso
			for(Edicion ed: c.getEdiciones()) {
				if(!ed.getNombre().equals(c.getEdicionVigente().getNombre())) { // Me aseguro que no se considere la edicion vigente
					for(InscripcionEd anterior: ed.getInscripciones()) { // Para cada inscripcion
						if (estudiantes.containsKey(anterior.getEstudiante().getNick()) 
								&& anterior.getEstado().compareTo(EstadoInscripcion.Rechazada)==0) { // (si ese estudiante esta en la lista y su inscripcion fue rechazada)
							String nick = anterior.getEstudiante().getNick(); // obtengo su estudiante relacionado
							estudiantes.put(nick, estudiantes.get(nick)+1); // y aumento el contador 
						}
					}
				}
			}
			//calcular prioridad de cada estudiante con prioridad = 0,5 * IPR
			Map<String, Float> estudiantesprioridad = new HashMap<String, Float>();
			Iterator<Entry<String, Integer>> it = estudiantes.entrySet().iterator();
		    while (it.hasNext()) {
		        @SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry)it.next();
		        float prioridad = (float) ((int) pair.getValue() * 0.5);
		        estudiantesprioridad.put((String) pair.getKey(),prioridad);
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    // ordenar los estudiantes
		    Map<String, Float> estudiantesordenados = estudiantesprioridad.entrySet().stream().sorted(comparingByValue()).collect(
		                toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		                    LinkedHashMap::new));
		    // Una vez ordenados, iterar sobre estudiantesordenados y por cada uno, buscar la inscripcion y agregarla a la lista de retorno
		    List<DtInscripcionEd> dtinscripcionesed2 = new ArrayList<DtInscripcionEd>();
		    Iterator<Entry<String, Float>> it2 = estudiantesordenados.entrySet().iterator();
		    while (it2.hasNext()) {
		    	@SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry)it2.next();
		    	for (DtInscripcionEd dtie: this.dtinscripcionesed) {
		    		if(dtie.getEstudiante().getNick().equals(pair.getKey())) {
		    			dtinscripcionesed2.add(dtie);
		    		}
		    	}
		    }
		    this.dtinscripcionesed = dtinscripcionesed2;
		} else if(ordenarpor.equals("no ordenar")){
			this.dtinscripcionesed = getDtInscripciones(this.edicion.getInscripciones());
		}
		return dtinscripcionesed;
	}

	public void cambiarEstadoInscripcion(String nick, String estado) {
		EstadoInscripcion estadoins = null;
		switch(estado) {
		case "Aceptada": 
			estadoins = EstadoInscripcion.Aceptada;
			break;
		case "Rechazada": 
			estadoins = EstadoInscripcion.Rechazada;
			break;
		}
		 
		for(InscripcionEd ins: this.edicion.getInscripciones()) {
			if(ins.getEstudiante().getNick().equals(nick)) {
				ins.setEstado(estadoins);
			}
		}
	}
	
	public void confirmarSeleccion() {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		mE.agregarEdicion(this.edicion);
		limpiar();
	}
	
	public void limpiar() {
		this.cursos = new ArrayList<DtCursoBase>();
		this.edicion = new Edicion();
		this.edicioncompleta= new DtEdicionCompleta();
		this.c = new Curso();
		this.dtinscripcionesed = new ArrayList<DtInscripcionEd>();
	}
}
