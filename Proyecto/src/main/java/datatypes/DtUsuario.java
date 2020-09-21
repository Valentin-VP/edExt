package datatypes;

public class DtUsuario extends DtUsuarioBase {
	private String nombre;
	private String apellido;
	private DtFecha fechaNac;
	private String password;
	
	public DtUsuario() {
		super();
	}
	
	public DtUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, String password) {
		super(nick, correo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.password = password;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
