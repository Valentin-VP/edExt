package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtProgramaBase;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.SinCursos;
import excepciones.SinInstitutos;
import interfaces.IControladorConsultaCurso;

public class ControladorConsultaCurso implements IControladorConsultaCurso{
	private String institutoCon;
	private ArrayList<DtCursoBase> cursos = new ArrayList<DtCursoBase>();
	ArrayList<DtProgramaBase> programas = new ArrayList<DtProgramaBase>();

	public ControladorConsultaCurso() {
		super();
	}
	
	public ArrayList<DtCursoBase> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<DtCursoBase> cursos) {
		this.cursos = cursos;
	}
	
	@Override
	public ArrayList<DtProgramaBase> getProgramas(){
		return this.programas;
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

	
	@Override
	public DtCurso consultarCurso(String curso) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		DtCurso retorno;
		this.programas = new ArrayList<DtProgramaBase>();
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		ArrayList<DtEdicionBase> dteb = new ArrayList<DtEdicionBase>();
		ArrayList<DtCursoBase> dtprevias = new ArrayList<DtCursoBase>();
		String nombre = mI.find(institutoCon).findCurso(curso).getNombre();
		String descripcion = mI.find(institutoCon).findCurso(curso).getDescripcion();
		String duracion = mI.find(institutoCon).findCurso(curso).getDuracion();
		int cantHoras = mI.find(institutoCon).findCurso(curso).getCantHoras();
		int creditos = mI.find(institutoCon).findCurso(curso).getCreditos();
		DtFecha fechaR = mI.find(institutoCon).findCurso(curso).convertToDtFecha(mI.find(institutoCon).findCurso(curso).getFechaR());
		String url = mI.find(institutoCon).findCurso(curso).getUrl();
		// Buscar ProgFormacion que incluyan a este curso y guardarlos para crear el DtCurso a retornar 
		if(!mP.getProgramas().isEmpty()) {
			for(ProgFormacion pf: mP.getProgramas()) {
				for(Curso c: pf.getCursos()) {
					if(c.getNombre().equals(curso)) {
						DtProgramaBase progf = new DtProgramaBase(pf.getNombre());
						this.programas.add(progf);
					}
				}
			}
		}
		for(Edicion ed: mI.find(institutoCon).findCurso(curso).getEdiciones()) { 
			  DtEdicionBase edb = new DtEdicionBase(ed.getNombre());
			  dteb.add(edb);
		}
		for(Curso previa: mI.find(institutoCon).findCurso(curso).getPrevias()) { 
			  DtCursoBase dtprevia = new DtCursoBase(previa.getNombre());
			  dtprevias.add(dtprevia); 
		}
		ArrayList<String> categories = new ArrayList <String>();
		for(Categoria cat: mI.find(institutoCon).findCurso(curso).getCategorias()) {
			String strcat = cat.getNombre();
			categories.add(strcat);
		}
		retorno = new DtCurso(descripcion,duracion,cantHoras,creditos,fechaR,url,nombre,dteb,dtprevias,categories);
		return retorno;
	 }

	@Override
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		ArrayList<DtInstituto> dtinstitutos = new ArrayList<DtInstituto>();
		if(mI.getInstitutos().isEmpty()) {
			throw new SinInstitutos("No se han ingresado institutos aun");
		}
		for(DtInstituto i: mI.getDtInstitutos()) {
			DtInstituto dti = new DtInstituto(i.getNombre());
			dtinstitutos.add(dti);
		}
		return dtinstitutos;
	}

	@Override
	public ArrayList<String> listarCategorias() throws SinCategorias {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		ArrayList<String> categorias = new ArrayList <String>();
		if(mC.getCategorias().isEmpty()) {
			throw new SinCategorias("No se han ingresado categorias aun");
		}
		for (Categoria cat: mC.getCategorias()) {
			String strcat = cat.getNombre();
			categorias.add(strcat);
		}
		return categorias;
	}

	@Override
	public ArrayList<DtCursoBase> listarCursosCategoria(String categoria) throws CategoriaInexistente, CategoriaSinCursos {
		ArrayList <DtCursoBase> cursoscategoria = new ArrayList <DtCursoBase>();
		ManejadorCategoria mCa = ManejadorCategoria.getInstancia();
		ManejadorCurso mCu = ManejadorCurso.getInstancia();
		if(mCa.find(categoria)==null) {
			throw new CategoriaInexistente("No existe la Categoría seleccionada");
		}
		for(Curso cu: mCu.getCursos()) {
			for(Categoria cat: cu.getCategorias()) {
				if(cat.getNombre().equals(categoria)) {
					DtCursoBase curso = new DtCursoBase (cu.getNombre());
					cursoscategoria.add(curso);
				}
			}
		}
		if(cursoscategoria.isEmpty()) {
			throw new CategoriaSinCursos("No existen Cursos para la Categoría seleccionada");
		}
		return cursoscategoria;
	}
	
	@Override
	public ArrayList<DtCurso> listarCursosPlataforma() throws SinCursos {
		ManejadorCurso mCu = ManejadorCurso.getInstancia();
		ArrayList <DtCurso> cursosplataforma = new ArrayList <DtCurso>();
		for(Curso cu: mCu.getCursos()){
			//public DtCurso(String descripcion, String duracion, int cantHoras, Integer creditos, DtFecha fechaR, String url, String nombre, ArrayList<DtEdicionBase> ediciones, ArrayList<DtCursoBase> previas, ArrayList <String> categorias) {
			Integer creditosInteger = new Integer (cu.getCreditos());
			
			List <Edicion> edicioneslist = cu.getEdiciones();
			ArrayList <DtEdicionBase> dtedicionesbase = new ArrayList <DtEdicionBase>();
			for(Edicion e: edicioneslist) {
				DtEdicionBase dteb = new DtEdicionBase (e.getNombre());
				dtedicionesbase.add(dteb);
			}
			
			List <Curso> cursoslist = cu.getPrevias();
			ArrayList <DtCursoBase> dtcursosbase = new ArrayList <DtCursoBase>();
			for(Curso c: cursoslist) {
				DtCursoBase dtc = new DtCursoBase (c.getNombre());
				dtcursosbase.add(dtc);
			}
			
			List<Categoria> categoriaslist = cu.getCategorias();
			ArrayList <String> strcategorias = new ArrayList <String>();
			for(Categoria c: categoriaslist) {
				strcategorias.add(c.getNombre());
			}
			
			DtCurso curso = new DtCurso (cu.getDescripcion(),cu.getDuracion(),cu.getCantHoras(),creditosInteger,cu.convertToDtFecha(cu.getFechaR()),cu.getUrl(),cu.getNombre(),dtedicionesbase,dtcursosbase,strcategorias);
			cursosplataforma.add(curso);
		}
		if(cursosplataforma.isEmpty()) {
			throw new SinCursos("No existen Cursos en la Plataforma");
		}
		return cursosplataforma;
		
	}
	
}	

