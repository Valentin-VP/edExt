package logica;

import interfaces.IControladorAltaCurso;
import datatypes.DtCurso;
import datatypes.DtTime;
import datatypes.DtFecha;

public class ControladorAltaCurso implements IControladorAltaCurso{
	private DtCurso curso;
	private String instituto;
	private String nombre;
	private String descripcion;
	private String duracion;
	private DtTime cantHoras;
	private int creditos;
	private DtFecha fechaR;
	
	public ControladorAltaCurso(DtCurso curso, String instituto, String nombre, String descripcion, String duracion,
			DtTime cantHoras, int creditos, DtFecha fechaR) {
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
	public DtTime getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(DtTime cantHoras) {
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
	@Override
	public boolean altaCurso(String instituto, String nombre, String descripcion, String duracion, DtTime cantHoras,
			int creditos, String url, DtFecha fechaR) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setPrevias(String previas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean modificarAltacurso(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void confirmarAltaCurso() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cancelarAltaCurso() {
		// TODO Auto-generated method stub
		
	}
}
