package interfaces;

import java.util.List;

import excepciones.UsuarioNoExiste;
import logica.Usuario;

public interface IControladorConsultaUsuario {
	public List<Usuario> listarUsuarios();
	
	public void ElegirUsuario(String nick, String correo);

	public List<Usuario> obtenerSeguidores(String nick);
	
    public List<Usuario> obtenerSeguidos(String nick);
	
	//operacion si es docente
	
	//operacion si es estudiante --> yona
	
	//operacion perfil de docente
	
	//operacion perfil de estudiante
}
