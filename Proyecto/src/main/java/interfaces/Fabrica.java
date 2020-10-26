package interfaces;
import logica.ControladorAgregarCursoProgFormacion;
import logica.ControladorAltaCategoria;
import logica.ControladorAltaCurso;
import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaProgFormacion;
import logica.ControladorAltaUsuario;
import logica.ControladorConsultaEdicionCurso;
import logica.ControladorConsultaPrograma;
import logica.ControladorConsultaUsuario;
import logica.ControladorInscripcionEdicionCurso;
import logica.ControladorListarAceptadosAUnaEdicionDeCurso;
import logica.ControladorListarResultadosInscripcionesEdiciones;
import logica.ControladorModificarDatosUsuario;
import logica.ControladorSeguirUsuario;
import logica.ControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;
import logica.ControladorSesion;
import logica.ControladorConsultaCurso;

public class Fabrica {
	private static Fabrica instancia = null;

	private Fabrica() {
		super();
	}
	
	public static Fabrica getInstancia() {
		if(instancia == null) {
			instancia = new Fabrica();
		}
		return instancia;
	}
	
	public IControladorAltaCurso getIControladorAltaCurso() {
		return new ControladorAltaCurso();
	}
	
	public IControladorConsultaUsuario getIControladorConsultaUsuario() {
		return new ControladorConsultaUsuario();
	}
	
	public IControladorConsultaCurso getIControladorConsultaCurso() {
		return new ControladorConsultaCurso();
	}
	
	public IControladorAltaEdicionCurso getIControladorAltaEdicionCurso() {
		return new ControladorAltaEdicionCurso();
	}
	
	public IControladorAltaInstituto getIControladorAltaInstituto() {
		return new ControladorAltaInstituto();
	}
	
	public IControladorAltaUsuario getIControladorAltaUsuario() {
		return new ControladorAltaUsuario();
	}
	
	public IControladorConsultaEdicionCurso getIControladorConsultaEdicionCurso() {
		return new ControladorConsultaEdicionCurso();
	}
	
	public IControladorModificarDatosUsuario getIControladorModificarDatosUsuario() {
		return new ControladorModificarDatosUsuario();
	}
	
	public IControladorInscripcionEdicionCurso getIControladorInscripcionEdicionCurso() {
		return new ControladorInscripcionEdicionCurso();
	}
	
	public IControladorAltaProgFormacion getIControladorAltaProgFormacion() {
		return new ControladorAltaProgFormacion();
	}
	
	public IControladorAltaCategoria getIControladorAltaCategoria() {
		return new ControladorAltaCategoria();
	}
	
	public IControladorConsultaPrograma getIControladorConsultaPrograma() {
		return new ControladorConsultaPrograma();
	}
	
	public IControladorSesion getIControladorSesion() {
		return new ControladorSesion();
	}
	
	public IControladorListarAceptadosAUnaEdicionDeCurso getIControladorListarAceptadosAUnaEdicionDeCurso() {
		return new ControladorListarAceptadosAUnaEdicionDeCurso();
	}
	
	public IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso getIControladorSeleccionarEstudiantesParaUnaEdicionDeCurso() {
		return new ControladorSeleccionarEstudiantesParaUnaEdicionDeCurso();
	}
	
	public IControladorListarResultadosInscripcionesEdiciones getIControladorListarResultadosInscripcionesEdiciones() {
		return new ControladorListarResultadosInscripcionesEdiciones();
	}
	
	public IControladorAgregarCursoProgFormacion getIControladorAgregarCursoAPF() {
		return new ControladorAgregarCursoProgFormacion();
	}
	
	public IControladorSeguirUsuario getIControladorSeguirUsuario() {
		return new ControladorSeguirUsuario();
	}
	
}
