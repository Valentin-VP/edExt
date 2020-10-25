package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import datatypes.DtInscripcionEd;
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
				sesion.setAttribute("cursosSeleccionarEstudiantes", cursos);
				sesion.setAttribute("opSeleccionarEstudiantes", "1");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
			} catch (InstitutoInexistente | InstitutoSinCursos e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}		
			break;
		case "1":	//selecciona curso, devuelve edicion completa vigente
			String curso = request.getParameter("cursoSeleccionarEstudiantes");
			System.out.print(curso);
			DtEdicionCompleta dtec = new DtEdicionCompleta();
			try {
				dtec = icon.seleccionarCurso(curso);
				sesion.setAttribute("edicionCompletaSeleccionarEstudiantes", dtec);
				sesion.setAttribute("opSeleccionarEstudiantes", "2");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
			} catch (EdicionVigenteNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			} /*catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			*/
			break;
		case "2":	//selecciona el orden de los estudiantes
			DtEdicionCompleta edicion = (DtEdicionCompleta) request.getAttribute("edicionCompletaSeleccionarEstudiantes");
			String ordenar = request.getParameter("ordenarEstudiantes");
			//sin comprobacion de curso
			try {
				List<DtInscripcionEd> inscripciones = new ArrayList<DtInscripcionEd>();
				
				if(!ordenar.equals("no ordenar")) {
					inscripciones = icon.ordenarInscripciones(ordenar);
				} else {
					inscripciones = edicion.getInscripciones();
				}
				
				sesion.setAttribute("inscripcionesEstudiantes", inscripciones);
				sesion.setAttribute("opSeleccionarEstudiantes", "3");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				//if (edicion.getInscripciones().isEmpty()) System.out.println("vacio");
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			break;
		case "3":	//actualiza los datos del estudiante
			//DtEdicionCompleta edicion = (DtEdicionCompleta) request.getAttribute("edicionCompletaSeleccionarEstudiantes");
			String nick = request.getParameter("");
			String estadonuevo = request.getParameter("");
			try {
				
				icon.cambiarEstadoInscripcion(nick, estadonuevo);
				
				//sesion.setAttribute("inscripcionesEstudiantes", inscripciones);
				sesion.setAttribute("opSeleccionarEstudiantes", "3");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				//if (edicion.getInscripciones().isEmpty()) System.out.println("vacio");
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			break;
		case "4":	//actualiza los datos del estudiante
			//DtEdicionCompleta edicion = (DtEdicionCompleta) request.getAttribute("edicionCompletaSeleccionarEstudiantes");
			try {
				
				icon.confirmarSeleccion();
				
				icon.limpiar();
				
				//sesion.setAttribute("inscripcionesEstudiantes", inscripciones);
				sesion.setAttribute("opSeleccionarEstudiantes", "5");
				response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				//if (edicion.getInscripciones().isEmpty()) System.out.println("vacio");
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			break;
		}
	}

}
