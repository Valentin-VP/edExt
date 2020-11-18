package logica;

import logica.ManejadorUsuario;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import datatypes.DtEdicion;
import datatypes.DtPrograma;
import datatypes.DtUsuario;
import datatypes.EstadoInscripcion;
import excepciones.UsuarioNoExiste;
import interfaces.IControladorConsultaUsuario;

@SuppressWarnings("unused")
public class ControladorConsultaUsuario implements IControladorConsultaUsuario {
	private Usuario user;
	
	@Override
	public List<Usuario> listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.getUsuarios();
	}
	
	@Override
	public ArrayList<DtUsuario> listarDtUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuario> usuarios = new ArrayList<DtUsuario>();
		for(Usuario u: mU.getUsuarios()) {
			usuarios.add(u.getDtUsuario());
		}
		return usuarios;
	}
	
	@Override
	public DtUsuario ElegirUsuario(String nick, String correo) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.findUsuario(nick).getDtUsuario();
	}
	
	@Override
	public List<Usuario> obtenerSeguidores() {
		return this.user.getSiguen();
	}
	
	@Override
	public List<Usuario> obtenerSeguidos() {
		return this.user.getSigue();
	}
	
	@Override
	public List<DtEdicion> infoEdiciones(boolean esDocente) {
		List<DtEdicion> ediciones = new ArrayList<DtEdicion>();
		if(esDocente) {
			for(Edicion e:((Docente) user).getEdiciones()) {
				DtEdicion edi = e.getDtEdicion();
				ediciones.add(edi);
			}
		} else {
			for(InscripcionEd ied:((Estudiante) user).getInscripcionesEd()) {
				if(ied.getEstado().equals(EstadoInscripcion.Inscripto) || ied.getEstado().equals(EstadoInscripcion.Aceptada)) {
					DtEdicion edi = ied.getEdicion().getDtEdicion();
					ediciones.add(edi);
				}	
			}
		}	
		return ediciones;
	}
	
	@Override
	public List<DtPrograma> infoProgramas() throws ParseException {
		List<DtPrograma> programas = new ArrayList<DtPrograma>();
		for(InscripcionPF ipf: ((Estudiante) user).getInscripcionesPf()) {
			DtPrograma prog = ipf.getPrograma().getDtPrograma();
			programas.add(prog);
		}
		return programas;
	}
}
