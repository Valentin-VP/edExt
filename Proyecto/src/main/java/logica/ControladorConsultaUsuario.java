package logica;

import logica.ManejadorUsuario;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import datatypes.DtEdicion;
import datatypes.DtPrograma;
import datatypes.DtUsuario;
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
				if(ied.getEstado().equals("Inscripto") || ied.getEstado().equals("Aceptada")) {
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
