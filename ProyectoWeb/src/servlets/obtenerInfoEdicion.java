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

import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import excepciones.CategoriaInexistente;
import excepciones.CursoNoExiste;
import excepciones.InstitutoInexistente;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;

@WebServlet("/obtenerInfoEdicion")
public class obtenerInfoEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public obtenerInfoEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String edicion = request.getParameter("edicion");
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso icon = fabrica.getIControladorConsultaEdicionCurso();
		try {
			if((boolean)sesion.getAttribute("esInstituto") && !(boolean)sesion.getAttribute("esCategoria")) {
				@SuppressWarnings("unused")
				ArrayList<DtCursoBase> noLosUso = icon.seleccionarInstituto((String) sesion.getAttribute("InsCat"));
			} else if(!(boolean)sesion.getAttribute("esInstituto") && (boolean)sesion.getAttribute("esCategoria")) {
				@SuppressWarnings("unused")
				ArrayList<DtCursoBase> noLosUso = icon.seleccionarCategoria((String) sesion.getAttribute("InsCat"));
			}
		} catch (InstitutoInexistente | CategoriaInexistente e) {
			throw new ServletException(e.getMessage());
		}	
		try {
			@SuppressWarnings("unused")
			ArrayList<DtEdicionBase> tampocoLasUso = icon.seleccionarCurso((String) sesion.getAttribute("cursoConsultaEdicion"));
		} catch (CursoNoExiste a) {
			throw new ServletException(a.getMessage());
		}
		DtEdicion infoEdicion = icon.seleccionarEdicion(edicion);
		sesion.setAttribute("infoEdicion", infoEdicion);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/infoEdicion.jsp");
		rd.forward(request, response);
	}
}
