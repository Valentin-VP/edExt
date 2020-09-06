package datatypes;

public class DtUsuario extends DtUsuarioBase {
	private String nick;
	private String nombre;
	private String correo;
	private String apellido;
	private DtFecha fechaNac;
	
	public DtUsuario() {
		super();
	}
	
	public DtUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac) {
		super(nick, correo);
		this.nick = nick;
		this.correo = correo;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
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
