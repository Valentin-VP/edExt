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
import excepciones.CursoNoExiste;
import excepciones.EdicionNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.Fabrica;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;
import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;

@WebServlet("/SeleccionarEstudiantesEdicion")
public class SeleccionarEstudiantesEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeleccionarEstudiantesEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso icon = fabrica.getIControladorSeleccionarEstudiantesParaUnaEdicionDeCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		//doGet(request, response);
		switch(sesion.getAttribute("opSeleccionarEstudiantes").toString()) {
		case "0":	//selecciona instituto, devuelve cursos
			String instituto = request.getParameter("institutoSeleccionado");
			ArrayList<String> cursos = new ArrayList<String>();
			
			try {
				for(DtCursoBase dtcb: icon.listarCursosInstituto(instituto)) {
					cursos.add(dtcb.getNombre());
				}
				sesion.setAttribute("cursos", cursos);
				sesion.setAttribute("opSeleccionarEstudiantes", "1");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
			} catch (InstitutoInexistente | InstitutoSinCursos e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			}		
			break;
		case "1":	//selecciona curso, devuelve edicion completa vigente
			String curso = request.getParameter("cursoSelect");
			DtEdicionCompleta dtec = new DtEdicionCompleta();
			try {
				dtec = icon.seleccionarCurso(curso);
				sesion.setAttribute("edicionCompleta", dtec);
				sesion.setAttribute("opSeleccionarEstudiantes", "2");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
			} catch (EdicionVigenteNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			}
			break;
			
		case "2":	//selecciona edicion, devuelve sus datos + los 'aceptados'
			/*String edicion = request.getParameter("edicionSelectAceptados");
			//sin comprobacion de curso
			try {
				DtEdicionCompleta infoEdicion = icon.seleccionarCurso(curso);

				sesion.setAttribute("infoFinalAceptados", infoEdicion);
				sesion.setAttribute("opSeleccionarEstudiantes", "3");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				if (infoEdicion.getInscripciones().isEmpty()) System.out.println("vacio");
			} catch (EdicionVigenteNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			}
			break;
			*/
		}
	}

}
