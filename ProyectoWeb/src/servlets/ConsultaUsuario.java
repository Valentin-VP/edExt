package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.Fabrica;
import interfaces.IControladorConsultaUsuario;
import java.util.List;
import java.util.ArrayList;
import datatypes.DtUsuario;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConsultaUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		ArrayList<DtUsuario> usuarios = new ArrayList<DtUsuario>();
		IControladorConsultaUsuario icon = fabrica.getIControladorConsultaUsuario();
		switch(sesion.getAttribute("optConsultaUsuario").toString()) {
		case "0": usuarios =  icon.listarDtUsuarios();
				  sesion.setAttribute("usuariosConsultaUsuario", usuarios);
				  sesion.setAttribute("optConsultaUsuario", 1);
				  rd = request.getRequestDispatcher("ConsultaUsuario.jsp");
				  rd.forward(request, response);
				  break;

		}
	}

}
