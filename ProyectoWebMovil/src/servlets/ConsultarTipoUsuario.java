package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import publicadores.ControladorSesionPublish;
import publicadores.ControladorSesionPublishService;
import publicadores.ControladorSesionPublishServiceLocator;

@WebServlet("/ConsultarTipoUsuario")
public class ConsultarTipoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error;

    public ConsultarTipoUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String nick = request.getParameter("nick-correo");
		String pass = request.getParameter("pass");
		String codificada = "";
		RequestDispatcher rd;
		try {
			codificada = codificarPass(pass);
		} catch (RemoteException | ServiceException | NoSuchAlgorithmException e) {
			request.setAttribute("mensaje", error);
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		String tipo = "";
		String nickname = "visitante";
		try {
			if(existeUsuario(nick)) {
				tipo = identificarUsuario(nick, codificada);
				if(tipo != null) {
					nickname = obtenerNick();
					String correo = obtenerCorreo();
					sesion.setAttribute("tipo", tipo);
					sesion.setAttribute("nick", nickname);
					sesion.setAttribute("correo", correo);
				}
			} else {
				System.out.println("entro al else de existe usuario");
				request.setAttribute("mensaje", "El usuario no esta registrado");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		} catch(RemoteException | ServiceException e) {
			request.setAttribute("mensaje", error);
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		//request.setAttribute("tipo", tipo);
		//request.setAttribute("nick", nickname);
		if(tipo.equals("estudiante")) {
			sesion.setAttribute("inicio","iniciado");
			rd = request.getRequestDispatcher("/CargarTodo");
			rd.forward(request, response);
		}else if(tipo.equals("docente")){
			request.setAttribute("mensaje", "Login exclusivo para estudiantes");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("mensaje", "Contraseña incorrecta");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
	
	public String codificarPass(String pass) throws ServiceException, NoSuchAlgorithmException, RemoteException {
		ControladorSesionPublishService cps = new ControladorSesionPublishServiceLocator();
		ControladorSesionPublish port = cps.getControladorSesionPublishPort();
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return port.codificarPass(pass);
	}
	
	public boolean existeUsuario(String nick) throws RemoteException, ServiceException {
		ControladorSesionPublishService cps = new ControladorSesionPublishServiceLocator();
		ControladorSesionPublish port = cps.getControladorSesionPublishPort();
		boolean retorno = port.existeUsuario(nick);
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return retorno;
	}
	
	public String identificarUsuario(String id, String hashpass) throws RemoteException, ServiceException {
		ControladorSesionPublishService cps = new ControladorSesionPublishServiceLocator();
		ControladorSesionPublish port = cps.getControladorSesionPublishPort();
		String retorno = port.identificarUsuario(id, hashpass);
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return retorno;
	}
	
	public String obtenerNick() throws ServiceException, RemoteException {
		ControladorSesionPublishService cps = new ControladorSesionPublishServiceLocator();
		ControladorSesionPublish port = cps.getControladorSesionPublishPort();
		String retorno = port.obtenerNick();
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return retorno;
	}
	
	public String obtenerCorreo() throws RemoteException, ServiceException {
		ControladorSesionPublishService cps = new ControladorSesionPublishServiceLocator();
		ControladorSesionPublish port = cps.getControladorSesionPublishPort();
		String retorno = port.obtenerCorreo();
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return retorno;
	}
	
}
