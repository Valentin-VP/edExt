package datatypes;

public class DtEdicionBase {
	private String nombre;
	
	public DtEdicionBase() {
		super();
	}
	
	public DtEdicionBase(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
