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
	public DtInstituto[] listarInstitutos() throws SinInstitutos {
		List<DtInstituto> institutos = icon.listarInstitutos();
		int i = 0;
		DtInstituto[] ret = new DtInstituto[institutos.size()];
        for(DtInstituto ins : institutos) {
            ret[i]=ins;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtCursoBase[] ingresarInstituto(String nomIns) throws InstitutoInexistente, InstitutoSinCursos {
		List<DtCursoBase> cursos = icon.ingresarInstituto(nomIns);
		int i=0;
		DtCursoBase[] ret = new DtCursoBase[cursos.size()];
		for(DtCursoBase c : cursos) {
            ret[i]=c;
            i++;
        }
		return ret;
	}
	
	@WebMethod
	public DtEdicionBase[] ingresarCurso(String nomCur) throws CursoNoExiste, EdicionNoExiste {
		List<DtEdicionBase> ediciones = icon.ingresarCurso(nomCur);
		int i=0;
		DtEdicionBase[] ret = new DtEdicionBase[ediciones.size()];
		for(DtEdicionBase e : ediciones) {
            ret[i]=e;
            i++;
        }
		return ret;
	}
	
	@WebMethod
	public DtEdicionCompleta ingresarEdicion(String edicion) throws EdicionNoExiste {
		return icon.ingresarEdicion(edicion);
	}
}
