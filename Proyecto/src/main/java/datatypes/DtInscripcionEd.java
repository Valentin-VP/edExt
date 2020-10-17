package datatypes;

public class DtInscripcionEd {
	private DtFecha fecha;
	private EstadoInscripcion estado;
	private DtEdicionBase edicion;
	private DtUsuarioBase estudiante;
	
	public DtInscripcionEd() {
		super();
	}

	public DtInscripcionEd(DtFecha fecha, EstadoInscripcion estado, DtEdicionBase edicion, DtUsuarioBase estudiante) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.edicion = edicion;
		this.estudiante = estudiante;
	}

	public DtFecha getFecha() {
		return fecha;
	}

	public void setFecha(DtFecha fecha) {
		this.fecha = fecha;
	}

	public EstadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}

	public DtEdicionBase getEdicion() {
		return edicion;
	}

	public void setEdicion(DtEdicionBase edicion) {
		this.edicion = edicion;
	}

	public DtUsuarioBase getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(DtUsuarioBase estudiante) {
		this.estudiante = estudiante;
	}
	
	
}
