package datatypes;

public class DtCursoBase {
	private String nombre;
	private String instituto;

	public DtCursoBase() {
		super();
	}
	
	public DtCursoBase(String nombre, String instituto) {
		super();
		this.nombre = nombre;
		this.setInstituto(instituto);
	}

	public DtCursoBase(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
}
