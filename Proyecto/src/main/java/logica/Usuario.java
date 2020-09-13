package logica;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import datatypes.DtFecha;
import datatypes.DtUsuario;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//nuevo
public class Usuario {
	@Id
	private String nick;
	
	private String correo;
	private String nombre;
	private String apellido;
	private DtFecha fechaNac;
	
	public Usuario(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
	}

	public Usuario() {
		super();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public DtFecha getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(DtFecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public DtUsuario getDtUsuario() {
		DtUsuario dtUsuario = new DtUsuario(this.nick, this.correo, this.nombre, this.apellido, this.fechaNac);
		return dtUsuario;
	}
	
}
