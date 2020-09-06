package datatypes;

public class DtUsuario extends DtUsuarioBase {
	private String nombre;
	private String apellido;
	private DtFecha fechaNac;
	
	public DtUsuario() {
		super();
	}
	
	public DtUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) {
		super(nick, correo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public DtFecha getFechaNac() {
		return fechaNac;
	}
	
	public void setFechaNac(DtFecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	
}
