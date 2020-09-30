package interfaces;

import java.text.ParseException;
import java.util.List;

import datatypes.DtEdicion;
import datatypes.DtPrograma;
import datatypes.DtUsuario;
import excepciones.UsuarioNoExiste;
import logica.Usuario;

public interface IControladorConsultaUsuario {
	public List<Usuario> listarUsuarios();
	
	public DtUsuario ElegirUsuario(String nick, String correo);

	public List<Usuario> obtenerSeguidores();
	
    public List<Usuario> obtenerSeguidos();
	
    public List<DtEdicion> infoEdiciones(boolean esDocente);
	
	public List<DtPrograma> infoProgramas() throws ParseException;

}
