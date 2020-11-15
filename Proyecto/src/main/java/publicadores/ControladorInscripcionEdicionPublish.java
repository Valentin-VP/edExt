package publicadores;

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
	private String mensaje = "vacio";
	
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

	@WebMethod
	public DtInstituto[] listarInstitutos() throws SinInstitutos {
		//return icon.listarInstitutos();
		List<DtInstituto> institutos;
		DtInstituto[] ret = new DtInstituto[10];
		try {
			institutos = icon.listarInstitutos();
			ret = new DtInstituto[institutos.size()];
			int i = 0;
	        for(DtInstituto ins : institutos) {
	            ret[i]=ins;
	            i++;
	        }
		} catch(SinInstitutos e) {
			this.mensaje = e.getMessage();
		}
        return ret;
	}
	
	@WebMethod
	public DtCursoBase[] seleccionarInstituto(String nomIns) throws CursoNoExiste {
		//return icon.seleccionarInstituto(nomIns);
		List<DtCursoBase> cursos;
		DtCursoBase[] ret = new DtCursoBase[10];
		try {
			cursos = icon.seleccionarInstituto(nomIns);
			int i=0;
			ret = new DtCursoBase[cursos.size()];
			for(DtCursoBase c : cursos) {
	            ret[i]=c;
	            i++;
	        }
		} catch (CursoNoExiste e) {
			this.mensaje = e.getMessage();
		}
		return ret;
	}
	
	@WebMethod
	public DtEdicionBase seleccionarCurso(String nomCurso) throws EdicionVigenteNoExiste {
		DtEdicionBase dteb = new DtEdicionBase();
		try {
			dteb = icon.seleccionarCurso(nomCurso);
		} catch (EdicionVigenteNoExiste e) {
			this.mensaje = e.getMessage();
		}
		return dteb;
	}
	
	@WebMethod
	public void registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws UsuarioNoExiste, UsuarioNoEstudiante {
		try {
			icon.registrarInscripcionEd(nick, correo, nomCurso, fecha);
		} catch (UsuarioNoExiste | UsuarioNoEstudiante e) {
			this.mensaje = e.getMessage();
		}
	}
	
	@WebMethod
	public void cancelar() {
		icon.cancelar();
	}
	
	@WebMethod
	public void confirmar() throws InscripcionEdRepetido, EdicionVigenteNoExiste, UsuarioNoExiste {
		try {
			icon.confirmar();
		} catch (InscripcionEdRepetido | EdicionVigenteNoExiste | UsuarioNoExiste e) {
			this.mensaje = e.getMessage();
		}
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
