 package logica;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;
import excepciones.SinInstitutos;
import excepciones.UsuarioRepetido;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;//aca queda guardada la contrasenia sin codificar
	private Instituto instituto;
	
	public ControladorAltaUsuario() {
		super();
	}
	
	@Override
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, String password) throws UsuarioRepetido {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usuario.setPassword(password);
		Usuario user = null;
		//user = mU.getUsuario(nick, correo);
		user = mU.findUsuario(nick);
		// Operacion que traiga todos los Usuarios de la BD y confirme que ninguno tenga el mismo correo
		ArrayList<String> correosUsuarios = mU.getUsuariosCorreo();
		for(String ucorreo: correosUsuarios) {
			if(ucorreo.equals(correo)) {
				throw new UsuarioRepetido("El correo " + correo + " ya se encuentra registrado");
			}
		}
		if(!(user == null)) {
			throw new UsuarioRepetido("El usuario " + nick + " ya se encuentra registrado");
		}	
		this.usuario = new DtUsuario(nick, correo, nombre, apellido, fechaNac, password);
	}
	
	@Override
	public void seleccionarInstituto(String instituto) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		this.instituto = mI.find(instituto);
	}
	
	
	@Override
	public void cancelarAltaUsuario() {
		
	}
	
	public String codificarPass(String contrasenia) throws NoSuchAlgorithmException {//version beta del codificado, todavia no se si hacer una funcion que decodifique o guardar la version sin codificar en algun lado
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
	
	@Override
	public void confirmarAltaUsuario(boolean esDocente) throws NoSuchAlgorithmException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user;
		Date fechadate = null;
		try {
			fechadate = usuario.getFechaNac().DtFechaToDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String laPass = new String();
		try {
			laPass = codificarPass(this.usuario.getPassword());
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}

		if (esDocente) {	
			user = new Docente(usuario.getNick(), usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(), fechadate, this.instituto, /*usuario.getPassword()*/ laPass);
		} else {
			user = new Estudiante(usuario.getNick(), usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(), fechadate, /*usuario.getPassword()*/ laPass);
		}	
		mU.agregarUsuario(user);
	}
	
	public DtUsuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(DtUsuario usuario) {
		this.usuario = usuario;
	}
	
	public Instituto getInstituto() {
		return instituto;
	}
	
	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	
	public List<Instituto> getInstitutos() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		return mI.getInstitutos();
	}
	
	@Override
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if (mI.getDtInstitutos().isEmpty()) {
			throw new SinInstitutos("No hay institutos ingresados");
		}
		return mI.getDtInstitutos();
	}
}
