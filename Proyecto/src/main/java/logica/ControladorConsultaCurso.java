package logica;

import java.util.*;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtInstituto;
import datatypes.DtProgramaBase;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import interfaces.IControladorConsultaCurso;

public class ControladorConsultaCurso implements IControladorConsultaCurso{
	private ArrayList<DtCurso> cursos = new ArrayList<DtCurso>();

	public ControladorConsultaCurso() {
		super();
	}
	
	public ArrayList<DtCurso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<DtCurso> cursos) {
		this.cursos = cursos;
	}
	@Override
	public ArrayList<DtCurso> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos{
		ArrayList <DtCurso> cursosinstituto = new ArrayList <DtCurso>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.existeInstituto(instituto)) {
			throw new InstitutoInexistente("No existe el Instituto seleccionado.");
		}
		ArrayList<Curso> cursos = mI.find(instituto).getCursos();
		if(cursos.isEmpty()) {
			throw new InstitutoSinCursos("El Instituto seleccionado no posee cursos aun");
		}
		for(Curso c: cursos) {
			ArrayList<DtEdicionBase> dteb = new ArrayList<DtEdicionBase>();
			for(Edicion ed: c.getEdiciones()) {
				DtEdicionBase edb = new DtEdicionBase(ed.getNombre());
				dteb.add(edb);
			}
			DtCurso dtcb = new DtCurso (c.getDescripcion(),c.getDuracion(),c.getCantHoras(),c.getCreditos(),c.getFechaR(),c.getUrl(),c.getNombre(),dteb);
			cursosinstituto.add(dtcb);
		}
		setCursos(cursosinstituto);
		return this.cursos;
	}

	@Override
	public DtCurso consultarCurso(String curso) {
		DtCurso retorno = new DtCurso();
		ArrayList<DtProgramaBase> programas = new ArrayList<DtProgramaBase>();
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		// Buscar ProgFormacion que incluyan a este curso y guardarlos para crear el DtCurso a retornar 
		for(ProgFormacion pf: mP.getProgramas()) {
			for(Curso c: pf.getCursos()) {
				if(c.getNombre().equals(curso)) {
					DtProgramaBase progf = new DtProgramaBase(pf.getNombre());
					programas.add(progf);
				}
			}
		}
		for(DtCurso dtc: this.cursos) {
			if (dtc.getNombre().equals(curso)) {
				retorno = dtc;
			}
		}
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

