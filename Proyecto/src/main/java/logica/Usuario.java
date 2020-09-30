package logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import datatypes.DtFecha;
import datatypes.DtUsuario;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	@Id
	private String nick;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Usuario> seguidos = new ArrayList<Usuario>();
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Usuario> seguidores = new ArrayList<Usuario>();
	
	private String correo;
	private String nombre;
	private String apellido;
	private Date  fechaNac;
	private String password;
	
	public Usuario(String nick, String nombre, String apellido, String correo, Date  fechaNac, String password) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
		this.password = password;
	}
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date  getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date  fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public List<Usuario> getSigue() {
		return seguidos;
	}

	public void setSigue(List<Usuario> sigue) {
		this.seguidos = sigue;
	}
	
	public void addSeguido(Usuario seguido) {
		this.seguidos.add(seguido);
	}
	
	public void removeSeguido(Usuario seguido) {
		this.seguidos.remove(seguido);
	}
	
	public List<Usuario> getSiguen() {
		return seguidores;
	}
	
	public void setSiguen(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	
	public void addSeguidor(Usuario seguidor) {
		this.seguidores.add(seguidor);
	}
	
	public void removeSeguidor(Usuario seguidor) {
		this.seguidores.remove(seguidor);
	}

	public DtUsuario getDtUsuario() {
		ArrayList<Integer> datos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(fechaNac); 
		String valores [] = (date).split("/");
		for(String s: valores) {
			int temp = Integer.parseInt(s);
			datos.add(temp);
		}
		DtFecha fechaR = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
		
		DtUsuario dtUsuario = new DtUsuario(this.nick, this.correo, this.nombre, this.apellido, fechaR, this.password);

		return dtUsuario;
	}
	
}
