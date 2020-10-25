package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DtInstituto;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;

/**
 * Servlet implementation class CargarTodo
 */
@WebServlet("/CargarTodo")
public class CargarTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CargarTodo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		ArrayList <String> categoriasPlataforma = new ArrayList <String>();
		ArrayList <DtInstituto> dtinstitutosPlataforma = new ArrayList <DtInstituto>();
		ArrayList <String> institutosPlataforma = new ArrayList <String>();
		
		try {
			categoriasPlataforma = icon.listarCategorias();
			sesion.setAttribute("categoriasPlataforma", categoriasPlataforma);
		} catch (SinCategorias e) {
			categoriasPlataforma.add("No se encontraron categorias");
			sesion.setAttribute("categoriasPlataforma", categoriasPlataforma);
		}
		
		try {
			dtinstitutosPlataforma = icon.listarInstitutos();
			for(DtInstituto dtin: dtinstitutosPlataforma) {
				institutosPlataforma.add(dtin.getNombre());
			}
			sesion.setAttribute("institutosPlataforma", institutosPlataforma);
		} catch (SinInstitutos e) {
			institutosPlataforma.add("No se encontraron institutos");
			sesion.setAttribute("institutosPlataforma", institutosPlataforma);
		}
		sesion.setAttribute("welcome", "welcome");
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
