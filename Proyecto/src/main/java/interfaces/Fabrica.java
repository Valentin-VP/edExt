package interfaces;
import logica.ControladorAltaCurso;
import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaUsuario;
import logica.ControladorConsultaEdicionCurso;
import logica.ControladorModificarDatosUsuario;
import logica.ControladorConsultaCurso;

public class Fabrica {
	private static Fabrica instancia = null;

	private Fabrica() {
		super();
		// TODO Auto-generated constructor stub
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
}
