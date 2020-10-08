package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorSesion;


@WebServlet("/ConsultarTipoUsuario")
public class ConsultarTipoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConsultarTipoUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick-correo");
		String pass = request.getParameter("pass");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSesion icon = fabrica.getIControladorSesion();
		IControladorAltaUsuario icontrolador = fabrica.getIControladorAltaUsuario();
		String codificada = "";
		try {
			codificada = icontrolador.codificarPass(pass);
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException(e.getMessage());
		}
		String tipo = "";
		String nickname = "visitante";
		if(icon.existeUsuario(nick)) {
			tipo = icon.identificarUsuario(nick, codificada);
			if(tipo != null) {
				nickname = icon.obtenerNick();
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("tipo", tipo);
				sesion.setAttribute("nick", nickname);
			}	
		}
		RequestDispatcher rd;
		//request.setAttribute("tipo", tipo);
		//request.setAttribute("nick", nickname);
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
}
