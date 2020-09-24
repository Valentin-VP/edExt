package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import interfaces.IControladorConsultaEdicionCurso;
import excepciones.CategoriaInexistente;
import excepciones.CursoNoExiste;
import excepciones.InstitutoInexistente;

public class ControladorConsultaEdicionCurso implements IControladorConsultaEdicionCurso {
	private String edicion;
	private String instituto;
	private String curso;
	private String categoria;
	
	
	public ControladorConsultaEdicionCurso() {
		super();
	}
	public ControladorConsultaEdicionCurso(String edicion, String instituto, String curso, String categoria) {
		super();
		this.edicion = edicion;
		this.instituto = instituto;
		this.curso = curso;
		this.setCategoria(categoria);
	}
	@Override
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente{
		this.instituto = instituto;
			ArrayList<DtCursoBase> DtCursos = new ArrayList<DtCursoBase>();
			List<Curso> cursos = new ArrayList<Curso>();
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto i = mI.find(instituto);
			if(i == null) {
				throw new InstitutoInexistente("Instituto Inexistente");
			}
			cursos = i.getCursos();
			for(Curso c: cursos) {
				DtCursoBase curs = new DtCursoBase(c.getNombre());
				DtCursos.add(curs);
			}
			return DtCursos;
	}
	
	@Override
	public ArrayList<DtCursoBase> seleccionarCategoria(String categoria) throws CategoriaInexistente{
		this.categoria = categoria;
			ArrayList<DtCursoBase> DtCursos = new ArrayList<DtCursoBase>();
			List<Curso> cursos = new ArrayList<Curso>();
			ManejadorCategoria mC = ManejadorCategoria.getInstancia();
			Categoria c = mC.find(categoria);
			if(c == null) {
				throw new CategoriaInexistente("Categoria Inexistente");
			}
			cursos = c.getCursos();
			for(Curso curso: cursos) {
				DtCursoBase curs = new DtCursoBase(curso.getNombre(), curso.getInstituto().getNombre());
				DtCursos.add(curs);
			}
			return DtCursos;
	}
	
	@Override
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso, boolean conCategoria) throws CursoNoExiste{
		this.curso = curso;
		ArrayList<DtEdicionBase> ediciones = new ArrayList<>();
		if(!conCategoria) {
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			curso = mI.find(this.instituto).findCurso(curso).getNombre();
			
			if(curso.isEmpty()) {
				throw new CursoNoExiste("No existe el curso seleccionado");
			}
			
			for(Edicion e: mI.find(this.instituto).findCurso(curso).getEdiciones()) {
				DtEdicionBase edic = new DtEdicionBase(e.getNombre());
				ediciones.add(edic);
			}
		}else {
			ManejadorCategoria mC = ManejadorCategoria.getInstancia();
			curso = mC.find(this.categoria).findCurso(curso, mC.find(this.categoria).getInstitutoCurso(curso)).getNombre();
			
			if(curso.isEmpty()) {
				throw new CursoNoExiste("No existe el curso seleccionado");
			}
			
			for (Edicion e: mC.find(this.categoria).findCurso(curso, mC.find(this.categoria).getInstitutoCurso(curso)).getEdiciones()) {
				DtEdicionBase edic = new DtEdicionBase(e.getNombre());
				ediciones.add(edic);
			}
		}	
		return ediciones;
	}
	
	@Override
	public DtEdicion seleccionarEdicion(String edicion) {
		this.edicion = edicion;
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Edicion e = mI.find(this.instituto).findCurso(this.curso).findEdicion(this.edicion);
		
		DtFecha dtfechaI = e.convertToDtFecha(e.getFechaI());
		DtFecha dtfechaF = e.convertToDtFecha(e.getFechaF());
		DtFecha dtfechaPub = e.convertToDtFecha(e.getFechaPub());
		
		DtEdicion edition = new DtEdicion(e.getNombre(), dtfechaI, dtfechaF, e.isTieneCupos(), e.getCupos(), dtfechaPub);
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
	
	public DtEdicion getDtEdicion(String instituto, String curso, String edicion) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i= mI.find(instituto);
		Curso c = i.findCurso(curso);
		Edicion e = c.findEdicion(edicion);
		return e.getDtEdicion();
	}
	@Override
	public ArrayList<String> getDocentes(String edicion) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> docentes = new ArrayList<>();
		for (Usuario u: mU.getUsuarios()) {
			if (u instanceof Docente) {
				for(Edicion e: ((Docente) u).getEdiciones()) {
					if (e.getNombre().equals(edicion)) {
						docentes.add(u.getNick());
					}
				}
			}
		}
		return docentes;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
