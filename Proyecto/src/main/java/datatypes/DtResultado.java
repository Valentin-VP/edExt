package datatypes;

public class DtResultado {
	
	private String nombreEdicion;
	private EstadoInscripcion resultadoEdicion;
	
	
	public DtResultado() {
		super();
	}

	public DtResultado(String nombreEdicion, EstadoInscripcion resultadoEdicion) {
		super();
		this.nombreEdicion = nombreEdicion;
		this.resultadoEdicion = resultadoEdicion;
	}

	public String getNombreEdicion() {
		return nombreEdicion;
	}

	public void setNombreEdicion(String nombreEdicion) {
		this.nombreEdicion = nombreEdicion;
	}

	public EstadoInscripcion getResultadoEdicion() {
		return resultadoEdicion;
	}

	public void setResultadoEdicion(EstadoInscripcion resultadoEdicion) {
		this.resultadoEdicion = resultadoEdicion;
	}
	
	
	
}
