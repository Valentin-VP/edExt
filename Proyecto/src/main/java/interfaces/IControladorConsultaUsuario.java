package interfaces;

import java.util.List;

import excepciones.UsuarioNoExiste;
import logica.Usuario;

public interface IControladorConsultaUsuario {
	public List<Usuario> listarUsuarios();
	
	public void ElegirUsuario(String nick, String correo);
}
