package publicadores;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public DtCursoBase[] listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos {
		//return icon.listarCursosInstituto(instituto);
		List<DtCursoBase> cursos = icon.listarCursosInstituto(instituto);
		int i=0;
		DtCursoBase[] ret = new DtCursoBase[cursos.size()];
		for(DtCursoBase c : cursos) {
            ret[i]=c;
            i++;
        }
		return ret;
	}
	
	@WebMethod
	public DtEdicionCompleta seleccionarCurso(String nomCurso, String nick) throws EdicionVigenteNoExiste {
		return icon.seleccionarCurso(nomCurso, nick);
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
	
	/*@WebMethod
	public DtSocio[] obtenerInfoSociosPorClase (int idClase){
		List<DtSocio> dtsocio = icon.obtenerInfoSociosPorClase(idClase);
		int i = 0;
        DtSocio[] ret = new DtSocio[dtsocio.size()];
        for(DtSocio s : dtsocio) {
            ret[i]=s;
            i++;
        }
        return ret;
	}*/

}