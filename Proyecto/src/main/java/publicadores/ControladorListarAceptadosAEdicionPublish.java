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
import datatypes.DtEdicionBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorListarAceptadosAEdicionPublish {
	private Fabrica fabrica;
	private IControladorListarAceptadosAUnaEdicionDeCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;
	private String mensaje;
	
	public ControladorListarAceptadosAEdicionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorListarAceptadosAUnaEdicionDeCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorListarAceptadosAEdicion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorListarAceptadosAEdicion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}

	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public DtInstituto[] listarInstitutos() throws InstitutoInexistente {
		this.mensaje = "";
		List<DtInstituto> institutos;
		DtInstituto[] ret;
		try {
			institutos = icon.listarInstitutos();
			int i = 0;
			ret = new DtInstituto[institutos.size()];
	        for(DtInstituto ins : institutos) {
	            ret[i]=ins;
	            i++;
	        }
       		
		} catch (SinInstitutos e) {
			this.mensaje = e.getMessage();
		}
		return new DtInstituto[0];
	}
	
	@WebMethod
	public DtCursoBase[] ingresarInstituto(String nomIns) throws InstitutoInexistente, InstitutoSinCursos {
		this.mensaje = "";
		List<DtCursoBase> cursos;
		DtCursoBase[] ret;
		try {
			cursos = icon.ingresarInstituto(nomIns);
			int i=0;
			ret = new DtCursoBase[cursos.size()];
			for(DtCursoBase c : cursos) {
	            ret[i]=c;
	            i++;
	        }
			return ret;
		} catch (InstitutoInexistente | InstitutoSinCursos e) {
			this.mensaje = e.getMessage();
		}
		return new DtCursoBase[0];
	}
	
	@WebMethod
	public DtEdicionBase[] ingresarCurso(String nomCur) throws CursoNoExiste, EdicionNoExiste {
		this.mensaje = "";
		List<DtEdicionBase> ediciones;
		DtEdicionBase[] ret;
		try {
			ediciones = icon.ingresarCurso(nomCur);
			int i=0;
			ret = new DtEdicionBase[ediciones.size()];
			for(DtEdicionBase e : ediciones) {
	            ret[i]=e;
	            i++;
	        }
			return ret;
		} catch (CursoNoExiste | EdicionNoExiste e) {
			this.mensaje = e.getMessage();
		}
		return new DtEdicionBase[0];
	}
	
	@WebMethod
	public DtEdicionCompleta ingresarEdicion(String edicion) throws EdicionNoExiste {
		this.mensaje = "";
		try {
			return icon.ingresarEdicion(edicion);
		} catch (EdicionNoExiste e) {
			this.mensaje = e.getMessage();
			return new DtEdicionCompleta();
		}
	}
	@WebMethod
	public String getMensaje() {
		return this.mensaje;
	}
}
