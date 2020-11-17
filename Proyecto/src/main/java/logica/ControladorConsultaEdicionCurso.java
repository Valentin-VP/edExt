package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
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
			ManejadorCurso mk = ManejadorCurso.getInstancia();
			cursos = mk.getCursos();
			for(Curso curso: cursos) {
				for(Categoria cat: curso.getCategorias()) {
					if(cat.equals(c)) {
						DtCursoBase curs = new DtCursoBase(curso.getNombre());
						DtCursos.add(curs);
					}
				}
			}
			return DtCursos;
	}
	
	@Override
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso) throws CursoNoExiste{
		this.curso = curso;
		ArrayList<DtEdicionBase> ediciones = new ArrayList<>();
			ManejadorCurso mC = ManejadorCurso.getInstancia();
			Curso cur = mC.find(curso);
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			for(Instituto i: mI.getInstitutos()) {
				for(Curso c: i.getCursos()) {
					if(c.getNombre().equals(curso)) {
						this.instituto = i.getNombre();
					}
				}
			}
			if(curso.isEmpty()) {
				throw new CursoNoExiste("No existe el curso seleccionado");
			}
			
			for(Edicion e: cur.getEdiciones()) {
				DtEdicionBase edic = new DtEdicionBase(e.getNombre());
				ediciones.add(edic);
			}
		return ediciones;
	}
	
	@Override
	public DtEdicion seleccionarEdicion(String edicion) {
		this.edicion = edicion;
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(this.edicion);
		
		DtFecha dtfechaI = e.convertToDtFecha(e.getFechaI());
		DtFecha dtfechaF = e.convertToDtFecha(e.getFechaF());
		DtFecha dtfechaPub = e.convertToDtFecha(e.getFechaPub());
		
		DtEdicion edition = new DtEdicion(e.getNombre(), dtfechaI, dtfechaF, e.isTieneCupos(), e.getCupos(), dtfechaPub);
		return edition;
	}
	
	@Override
	public String getEdicion() {
		return edicion;
	}
	
	@Override
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	
	@Override
	public String getInstituto() {
		return instituto;
	}
	
	@Override
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	
	@Override
	public String getCurso() {
		return curso;
	}
	
	@Override
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
	public DtEdicion getDtEdicion(String edicion) {
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion e = mE.find(edicion);
		DtFecha dtfechaI = e.convertToDtFecha(e.getFechaI());
		DtFecha dtfechaF = e.convertToDtFecha(e.getFechaF());
		DtFecha dtfechaPub = e.convertToDtFecha(e.getFechaPub());
		DtEdicion dte = new DtEdicion(e.getNombre(), dtfechaI, dtfechaF, e.isTieneCupos(), e.getCupos(), dtfechaPub);
		return dte;
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
	
	@Override
	public String getCategoria() {
		return categoria;
	}
	
	@Override
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public ArrayList<DtInstituto> getInstitutosConCurso(String curso){
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		ArrayList<DtInstituto> ins = new ArrayList<DtInstituto>();
		for(Instituto i: mI.getInstitutos()) {
			if(i.existsCurso(curso)) {
				ins.add(i.getDtInstituto(i));
			}
		}
		return ins;
	}
	
	@Override
	public String getNombreCurso(String CursoInstituto) {
		String[] partes = CursoInstituto.split("-");
		//String instituto = partes[1];//deberia ser el nombre del instituto
		String curso = partes[0];//deberia ser el nombre del curso
		return curso;
	}
	
}
