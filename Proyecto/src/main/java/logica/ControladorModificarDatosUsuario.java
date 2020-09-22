package logica;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import datatypes.DtUsuarioBase;
import interfaces.IControladorModificarDatosUsuario;

public class ControladorModificarDatosUsuario implements IControladorModificarDatosUsuario {
	String nick;
	String correo;
	String nombre;
	String apellido;
	DtFecha fechaNac;
	String password;
	
	public String getNick() {
		return nick;
	}
	public void setUsuario(String nick) {
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
	public DtFecha getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(DtFecha fechaNac) {
		this.fechaNac = fechaNac;
	}	
	@Override
	public ArrayList<DtUsuarioBase> mostrarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuarioBase> usuarios = new ArrayList<DtUsuarioBase>();
		for (Usuario u: mU.getUsuarios()) {
			DtUsuarioBase dtUsuarioBase = new DtUsuarioBase(u.getNick(), u.getCorreo());
			usuarios.add(dtUsuarioBase);
		}
		return usuarios;
	}
	@Override
	public DtUsuario seleccionarUsuario(String nick, String correo) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.findUsuario(nick);
		return user.getDtUsuario();
	}
	@Override
	public void modificarDatosUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, String password) {
		
	}
	@Override
	public void limpiar() {
		
	}
	/*@Override
	public void editarNombre(String nuevoNombre) {
		this.setNombre(nuevoNombre);//??
	}
	@Override
	public void editarApellido(String nuevoApellido) {
		this.setApellido(nuevoApellido);//??
	}
	@Override
	public void editarFNac(DtFecha nuevaFecha) {
		this.setFechaNac(nuevaFecha);//??
	}
	*/
	
	public static void main(String[] args) {
		String password = "The quick brown fox jumps over the lazy dog";

		System.out.print(sha256(password));
	}
	
	// encriptar a SHA-256 o SHA3-156
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        //byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	// encriptar a AES
	
}
