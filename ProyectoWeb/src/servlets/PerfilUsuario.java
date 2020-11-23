/*package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.DtUsuarioBase;



@WebServlet("/PerfilUsuario")
public class PerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PerfilUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		IControladorConsultaUsuario icon = fabrica.getIControladorConsultaUsuario();
		String nick = request.getParameter("nickConsultaUsuario");
		DtUsuario user = icon.ElegirUsuario(nick, "caca");
		sesion.setAttribute("DtUser", user);
		rd = request.getRequestDispatcher("PerfilUsuario.jsp");
		rd.forward(request, response);
	}


	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeguirUsuario icon = fabrica.getIControladorSeguirUsuario();
		//icon.SeguirUsuario(sesion.getAttribute("seguido").toString(), sesion.getAttribute("nick").toString());
		RequestDispatcher rd;
		request.setAttribute("mensaje","Usuario seguido con exito");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}*/
