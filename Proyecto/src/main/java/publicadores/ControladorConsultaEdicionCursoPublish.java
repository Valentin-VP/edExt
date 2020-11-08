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
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtUsuarioBase;
import excepciones.CategoriaInexistente;
import excepciones.CursoNoExiste;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorConsultaEdicionCursoPublish {
	private Fabrica fabrica;
	private IControladorConsultaEdicionCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;

	public ControladorConsultaEdicionCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaEdicionCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaEdicionCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaEdicionCurso");
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
	public DtCursoBase[] seleccionarCategoria(String categoria) throws CategoriaInexistente {
		List<DtCursoBase> cursos = icon.seleccionarCategoria(categoria);
		DtCursoBase[] retorno = new DtCursoBase[cursos.size()];
		int i = 0;
		for(DtCursoBase dtcb: cursos) {
			retorno[i] = dtcb;
			i++;
		}
		return retorno;
	}
	
	@WebMethod
	public DtEdicionBase[] seleccionarCurso(String curso) throws CursoNoExiste {
		List<DtEdicionBase> ediciones = icon.seleccionarCurso(curso);
		DtEdicionBase[] retorno = new DtEdicionBase[ediciones.size()];
		int i = 0;
		for(DtEdicionBase dteb: ediciones) {
			retorno[i] = dteb;
			i++;
		}
		return retorno;
	}
	
	@WebMethod
	public DtEdicion seleccionarEdicion(String edicion) {
		return icon.seleccionarEdicion(edicion);
	}
	
	@WebMethod
	public DtEdicion getDtEdicion(String edicion) {
		return icon.getDtEdicion(edicion);
	}
	
	@WebMethod
	public String[] getDocentes(String edicion) {
		ArrayList<String> profes = icon.getDocentes(edicion);
		String[] retorno = new String[profes.size()];
		int i = 0;
		for(String dtub: profes) {
			retorno[i] = dtub;
			i++;
		}
		return retorno;
	}
	
	@WebMethod
	public DtInstituto[] getInstitutosConCurso(String curso) {
		ArrayList<DtInstituto> profes = icon.getInstitutosConCurso(curso);
		DtInstituto[] retorno = new DtInstituto[profes.size()];
		int i = 0;
		for(DtInstituto dti: profes) {
			retorno[i] = dti;
			i++;
		}
		return retorno;
	}
	
	@WebMethod
	public String getNombreCurso(String CursoInstituto) {
		return icon.getNombreCurso(CursoInstituto);
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
