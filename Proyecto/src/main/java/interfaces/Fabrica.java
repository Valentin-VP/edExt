package interfaces;
import logica.ControladorAltaCurso;
import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaUsuario;
import logica.ControladorConsultaEdicionCurso;
import logica.ControladorModificarDatosUsuario;

public class Fabrica {
	private static Fabrica instancia = null;

	public Fabrica() {
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
	
	public IControladorAltaEdicionCurso ControladorAltaEdicionCurso() {
		return new ControladorAltaEdicionCurso();
	}
	
	public IControladorAltaInstituto ControladorAltaInstituto() {
		return new ControladorAltaInstituto();
	}
	
	public IControladorAltaUsuario ControladorAltaUsuario() {
		return new ControladorAltaUsuario();
	}
	
	public IControladorConsultaEdicionCurso ControladorConsultaEdicionCurso() {
		return new ControladorConsultaEdicionCurso();
	}
	
	public IControladorModificarDatosUsuario ControladorModificarDatosUsuario() {
		return new ControladorModificarDatosUsuario();
	}
}
