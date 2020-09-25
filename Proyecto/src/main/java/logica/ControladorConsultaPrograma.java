package logica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtPrograma;
import datatypes.DtProgramaBase;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.ProgramaInexistente;
import excepciones.ProgramaSinCursos;
import excepciones.SinInstitutos;
import excepciones.SinProgramas;

public class ControladorConsultaPrograma implements interfaces.IControladorConsultaPrograma{
	private String programa;
	private String curso;
	private ArrayList<DtCurso> cursos = new ArrayList<DtCurso>();
	
	public ControladorConsultaPrograma() {
		super();
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	@Override
	public ArrayList<DtProgramaBase> listarProgramas() throws SinProgramas {
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		ArrayList<DtProgramaBase> dtprogramas = new ArrayList<DtProgramaBase>();
		if(mPF.getProgramas().isEmpty()) {
			throw new SinProgramas("No se han ingresado programas aun");
		}
		for(DtProgramaBase pb: mPF.getDtProgramasBase()) {
			DtProgramaBase dtpb = new DtProgramaBase(pb.getNombre());
			dtprogramas.add(dtpb);
		}
		return dtprogramas;
		/*instanciar manejadorPrograma
		 * lista DtProgramaBase
		 * lista = manejador.getProgramas()
		 * 
		 * recorrer lista
		 * {
		 *  	for each c in lista{
		 *  		lista.add(c)
		 *  	}
		 * }
		 * return lista
		 */
	}
	@Override
	public DtPrograma seleccionarPrograma(String nombre) throws ProgramaSinCursos, ProgramaInexistente {
		//busca un objeto programa con ese nombre en el manejadorPrograma.
		//construye el DtPrograma incluyendo todos los nombres de los cursos que este contiene
		//se necesita algo en la clase ProgFormacion (un getCursos) que devuelva los objetos Curso asociados a el
		//tambien getDtCursoBase en Curso.
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		if (!mPF.exists(nombre)) {
			throw new ProgramaInexistente("No existe ese programa.");
		}
		DtPrograma retorno;
		ArrayList <DtCursoBase> cursosprograma = new ArrayList <DtCursoBase>();
		String name = mPF.getProgFormacion(nombre).getNombre();
		String desc= mPF.getProgFormacion(nombre).getDesc();
		DtFecha fechaIni= mPF.getProgFormacion(nombre).getFechaI();
		DtFecha fechaFin= mPF.getProgFormacion(nombre).getFechaF();
		DtFecha fechaAlta= mPF.getProgFormacion(nombre).getFechaAlta();
		Date fI = new Date();
		Date fF = new Date();
		Date fA = new Date();
		try {	//WTF
			fI = fechaIni.DtFechaToDate();
			fF = fechaFin.DtFechaToDate();
			fA = fechaAlta.DtFechaToDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(!mPF.getProgFormacion(nombre).getCursos().isEmpty()) {
			for(Curso c: mPF.getProgFormacion(nombre).getCursos()) {
				DtCursoBase dtcb = new DtCursoBase(c.getNombre());
				cursosprograma.add(dtcb);
			}
		}
		retorno = new DtPrograma(name, desc, fI, fF, fA, cursosprograma);	//Retornar los DtCursoBase?? No se si es "necesario", porque lo hace abajo
		return retorno;
	}
	@Override
	public ArrayList<DtCurso> listarCursosPrograma(String programaFormacion) throws ProgramaSinCursos, ProgramaInexistente {
		ArrayList <DtCurso> cursosprograma = new ArrayList <DtCurso>();
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		if (!mPF.exists(programaFormacion)) {
			throw new ProgramaInexistente("No existe ese programa.");
		}
		if(mPF.getProgFormacion(programaFormacion).getCursos().isEmpty()) {
			throw new ProgramaSinCursos("El Programa de Formacion seleccionado no posee cursos aun");
		}
		else {
			for(Curso c: mPF.getProgFormacion(programaFormacion).getCursos()) {	
				//Esto no esta bien, al DtCurso le faltaria el Institut y la Categoria, al mismo tiempo tiene datos de sobra pero whatever
				// Nico, se agregan categorias e instituto. By: jedik-no
				String ins = c.getInstituto().getNombre();
				ArrayList<String> categories = new ArrayList <String>();
				for(Categoria cat: c.getCategorias()) {
					String strcat = cat.getNombre();
					categories.add(strcat);
				}
				DtCurso dtc = new DtCurso(c.getDescripcion(), c.getDuracion(), c.getCantHoras(), c.getCreditos(), new DtFecha(), c.getUrl(), c.getNombre(), new ArrayList<DtEdicionBase>(), new ArrayList<DtCursoBase>(),ins,categories);

				cursosprograma.add(dtc);
			}
		}
		programaFormacion = programa;
		this.cursos = cursosprograma;
		return this.cursos;		
	}

	@Override
	public DtCurso seleccionarCurso(String nombre) {
		
		return null;
	}
}
