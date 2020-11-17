package interfaces;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtUsuario;
import excepciones.SinInstitutos;
import excepciones.UsuarioRepetido;
import logica.Instituto;

public interface IControladorAltaUsuario {
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, String password) throws UsuarioRepetido; 
	
	public void seleccionarInstituto(String instituto);
	
	//public void modificarAltaUsuario(String nuevoNick, String nuevoCorreo) throws UsuarioRepetido;
	
	public void cancelarAltaUsuario();
	
	public void confirmarAltaUsuario(boolean esDocente) throws NoSuchAlgorithmException;
	
	public List<Instituto> getInstitutos();
	
	public ArrayList<DtInstituto> listarInstitutos() throws SinInstitutos;
	
	public String codificarPass(String contrasenia) throws NoSuchAlgorithmException;

	DtUsuario getUsuario();

	void setUsuario(DtUsuario usuario);

	Instituto getInstituto();

	void setInstituto(Instituto instituto);
	
}
