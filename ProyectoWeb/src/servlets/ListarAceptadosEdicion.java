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

import com.google.gson.Gson;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;

@WebServlet("/ListarAceptadosEdicion")
public class ListarAceptadosEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarAceptadosEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosAUnaEdicionDeCurso icon = fabrica.getIControladorListarAceptadosAUnaEdicionDeCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		//doGet(request, response);
		switch(sesion.getAttribute("opAceptadosEdicion").toString()) {
		case "0":	//selecciona instituto, devuelve cursos
			String instituto = request.getParameter("institutoAceptados");
			ArrayList<String> cursos = new ArrayList<String>();
			
			try {
				for(DtCursoBase dtcb: icon.ingresarInstituto(instituto)) {
					cursos.add(dtcb.getNombre());
				}
				sesion.setAttribute("cursosAceptados", cursos);
				sesion.setAttribute("opAceptadosEdicion", "1");
				response.sendRedirect("ListarAceptadosEdicion.jsp");
			} catch (InstitutoInexistente | InstitutoSinCursos e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			
//			rd = request.getRequestDispatcher("/ListarAceptadosEdicion.jsp");
//			rd.forward(request, response);
			
			break;
			
		case "1":	//selecciona curso, devuelve ediciones
			String curso = request.getParameter("cursoSelectAceptados");
			ArrayList<String> ediciones = new ArrayList<String>();
			//sin comprobacion de instituto
			try {
				for(DtEdicionBase dteb: icon.ingresarCurso(curso)) {
					ediciones.add(dteb.getNombre());
				}
				sesion.setAttribute("edicionesAceptados", ediciones);
				sesion.setAttribute("opAceptadosEdicion", "2");
				response.sendRedirect("ListarAceptadosEdicion.jsp");
			} catch (CursoNoExiste | EdicionNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			
			
			
			break;
			
		case "2":	//selecciona edicion, devuelve sus datos + los 'aceptados'
			String edicion = request.getParameter("edicionSelectAceptados");
			//sin comprobacion de curso
			try {
				DtEdicionCompleta infoEdicion = icon.ingresarEdicion(edicion);
				
				
				sesion.setAttribute("infoFinalAceptados", infoEdicion);
				sesion.setAttribute("opAceptadosEdicion", "3");
				response.sendRedirect("ListarAceptadosEdicion.jsp");
				if (infoEdicion.getInscripciones().isEmpty()) System.out.println("vacio");
			} catch (EdicionNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			break;
		}
	}
}
