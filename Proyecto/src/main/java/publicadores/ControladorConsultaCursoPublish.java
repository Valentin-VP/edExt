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
import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtInstituto;
import datatypes.DtProgramaBase;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.SinCursos;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorConsultaCursoPublish {
	private Fabrica fabrica;
	private IControladorConsultaCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;

	public ControladorConsultaCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaCurso");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public DtCursoBase[] listarCursosInstituto(String instituto) throws InstitutoInexistente, InstitutoSinCursos {
		ArrayList<DtCursoBase> dtcb = icon.listarCursosInstituto(instituto);
		int i = 0;
		DtCursoBase[] ret = new DtCursoBase[dtcb.size()];
		for(DtCursoBase cb : dtcb) {
			ret[i] = cb;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public DtCursoBase[] listarCursosCategoria(String categoria) throws CategoriaInexistente, CategoriaSinCursos {
		ArrayList<DtCursoBase> dtcb = icon.listarCursosCategoria(categoria);
		int i = 0;
		DtCursoBase[] ret = new DtCursoBase[dtcb.size()];
		for(DtCursoBase cb : dtcb) {
			ret[i] = cb;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public DtCurso consultarCurso(String curso) {
		return icon.consultarCurso(curso);
	}
	
	@WebMethod
	public DtInstituto[] listarInstitutos() throws SinInstitutos {
		ArrayList<DtInstituto> dtIns= icon.listarInstitutos();
		int i = 0;
		DtInstituto[] ret = new DtInstituto[dtIns.size()];
		for(DtInstituto ins : dtIns) {
			ret[i] = ins;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarCategorias() throws SinCategorias {
		ArrayList<String> dtCat= icon.listarCategorias();
		int i = 0;
		String[] ret = new String[dtCat.size()];
		for(String cat : dtCat) {
			ret[i] = cat;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public DtProgramaBase[] getProgramas() {
		ArrayList<DtProgramaBase> dtpb = icon.getProgramas();
		int i = 0;
		DtProgramaBase[] ret = new DtProgramaBase[dtpb.size()];
		for(DtProgramaBase pb : dtpb) {
			ret[i] = pb;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public DtCurso[] listarCursosPlataforma() throws SinCursos {
		ArrayList<DtCurso> dtc = icon.listarCursosPlataforma();
		int i = 0;
		DtCurso[] ret = new DtCurso[dtc.size()];
		for(DtCurso c : dtc) {
			ret[i] = c;
			i++;
		}
		return ret;
	}
}