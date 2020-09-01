package logica;

import java.util.*;
import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import interfaces.IControladorConsultaEdicionCurso;

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
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.find(instituto);
		return i.getCursos();
	}
	@Override
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso) {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso c = mC.find(curso);
		return c.getEdiciones();
	}
	@Override
	public DtEdicion seleccionarEdicion(String edicion) {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(edicion);
		DtEdicion edition = new DtEdicion(e.getNombre(), e.getFechaI(), e.getFechaF(), e.getCupos(), e.getFechaPub());
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
