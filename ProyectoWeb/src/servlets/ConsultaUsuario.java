package servlets;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.ControladorConsultaUsuarioPublish;
import publicadores.ControladorConsultaUsuarioPublishService;
import publicadores.ControladorConsultaUsuarioPublishServiceLocator;
//import interfaces.Fabrica;
//import interfaces.IControladorConsultaUsuario;

import java.util.ArrayList;
import publicadores.DtUsuario;

@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error;
	
    public ConsultaUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		//Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		ArrayList<DtUsuario> usuarios = new ArrayList<DtUsuario>();
		//IControladorConsultaUsuario icon = fabrica.getIControladorConsultaUsuario();
		switch(sesion.getAttribute("optConsultaUsuario").toString()) {
		case "0": try {
				usuarios =  listarDtUsuarios();
				sesion.setAttribute("usuariosConsultaUsuario", usuarios);
				sesion.setAttribute("optConsultaUsuario", 1);
				rd = request.getRequestDispatcher("ConsultaUsuario.jsp");
				rd.forward(request, response);
			} catch (RemoteException | ServiceException e) {
				request.setAttribute("mensaje", error);
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		break;
		}
	}
	
	public ArrayList<DtUsuario> listarDtUsuarios() throws ServiceException, RemoteException{
		ControladorConsultaUsuarioPublishService cps = new ControladorConsultaUsuarioPublishServiceLocator();
		ControladorConsultaUsuarioPublish port = cps.getControladorConsultaUsuarioPublishPort();
		DtUsuario[] cursos = port.listarDtUsuarios();
		ArrayList<DtUsuario> retorno = new ArrayList<DtUsuario>();
		for (int i = 0; i < cursos.length; i++) {
		    retorno.add(cursos[i]);
		}
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return retorno;
	}

}
