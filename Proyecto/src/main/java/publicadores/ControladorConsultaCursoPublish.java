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
	private String mensaje = "vacio";

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
		System.out.println("al listarcursoInstituto");
		ArrayList<DtCursoBase> dtcb = new ArrayList<DtCursoBase>();
		DtCursoBase[] ret = new DtCursoBase[0];
		try {
			System.out.println("entro al try");
			dtcb = icon.listarCursosInstituto(instituto);
			int i = 0;
			ret = new DtCursoBase[dtcb.size()];
			for(DtCursoBase cb : dtcb) {
				System.out.println(cb.getNombre());
				ret[i] = cb;
				i++;
			}
		}catch(InstitutoInexistente |InstitutoSinCursos e) {
			System.out.println("entro al catch");
			this.mensaje = e.getMessage();
		}
		return ret;
	}
	
	@WebMethod
	public DtCursoBase[] listarCursosCategoria(String categoria) throws CategoriaInexistente, CategoriaSinCursos {
		ArrayList<DtCursoBase> dtcb = new ArrayList<>();
		DtCursoBase[] ret = new DtCursoBase[0];
		try {
			dtcb = icon.listarCursosCategoria(categoria);
			int i = 0;
			ret = new DtCursoBase[dtcb.size()];
			for(DtCursoBase cb : dtcb) {
				ret[i] = cb;
				i++;
			}
		}catch(CategoriaInexistente |CategoriaSinCursos e) {
			this.mensaje = e.getMessage();
		}
		return ret;
	}
	
	@WebMethod
	public DtCurso consultarCurso(String curso) {
		return icon.consultarCurso(curso);
	}
	
	@WebMethod
	public DtInstituto[] listarInstitutos() throws SinInstitutos {
		ArrayList<DtInstituto> dtcb = new ArrayList<>();
		DtInstituto[] ret = new DtInstituto[0];
		try {
			dtcb = icon.listarInstitutos();
			int i = 0;
			ret = new DtInstituto[dtcb.size()];
			for(DtInstituto cb : dtcb) {
				ret[i] = cb;
				i++;
			}
		}catch(SinInstitutos e) {
			System.out.println(e.getMessage()+" este es el mensaje en el publish");
			this.mensaje = e.getMessage();
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarCategorias() throws SinCategorias {
		ArrayList<String> dtCat = new ArrayList<>();
		String[] ret = new String[0];
		try {
			dtCat = icon.listarCategorias();
			int i = 0;
			ret = new String[dtCat.size()];
			for(String cb : dtCat) {
				ret[i] = cb;
				i++;
			}
		}catch(SinCategorias e) {
			this.mensaje = e.getMessage();
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
		ArrayList<DtCurso> dtcb = new ArrayList<>();
		DtCurso[] ret = new DtCurso[0];
		try {
			dtcb = icon.listarCursosPlataforma();
			int i = 0;
			ret = new DtCurso[dtcb.size()];
			for(DtCurso cb : dtcb) {
				ret[i] = cb;
				i++;
			}
		}catch(SinCursos e) {
			this.mensaje = e.getMessage();
		}
		return ret;
	}
	
	@WebMethod
	public String getMensaje() {
		System.out.println("entro al getMessage " + this.mensaje);
		return this.mensaje;
	}
	
	@WebMethod
	public void setMensaje(String m) {
		this.mensaje = m;
	}
	
}