package publicadores;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguration;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAltaCursoPublish {
	private Fabrica fabrica;
	private IControladorAltaCurso icon;
	private WebServiceConfiguration configuracion;
	private Endpoint endpoint;
	private String mensaje;
	
	public ControladorAltaCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaCurso();
		try {
			configuracion = new WebServiceConfiguration();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaCurso");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	// Public Methods
	
	@WebMethod
	public void altaCurso (String instituto,String nombre,String descripcion,String duracion,int cantHoras,int creditos,String url,DtFecha fechaR) throws CursoRepetido, InstitutoInexistente{
		try {
			icon.altaCurso(instituto, nombre, descripcion, duracion, cantHoras, creditos, url, fechaR);
		}
		catch(CursoRepetido | InstitutoInexistente ex){
			this.mensaje = ex.getMessage();
		}
	}
	
	@WebMethod
	public void confirmarAltaCurso() {
		icon.confirmarAltaCurso();
	}
	
	@WebMethod
	public void cancelarAltaCurso() {
		icon.cancelarAltaCurso();
	}
	
	@WebMethod
	public void agregarPrevia(String previa) {
		icon.agregarPrevia(previa);
	}
	
	@WebMethod
	public String[] listarCategorias() throws SinCategorias{
		String [] retorno = null;
		try {
			ArrayList<String> categorias = icon.listarCategorias();
			int i = 0;
			retorno = new String [categorias.size()];
			for (String cat: categorias) {
				retorno[i] = cat;
				i++;
			}
		}catch(SinCategorias ex) {
			this.mensaje = ex.getMessage();
		}
		return retorno;
	}
	
	@WebMethod
	public void agregarCategoria(String categoria) {
		icon.agregarCategoria(categoria);
	}
	
	@WebMethod
	public void cleanCategorias() {
		icon.cleanCategorias();
	}
	
	@WebMethod
	public DtInstituto[] listarInstitutos() throws SinInstitutos{
		DtInstituto [] retorno = null;
		try {
			ArrayList<DtInstituto> institutos = icon.listarInstitutos();
			int i = 0;
			retorno = new DtInstituto[institutos.size()];
			for (DtInstituto instituto: institutos) {
				retorno[i] = instituto;
				i++;
			}
		}
		catch(SinInstitutos ex) {
			this.mensaje = ex.getMessage();
		}
		return retorno;
	}
	
	@WebMethod
	public String getMensaje() {
		return this.mensaje;
	}
}
