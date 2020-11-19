package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.DtInstituto;
import publicadores.SinCategorias;
import publicadores.SinInstitutos;
import publicadores.ControladorAltaCursoPublish;
import publicadores.ControladorAltaCursoPublishService;
import publicadores.ControladorAltaCursoPublishServiceLocator;
import publicadores.ControladorConsultaCursoPublish;
import publicadores.ControladorConsultaCursoPublishService;
import publicadores.ControladorConsultaCursoPublishServiceLocator;

/**
 * Servlet implementation class CargarTodo
 */
@WebServlet("/CargarTodo")
public class CargarTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String remoteerror = new String();
	
    public CargarTodo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fabrica fabrica = Fabrica.getInstancia();
		//IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		ArrayList <String> categoriasPlataforma = new ArrayList <String>();
		ArrayList <DtInstituto> dtinstitutosPlataforma = new ArrayList <DtInstituto>();
		ArrayList <String> institutosPlataforma = new ArrayList <String>();
		
		try {
			categoriasPlataforma = listarCategorias();
			sesion.setAttribute("categoriasPlataforma", categoriasPlataforma);
		} catch (SinCategorias | ServiceException e) {
			categoriasPlataforma.add("No se encontraron categorias");
			sesion.setAttribute("categoriasPlataforma", categoriasPlataforma);
		}
		
		try {
			dtinstitutosPlataforma = listarInstitutos();
			for(DtInstituto dtin: dtinstitutosPlataforma) {
				institutosPlataforma.add(dtin.getNombre());
			}
			sesion.setAttribute("institutosPlataforma", institutosPlataforma);
		} catch (SinInstitutos | ServiceException e) {
			institutosPlataforma.add("No se encontraron institutos");
			sesion.setAttribute("institutosPlataforma", institutosPlataforma);
		}
		sesion.setAttribute("welcome", "welcome");
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	public ArrayList<String> listarCategorias() throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		String[] categorias;
		ArrayList<String> retorno = new ArrayList<String>();
		categorias = port.listarCategorias();
		if(!port.getMensaje().equals("vacio")){
			remoteerror = port.getMensaje();
			port.setMensaje("vacio");
			System.out.println("Se obtuvo un error o no hay categorias");
			throw new SinCategorias();
		}
		else {
			for (int i = 0; i < categorias.length; ++i) {
			    retorno.add(categorias[i]);
			}
		}
		/*
		 * if (categorias.length == 0) { remoteerror = port.getMensaje(); throw new
		 * RemoteException(); }
		 */
		return retorno;
	}
	
	public ArrayList<DtInstituto> listarInstitutos() throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		DtInstituto[] institutos;
		ArrayList<DtInstituto> retorno = new ArrayList<DtInstituto>();
		institutos = port.listarInstitutos();
		if(!port.getMensaje().equals("vacio")){
			remoteerror = port.getMensaje();
			port.setMensaje("vacio");
			System.out.println("Se obtuvo un error o no hay institutos");
			throw new SinInstitutos();
		}
		else {
			for (int i = 0; i < institutos.length; ++i) {
			    retorno.add(institutos[i]);
			}
		}
		return retorno;
	}
}
