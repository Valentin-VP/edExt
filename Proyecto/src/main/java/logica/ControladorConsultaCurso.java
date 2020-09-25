package logica;

import java.util.ArrayList;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtProgramaBase;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
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
		String instituto = mI.find(institutoCon).findCurso(curso).getInstituto().getNombre();
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
		retorno = new DtCurso(descripcion,duracion,cantHoras,creditos,fechaR,url,nombre,dteb,dtprevias,instituto,categories);
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
	
}	

