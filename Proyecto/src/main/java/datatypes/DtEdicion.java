package datatypes;

public class DtEdicion extends DtEdicionBase {
	private DtFecha fechaI;
	private DtFecha fechaF;
	private Integer cupo;
	private DtFecha fechaPub;
	
	public DtEdicion() {
		super();
	}
	
	public DtEdicion(String nombre, DtFecha fechaI, DtFecha fechaF, Integer cupo,DtFecha fechaPub) {
		super(nombre);
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cupo = cupo;
		this.fechaPub = fechaPub;
	}

	public DtFecha getFechaI() {
		return fechaI;
	}

	public void setFechaI(DtFecha fechaI) {
		this.fechaI = fechaI;
	}

	public DtFecha getFechaF() {
		return fechaF;
	}

	public void setFechaF(DtFecha fechaF) {
		this.fechaF = fechaF;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public DtFecha getFechaPub() {
		return fechaPub;
	}

	public void setFechaPub(DtFecha fechaPub) {
		this.fechaPub = fechaPub;
	}
	
}
