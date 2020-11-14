package publicadores;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguration;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.SinInstitutos;
import excepciones.UsuarioRepetido;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAltaUsuarioPublish {
	private Fabrica fabrica;
	private IControladorAltaUsuario icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;
	private String mensaje = "vacio";

	public ControladorAltaUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS M�TODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void AltaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, String password) throws UsuarioRepetido {
		try {
			icon.altaUsuario(nick, correo, nombre, apellido, fechaNac, password);
		} catch(UsuarioRepetido e) {
			this.mensaje = e.getMessage();
		}
	}
	
	@WebMethod
	public void seleccionarInstituto(String instituto) {
		icon.seleccionarInstituto(instituto);
	}
	
	@WebMethod
	public String codificarPass(String contrasenia) throws NoSuchAlgorithmException {
		return icon.codificarPass(contrasenia);
	}
	
	@WebMethod
	public void confirmarAltaUsuario(boolean esDocente) throws NoSuchAlgorithmException {
		icon.confirmarAltaUsuario(esDocente);
	}
	
	@WebMethod
	public DtInstituto[] listarInstitutos() throws SinInstitutos {
		DtInstituto[] retorno = new DtInstituto[0];
		try {
			ArrayList<DtInstituto> dtinstitutos = icon.listarInstitutos();
			int i = 0;
			retorno = new DtInstituto[dtinstitutos.size()];
			for(DtInstituto ins: dtinstitutos) {
				retorno[i] = ins;
				i++;
			}
		} catch(SinInstitutos e) {
			this.mensaje = e.getMessage();
		}
		return retorno;
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