package publicadores;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguration;
import datatypes.DtCursoBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtInscripcionEd;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.Fabrica;
import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorSeleccionarEstudiantesPublish {
	private Fabrica fabrica;
	private IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;
	private String mensaje = "vacio";

	public ControladorSeleccionarEstudiantesPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSeleccionarEstudiantesParaUnaEdicionDeCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSeleccionarEstudiantes", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSeleccionarEstudiantes");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtCursoBase[] listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos {
		//return icon.listarCursosInstituto(instituto);
		ArrayList<DtCursoBase> cursos;
		DtCursoBase[] ret = new DtCursoBase[10];
		try {
			cursos = icon.listarCursosInstituto(instituto);
			int i=0;
			ret = new DtCursoBase[cursos.size()];
			for(DtCursoBase c : cursos) {
	            ret[i]=c;
	            i++;
	        }
		} catch (InstitutoInexistente | InstitutoSinCursos e) {
			this.mensaje = e.getMessage();
		}
		return ret;
	}
	
	@WebMethod
	public DtEdicionCompleta seleccionarCurso(String nomCurso, String nick) throws EdicionVigenteNoExiste {
		DtEdicionCompleta dtec = new DtEdicionCompleta();
		try {
			dtec = icon.seleccionarCurso(nomCurso, nick);
		} catch (EdicionVigenteNoExiste e) {
			this.mensaje = e.getMessage();
		}
		return dtec;
	}
	
	@WebMethod
	public DtInscripcionEd[] ordenarInscripciones(String ordenarpor) {
		//return icon.ordenarInscripciones(ordenarpor);
		List<DtInscripcionEd> inscripciones = icon.ordenarInscripciones(ordenarpor);
		int i=0;
		DtInscripcionEd[] ret = new DtInscripcionEd[inscripciones.size()];
		for(DtInscripcionEd dti : inscripciones) {
            ret[i]=dti;
            i++;
        }
		return ret;
	}
	
	@WebMethod
	public void cambiarEstadoInscripcion(String nick, String estado) {
		icon.cambiarEstadoInscripcion(nick, estado);
	}
	
	@WebMethod
	public void setEdicion(String edicion) {
		icon.setEdicion(edicion);
	}
	
	@WebMethod
	public void confirmarSeleccion() {
		icon.confirmarSeleccion();
	}
	
	@WebMethod
	public void limpiar() {
		icon.limpiar();
	}
	
	@WebMethod
	public String getMensaje() {
		return this.mensaje;
	}
	
	@WebMethod
	public void setMensaje(String m) {
		this.mensaje = m;
	}

}