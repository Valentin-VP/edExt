package logica;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import interfaces.IControladorSesion;

public class ControladorSesion implements IControladorSesion{
	private String nick = "";
	private String password = "";
	@Override
	public boolean existeUsuario(String id) {
		this.nick = "";
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		boolean existe = false;
		if(id.contains("@")) {
			for(Usuario u: mU.getUsuarios()) {
				if(u.getCorreo().equals(id)) {
					existe = true;
					
				}
			}
		}
		else {
			if(mU.findUsuario(id) != null) {
				existe = true;
			}
		}
		return existe;
	}
	
	public String identificarUsuario(String id, String hashpass) {
		String tipo = ""; //"estudiante" "docente"
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(id.contains("@")) {
			for(Usuario u: mU.getUsuarios()) {
				if(u.getCorreo().equals(id) && u.getPassword().equals(hashpass)) {
					if(u instanceof Docente)
						tipo = "docente";
					else
						tipo = "estudiante";
					this.nick = u.getNick();
					this.password = u.getPassword();
				}
			}
		}
		else {
			if(mU.findUsuario(id) != null) {
				Usuario u = mU.findUsuario(id);
				if(u.getPassword().equals(hashpass)) {
					if(u instanceof Docente)
						tipo = "docente";
					else
						tipo = "estudiante";
					this.nick = u.getNick();
				}
			}
		}
		return tipo;
	}

	@Override
	public String obtenerNick() {
		return this.nick;
	}

	@Override
	public String obtenerPassword() {
		return this.password;
	}
	
	@Override
	public String codificarPass(String contrasenia) throws NoSuchAlgorithmException {
		MessageDigest md = null;
		byte[] mb = null;
	        try {
	            md = MessageDigest.getInstance("SHA-512");
	            mb = md.digest(contrasenia.getBytes());
	        } catch  (NoSuchAlgorithmException e) {
				e.printStackTrace();
	        }
	        StringBuffer sb = new StringBuffer();
	        for(byte b: mb) {
	        	sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	}
	
}
