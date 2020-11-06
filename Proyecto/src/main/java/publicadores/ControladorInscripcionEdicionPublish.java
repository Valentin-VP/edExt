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
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoEstudiante;
import excepciones.UsuarioNoExiste;
import interfaces.Fabrica;
import interfaces.IControladorInscripcionEdicionCurso;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorInscripcionEdicionPublish {
	private Fabrica fabrica;
	private IControladorInscripcionEdicionCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;

	public ControladorInscripcionEdicionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorInscripcionEdicionCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInscripcionEdicion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInscripcionEdicion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public DtInstituto[] listarInstitutos(String id, String hashpass) throws SinInstitutos {
		//return icon.listarInstitutos();
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
	public DtCursoBase[] seleccionarInstituto(String nomIns) throws CursoNoExiste {
		//return icon.seleccionarInstituto(nomIns);
		List<DtCursoBase> cursos = icon.seleccionarInstituto(nomIns);
		int i=0;
		DtCursoBase[] ret = new DtCursoBase[cursos.size()];
		for(DtCursoBase c : cursos) {
            ret[i]=c;
            i++;
        }
		return ret;
	}
	
	@WebMethod
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste {
		return icon.seleccionarCurso(nomCurso);
	}
	
	@WebMethod
	public void registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws UsuarioNoExiste, UsuarioNoEstudiante {
		icon.registrarInscripcionEd(nick, correo, nomCurso, fecha);
	}
	
	@WebMethod
	public void cancelar() {
		icon.cancelar();
	}
	
	@WebMethod
	public void confirmar() throws InscripcionEdRepetido, EdicionVigenteNoExiste, UsuarioNoExiste {
		icon.confirmar();
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