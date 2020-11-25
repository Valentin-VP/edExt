package publicadores;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguration;
import datatypes.DtEdicion;
import datatypes.DtPrograma;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorConsultaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorConsultaUsuarioPublish {
	private Fabrica fabrica;
	private IControladorConsultaUsuario icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;
	private String mensaje = "vacio";
	
	public ControladorConsultaUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaUsuario();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaUsuario");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}
	
	@WebMethod
	public DtUsuario[] listarDtUsuarios() {
		List<DtUsuario> usuarios;
		DtUsuario[] ret = new DtUsuario[10];
		usuarios = icon.listarDtUsuarios();
		ret = new DtUsuario[usuarios.size()];
		int i = 0;
		for(DtUsuario ins : usuarios) {
			ret[i]=ins;
			i++;
	    }
        return ret;
	}
	
	@WebMethod
	public DtUsuario ElegirUsuario(String nick, String correo) {
		return icon.ElegirUsuario(nick, correo);
	}
	
	@WebMethod
	public DtEdicion[] infoEdiciones(boolean esDocente) {
		List<DtEdicion> ediciones = icon.infoEdiciones(esDocente);
		DtEdicion[] ret = new DtEdicion[ediciones.size()];
		int i = 0;
		for(DtEdicion ins : ediciones) {
			ret[i]=ins;
			i++;
	    }
        return ret;
	}
	
	@WebMethod
	public DtPrograma[] infoProgramas() {
		List<DtPrograma> programas;
		DtPrograma[] ret = new DtPrograma[10];
		try {
			programas = icon.infoProgramas();
			ret = new DtPrograma[programas.size()];
			int i = 0;
	        for(DtPrograma ins : programas) {
	            ret[i]=ins;
	            i++;
	        }
		} catch(ParseException e) {
			this.mensaje = e.getMessage();
		}
        return ret;
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
