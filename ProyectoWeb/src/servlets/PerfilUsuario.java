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
import publicadores.DtUsuario;

@WebServlet("/PerfilUsuario")
public class PerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error;

    public PerfilUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		//Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		//IControladorConsultaUsuario icon = fabrica.getIControladorConsultaUsuario();
		String nick = request.getParameter("nickConsultaUsuario");
		DtUsuario user;
		try {
			user = ElegirUsuario(nick, "caca");
			sesion.setAttribute("DtUser", user);
			rd = request.getRequestDispatcher("PerfilUsuario.jsp");
			rd.forward(request, response);
		} catch (RemoteException | ServiceException e) {
			request.setAttribute("mensaje", error);
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} 
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		HttpSession sesion = request.getSession(true);
		//Fabrica fabrica = Fabrica.getInstancia();
		//IControladorSeguirUsuario icon = fabrica.getIControladorSeguirUsuario();
		//icon.SeguirUsuario(sesion.getAttribute("seguido").toString(), sesion.getAttribute("nick").toString());
		RequestDispatcher rd;
		request.setAttribute("mensaje","Usuario seguido con exito");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
	
	public DtUsuario ElegirUsuario(String nick, String correo) throws ServiceException, RemoteException{
		ControladorConsultaUsuarioPublishService cps = new ControladorConsultaUsuarioPublishServiceLocator();
		ControladorConsultaUsuarioPublish port = cps.getControladorConsultaUsuarioPublishPort();
		DtUsuario usuario = port.elegirUsuario(nick, correo);
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return usuario;
	}

}
