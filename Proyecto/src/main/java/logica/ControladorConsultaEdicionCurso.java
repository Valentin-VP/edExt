package logica;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import interfaces.IControladorConsultaEdicionCurso;
import logica.ManejadorInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;

public class ControladorConsultaEdicionCurso implements IControladorConsultaEdicionCurso {
	private String edicion;
	private String instituto;
	private String curso;
	
	
	public ControladorConsultaEdicionCurso() {
		super();
	}
	public ControladorConsultaEdicionCurso(String edicion, String instituto, String curso) {
		super();
		this.edicion = edicion;
		this.instituto = instituto;
		this.curso = curso;
	}
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws CursoNoExiste{
			ArrayList<DtCursoBase> DtCursos = new ArrayList<DtCursoBase>();
			ArrayList<Curso> cursos = new ArrayList<Curso>();
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto i = mI.find(instituto);
			if(i == null) {
				throw new CursoNoExiste("Curso Inexistente");
			}
			cursos = i.getCursos();
			for(Curso c: cursos) {
				DtCursoBase curs = new DtCursoBase(c.getNombre());
				DtCursos.add(curs);
			}
			return DtCursos;
	}
	
	@Override
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso) throws EdicionNoExiste{
		ArrayList<DtEdicionBase> ediciones = new ArrayList<>();
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		if(c == null)
			throw new EdicionNoExiste("Edicion Inexistente");
		for(Edicion e: c.getEdiciones()) {
			DtEdicionBase edic = new DtEdicionBase(e.getNombre());
			ediciones.add(edic);
		}
		return ediciones;
	}
	
	@Override
	public DtEdicion seleccionarEdicion(String edicion) {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(edicion);
		DtEdicion edition = new DtEdicion(e.getNombre(), e.getFechaI(), e.getFechaF(), e.isTieneCupos(), e.getCupos(), e.getFechaPub());
		return edition;
	}
	
	public String getEdicion() {
		return edicion;
	}
	
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	
	public String getInstituto() {
		return instituto;
	}
	
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
}
