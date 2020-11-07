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
import datatypes.DtFecha;
import datatypes.DtUsuarioBase;
import excepciones.CursoNoExiste;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicionCurso;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAltaEdicionCursoPublish {
	private Fabrica fabrica;
	private IControladorAltaEdicionCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;

	public ControladorAltaEdicionCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaEdicionCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaEdicionCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaEdicionCurso");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS M�TODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public DtCursoBase[] seleccionarInstituto(String instituto) throws InstitutoInexistente {
		List<DtCursoBase> cursos = icon.seleccionarInstituto(instituto);
		DtCursoBase[] retorno = new DtCursoBase[cursos.size()];
		int i = 0;
		for(DtCursoBase dtcb: cursos) {
			retorno[i] = dtcb;
			i++;
		}
		return retorno;
	}
	
	@WebMethod
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cantCupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente {
		icon.altaEdicionCurso(curso, nombre, fechaI, fechaF, docentes, tieneCupos, cantCupos, fechaPub);
	}
	
	@WebMethod
	public DtUsuarioBase[] getUsuarios() {
		ArrayList<DtUsuarioBase> users = icon.getUsuarios();
		DtUsuarioBase[] retorno = new DtUsuarioBase[users.size()];
		int i = 0;
		for(DtUsuarioBase dtub: users) {
			retorno[i] = dtub;
			i++;
		}
		return retorno;
	}
	
	@WebMethod
	public DtUsuarioBase[] getDocentes() {
		ArrayList<DtUsuarioBase> profes = icon.getDocentes();
		DtUsuarioBase[] retorno = new DtUsuarioBase[profes.size()];
		int i = 0;
		for(DtUsuarioBase dtub: profes) {
			retorno[i] = dtub;
			i++;
		}
		return retorno;
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