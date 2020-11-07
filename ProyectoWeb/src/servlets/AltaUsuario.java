package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import com.google.gson.Gson;

import publicadores.DtFecha;
import publicadores.DtInstituto;
import excepciones.SinInstitutos;
import excepciones.UsuarioRepetido;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import publicadores.ControladorAltaUsuarioPublish;
import publicadores.ControladorAltaUsuarioPublishService;
import publicadores.ControladorAltaUsuarioPublishServiceLocator;

@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AltaUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaUsuario icon = fabrica.getIControladorAltaUsuario();*/
		List<DtInstituto> institutos = new ArrayList<DtInstituto>();
		try {
			institutos = /*icon.*/listarInstitutos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Returning List<Entity> as JSON
		/*
		List<DtInstituto> products = institutos;
		    String json = new Gson().toJson(products);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);		
		   */
		
		//Returning List<String> as JSON
		List<String> list = new ArrayList<>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		String json = new Gson().toJson(list);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String nick = request.getParameter("nick");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String pass = request.getParameter("pass");
		String verificacion = request.getParameter("verificar");
		String instituto = (String) request.getParameter("instituto");
		boolean esDocente = request.getParameter("esDocente") != null;
		System.out.print(esDocente);
		Integer dia = Integer.parseInt(request.getParameter("DiaNac"));
		Integer mes = Integer.parseInt(request.getParameter("MesNac"));
		Integer anio = Integer.parseInt(request.getParameter("AnioNac"));
		DtFecha fechaNac = new DtFecha(dia, mes, anio);
		List<String> institutos = new ArrayList<String>();
		RequestDispatcher rd;
		if(pass.equals(verificacion)) {
			try {
				if (esDocente) {
					for(DtInstituto dti: listarInstitutos()) {
						institutos.add(dti.getNombre());
					}	
				}
				request.setAttribute("institutos", institutos);
				
				seleccionarInstituto(instituto);
				System.out.println("Fue seteado el instituto: " + instituto);
				altaUsuario(nick, correo, nombre, apellido, fechaNac, pass);
				try {
					confirmarAltaUsuario(esDocente);
				} catch (NoSuchAlgorithmException e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				}
			} catch(Exception e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}
		String tipo;
		if(esDocente) {
			tipo="Docente";
		} else tipo="Estudiante";
		request.setAttribute("mensaje", "El usuario de tipo " + tipo + " se ha ingresado correctamente");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
	
	public ArrayList<DtInstituto> listarInstitutos() throws Exception {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		publicadores.DtInstituto[] ins = port.listarInstitutos();
		ArrayList<DtInstituto> retorno = new ArrayList<DtInstituto>();
		for (int i = 0; i < ins.length; ++i) {
		    retorno.add(ins[i]);
		}
		return retorno;
	}
	
	public void seleccionarInstituto(String instituto) throws Exception {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		port.seleccionarInstituto(instituto);
	}
	
	public void altaUsuario(String nick, String correo, String nombre, String apellido, DtFecha fechaNac, String password) throws UsuarioRepetido, Exception {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		port.altaUsuario(nick, correo, nombre, apellido, fechaNac, password);
	}
	
	public void confirmarAltaUsuario(boolean esDocente) throws Exception {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		port.confirmarAltaUsuario(esDocente);
	}
}
