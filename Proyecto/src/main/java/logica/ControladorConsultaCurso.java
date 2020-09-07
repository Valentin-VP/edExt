package logica;

import java.util.*;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtProgramaBase;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.IControladorConsultaCurso;

public class ControladorConsultaCurso implements IControladorConsultaCurso{
	private ArrayList<DtCursoBase> cursos = new ArrayList<DtCursoBase>();

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
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos{
		System.out.println("Entra en listarCursos");
		ArrayList <DtCursoBase> cursosinstituto = new ArrayList <DtCursoBase>();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto institutoI = mI.find(instituto);
		if(!mI.existeInstituto(instituto)) {
			throw new InstitutoInexistente("No existe el Instituto seleccionado.");
		}
		ArrayList<Curso> cursos = mI.find(instituto).getCursos();
		if(cursos.isEmpty()) {
			throw new InstitutoSinCursos("El Instituto seleccionado no posee cursos a�n");
		}
		for(Curso c: cursos) {
			DtCursoBase dtcb = new DtCursoBase (c.getNombre());
			cursosinstituto.add(dtcb);
		}
		setCursos(cursosinstituto);
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

