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
		switch((String)sesion.getAttribute("opAceptadosEdicion")) {
		case "0":	//carga institutos (inmediatamente)
			ArrayList<String> institutos = new ArrayList<String>();
			try {
				for(DtInstituto dti: icon.listarInstitutos()) {
					institutos.add(dti.getNombre());
				}
				sesion.setAttribute("institutosAceptados", institutos);
			} catch (SinInstitutos e) {
				throw new ServletException(e.getMessage());
			}
			rd = request.getRequestDispatcher("/ListarAceptadosEdicion.jsp");
			rd.forward(request, response);
			sesion.setAttribute("opAceptadosEdicion", "1");
			break;
			
		case "1":	//selecciona instituto, devuelve cursos
			String instituto = request.getParameter("institutoSelectAceptados");
			ArrayList<String> cursos = new ArrayList<String>();
			
			try {
				for(DtCursoBase dtcb: icon.ingresarInstituto(instituto)) {
					cursos.add(dtcb.getNombre());
				}
				sesion.setAttribute("cursosAceptados", cursos);
			} catch (InstitutoInexistente | InstitutoSinCursos e) {
				throw new ServletException(e.getMessage());
			}
			
			rd = request.getRequestDispatcher("/ListarAceptadosEdicion.jsp");
			rd.forward(request, response);
			sesion.setAttribute("opAceptadosEdicion", "2");
			break;
			
		case "2":	//selecciona curso, devuelve ediciones
			String curso = request.getParameter("cursoSelectAceptados");
			ArrayList<String> ediciones = new ArrayList<String>();
			//sin comprobacion de instituto
			try {
				for(DtEdicionBase dteb: icon.ingresarCurso(curso)) {
					ediciones.add(dteb.getNombre());
				}
				sesion.setAttribute("edicionesAceptados", ediciones);
			} catch (CursoNoExiste | EdicionNoExiste e) {
				throw new ServletException(e.getMessage());
			}
			
			rd = request.getRequestDispatcher("/ListarAceptadosEdicion.jsp");
			rd.forward(request, response);
			sesion.setAttribute("opAceptadosEdicion", "3");
			break;
			
		case "3":	//selecciona edicion, devuelve sus datos + los 'aceptados'
			String edicion = request.getParameter("edicionSelectAceptados");
			//sin comprobacion de curso
			try {
				DtEdicionCompleta infoEdicion = icon.ingresarEdicion(edicion);
				sesion.setAttribute("infoFinalAceptados", infoEdicion);
			} catch (EdicionNoExiste e) {

				throw new ServletException(e.getMessage());
			}
			rd = request.getRequestDispatcher("/ListarAceptadosEdicion.jsp");
			rd.forward(request, response);
			sesion.setAttribute("opAceptadosEdicion", "4");
			break;
		}
	}
}
