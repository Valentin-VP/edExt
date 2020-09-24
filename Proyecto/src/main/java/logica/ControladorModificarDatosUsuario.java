package logica;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import datatypes.DtUsuarioBase;
import excepciones.SinUsuarios;
import excepciones.UsuarioNoExiste;
import interfaces.IControladorModificarDatosUsuario;

public class ControladorModificarDatosUsuario implements IControladorModificarDatosUsuario {
	String nick;
	String correo;
	String nombre;
	String apellido;
	DtFecha fechaNac;
	String password;
	Usuario usuario;
	
	@Override
	public ArrayList<DtUsuarioBase> mostrarUsuarios() throws SinUsuarios {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuarioBase> usuarios = new ArrayList<DtUsuarioBase>();
		if (mU.getUsuarios().isEmpty()) {
			throw new SinUsuarios("No hay usuarios ingresados");
		}
		for (Usuario u: mU.getUsuarios()) {
			DtUsuarioBase dtU = new DtUsuarioBase(u.getNick(),u.getCorreo());
			usuarios.add(dtU);
		}
		return usuarios;
	}
	@Override
	public DtUsuario seleccionarUsuario(String nick, String correo) throws UsuarioNoExiste{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.findUsuario(nick);;
		if (user == null) {
			throw new UsuarioNoExiste("No existe el usuario seleccionado");
		}
		this.usuario = user;
		return user.getDtUsuario();
	}
	@Override
	public void modificarDatosUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, char[] password) {
		String passwd = new String(password);
		this.nick = nick;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.password = encriptar(passwd);
		Date fecha = null;
		try {
			fecha = fechaNac.DtFechaToDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		usuario.setCorreo(correo);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setFechaNac(fecha);
		if (!passwd.equals("")) {
			usuario.setPassword(encriptar(passwd));	
		}
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.actualizarUsuario(usuario);
	}
	@Override
	public void limpiar() {
		this.nick = "";
		this.correo = "";
		this.nombre = "";
		this.apellido = "";
		this.fechaNac = null;
		this.password = "";
		this.usuario = null;
	}
	
	// encriptar a SHA-256, SHA-512 o SHA3-256
	public static String encriptar(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-512");
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

}
