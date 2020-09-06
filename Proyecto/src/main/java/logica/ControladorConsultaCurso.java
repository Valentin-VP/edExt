package logica;

import java.util.ArrayList;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtProgramaBase;
import datatypes.DtTime;
import excepciones.InstitutoInexistente;
import interfaces.IControladorConsultaCurso;
import excepciones.InstitutoInexistente;

public class ControladorConsultaCurso implements IControladorConsultaCurso{
	private ArrayList<DtCursoBase> cursos;
	/*
	 * private DtCurso curso; private ArrayList<DtEdicionBase> ediciones; private
	 * 
	 */
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
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.existeInstituto(instituto)) {
			throw new InstitutoInexistente("No existe el Instituto seleccionado.");
		}
		setCursos(mI.find(instituto).getCursos());
		return this.cursos;
	}

	@Override
	public DtCurso consultarCurso(String curso) {
		ArrayList<DtProgramaBase> programas = new ArrayList<>();
		Curso temp;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		temp = mC.find(curso);
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		// Buscar ProgFormacion que incluyan a este curso y guardarlos para crear el DtCurso a retornar 
		for(ProgFormacion pf: mP.getProgramas()) {
			for(Curso c: pf.getCursos()) {
				if(c.getNombre()==curso) {
					DtProgramaBase progf = new DtProgramaBase(pf.getNombre());
					programas.add(progf);
				}
			}
		}
		return new DtCurso(temp.getDescripcion(),temp.getDuracion(),temp.getCantHoras(),temp.getCreditos(),temp.getFechaR(),temp.getUrl(),temp.getNombre(),temp.getEdiciones(),programas);
	}
	
	
}
