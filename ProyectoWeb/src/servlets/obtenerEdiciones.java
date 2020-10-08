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

import datatypes.DtEdicionBase;
import excepciones.CursoNoExiste;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;

@WebServlet("/obtenerEdiciones")
public class obtenerEdiciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public obtenerEdiciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("curso");
		ArrayList<String> edicionesInfoEdicion = new ArrayList<String>();
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso icon = fabrica.getIControladorConsultaEdicionCurso();
		try {
			for(DtEdicionBase dteb: icon.seleccionarCurso(curso)) {
				edicionesInfoEdicion.add(dteb.getNombre());
			}
			sesion.setAttribute("edicionesInfoEdicion", edicionesInfoEdicion);
		} catch (CursoNoExiste e) {
			throw new ServletException(e.getMessage());
		}
		sesion.setAttribute("cursoConsultaEdicion", curso);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/infoEdicion.jsp");
		rd.forward(request, response);	
	}

}
