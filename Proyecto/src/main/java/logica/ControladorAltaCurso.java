package logica;

import interfaces.IControladorAltaCurso;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;

import java.util.ArrayList;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtFecha;

public class ControladorAltaCurso implements IControladorAltaCurso{
	private DtCurso curso;
	private String instituto;
	private String nombre;
	private String descripcion;
	private String duracion;
	private int cantHoras;
	private int creditos;
	private DtFecha fechaR;
	private String url;
	private ArrayList<DtCursoBase> previas = new ArrayList<DtCursoBase>();
	
	public ControladorAltaCurso() {
		super();
	}
	
	public ControladorAltaCurso(DtCurso curso, String instituto, String nombre, String descripcion, String duracion,
			int cantHoras, int creditos, DtFecha fechaR) {
		super();
		this.curso = curso;
		this.instituto = instituto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
	}
	public DtCurso getCurso() {
		return curso;
	}
	public void setCurso(DtCurso curso) {
		this.curso = curso;
	}
	public String getInstituto() {
		return instituto;
	}
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public int getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public DtFecha getFechaR() {
		return fechaR;
	}
	public void setFechaR(DtFecha fechaR) {
		this.fechaR = fechaR;
	}
	
	public ArrayList<DtCursoBase> getPrevias() {
		return previas;
	}
	@Override
	public void setPrevias(ArrayList<DtCursoBase> previas) {
		this.previas=previas;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void agregarPrevia(String previa) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(mI.find(this.instituto).existsCurso(previa)) {
			DtCursoBase dtcb = new DtCursoBase(mI.find(this.instituto).findCurso(previa).getNombre());
			previas.add(dtcb);
		}
	}
	
	@Override
	public void confirmarAltaCurso() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		ArrayList<Curso> previascursos = new ArrayList <Curso>();
		if(!getPrevias().isEmpty()) {
			for(DtCursoBase dtcb: getPrevias()) {
				if(mI.find(this.instituto).existsCurso(dtcb.getNombre())) {
					previascursos.add((mI.find(this.instituto).findCurso(dtcb.getNombre())));
				}
			}
		}
		Curso curso = new Curso(getNombre(), getDescripcion(), getDuracion(), getCantHoras(), getCreditos(), getFechaR(), getUrl(), previascursos);
		mI.find(this.instituto).agregarCurso(curso);
		cancelarAltaCurso();
	}
	@Override

	public void cancelarAltaCurso() {
		this.curso = null;
		this.instituto = null;
		this.nombre = null;
		this.descripcion = null;
		this.duracion = null;
		this.cantHoras = 0;
		this.creditos = 0;
		this.fechaR = null;
		this.url = null;
		this.previas = new ArrayList<DtCursoBase>();
	}
	
	
	@Override
	public void altaCurso(String instituto, String nombre, String descripcion, String duracion, int cantHoras, int creditos, String url, DtFecha fechaR) throws CursoRepetido, InstitutoInexistente {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.existeInstituto(instituto)) {
			throw new InstitutoInexistente("No existe el Instituto seleccionado.");
		}
		if(mI.find(instituto).existsCurso(nombre)) {
			throw new CursoRepetido("Ya existe un Curso con ese nombre en el Instituto seleccionado.");
		}
		setInstituto(instituto);
		setNombre(nombre);
		setDescripcion(descripcion);
		setDuracion(duracion);
		setCantHoras(cantHoras);
		setCreditos(creditos);
		setUrl(url);
		setFechaR(fechaR);
		
	} 
	
}
