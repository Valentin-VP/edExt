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
import interfaces.Fabrica;
import interfaces.IControladorSesion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorSesionPublish {
	private Fabrica fabrica;
	private IControladorSesion icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;
	private String mensaje = "vacio";

	public ControladorSesionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSesion();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSesion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSesion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS M�TODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public boolean existeUsuario(String id) {
		return icon.existeUsuario(id);
	}
	
	@WebMethod
	public String identificarUsuario(String id, String hashpass) {
		return icon.identificarUsuario(id, hashpass);
	}
	
	@WebMethod
	public String obtenerNick() {
		return icon.obtenerNick();
	}
	
	@WebMethod
	public String obtenerCorreo() {
		return icon.obtenerCorreo();
	}
	
	@WebMethod
	public String codificarPass(String contrasenia) throws NoSuchAlgorithmException {
		return icon.codificarPass(contrasenia);
	}
	
	@WebMethod
	public String getMensaje() {
		return this.mensaje;
	}
	
	@WebMethod
	public void setMensaje(String m) {
		this.mensaje = m;
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