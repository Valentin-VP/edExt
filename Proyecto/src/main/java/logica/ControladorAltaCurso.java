package logica;

import interfaces.IControladorAltaCurso;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;

import java.util.ArrayList;

import datatypes.DtCurso;
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
	private ArrayList<Curso> previas;
	
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
	
	public ArrayList<Curso> getPrevias() {
		return previas;
	}

	public void setPrevias(ArrayList<Curso> previas) {
		this.previas=previas;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void agregarPrevia(String previa) {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso cursoprevio = mC.find(previa);
		if(cursoprevio != null ) {
			this.previas.add(cursoprevio);
		}
		
	}
	
	@Override
	public void confirmarAltaCurso() {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso curso = new Curso(getNombre(), getDescripcion(), getDuracion(), getCantHoras(), getCreditos(), getFechaR(), getUrl(), getPrevias());
		mC.agregarCurso(curso);
		
	}
	@Override

	public void cancelarAltaCurso() {
		setInstituto(null);
		setNombre(null);
		setDescripcion(null);
		setDuracion(null);
		setCantHoras(0);
		setCreditos(0);
		setUrl(null);
		setFechaR(null);
	}
	
	
	@Override
	public void altaCurso(String instituto, String nombre, String descripcion, String duracion, int cantHoras, int creditos, String url, DtFecha fechaR) throws CursoRepetido, InstitutoInexistente {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(!mI.existeInstituto(instituto)) {
			throw new InstitutoInexistente("No existe el Instituto seleccionado.");
		}
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		if(mC.exists(nombre)) {
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
