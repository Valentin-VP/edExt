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
import datatypes.DtEdicionCompleta;
import datatypes.DtInscripcionEd;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.Fabrica;
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
		String curso = request.getParameter("cursoSeleccionarEstudiantes");
		String edicion = (String) request.getAttribute("edicionCompletaSeleccionarEstudiantes");
		// Comparo si es una request de AJAX o una request normal
		boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

		if (ajax) { // Es una request de AJAX
			
			try {
				icon.seleccionarCurso(sesion.getAttribute("cursoSeleccionarEstudiantes").toString(),sesion.getAttribute("nick").toString());
			} catch (EdicionVigenteNoExiste e1) {
				request.setAttribute("mensaje", e1.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			String nick = request.getParameter("nickestudiante");
			String estadonuevo = request.getParameter("estadoestudiante");
			System.out.print(nick);
			System.out.print(estadonuevo);
			try {
				icon.cambiarEstadoInscripcion(nick, estadonuevo);
			} catch (Exception e) {
				request.setAttribute("mensaje", "El formulario ha partido.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			response.getWriter().print("Datos actualizados de " + nick);
		}
		else { // Sino es una request normal
		
			switch(sesion.getAttribute("opSeleccionarEstudiantes").toString()) {
			case "0":	//selecciona instituto, devuelve cursos
				String instituto = request.getParameter("institutoSeleccionado");
				ArrayList<String> cursos = new ArrayList<String>();
				System.out.println("el instituto es"+instituto);
				
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
				curso = request.getParameter("cursoSeleccionarEstudiantes");
				sesion.setAttribute("cursoSeleccionarEstudiantes", curso);
				System.out.println("el curso es"+curso);
				DtEdicionCompleta dtec = new DtEdicionCompleta();
				try {
					dtec = icon.seleccionarCurso(curso,sesion.getAttribute("nick").toString());
					System.out.println("la edicion es"+dtec.getNombre());
					sesion.setAttribute("edicionCompletaSeleccionarEstudiantes", dtec);
					sesion.setAttribute("opSeleccionarEstudiantes", "2");
					response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				} catch (EdicionVigenteNoExiste e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					request.setAttribute("mensaje", "El formulario ha partido.");
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				}
				break;
			case "2":	//selecciona el orden de los estudiantes
				String ordenar = request.getParameter("ordenarEstudiantes");
				List<DtInscripcionEd> inscripciones = new ArrayList<DtInscripcionEd>();
				System.out.print("esta ordenado por"+ordenar);
				try {
					dtec = icon.seleccionarCurso(sesion.getAttribute("cursoSeleccionarEstudiantes").toString(),sesion.getAttribute("nick").toString());
					inscripciones = icon.ordenarInscripciones(ordenar);
					
					sesion.setAttribute("inscripcionesEstudiantes", inscripciones);
					sesion.setAttribute("opSeleccionarEstudiantes", "3");
					response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				} catch (Exception e) {
					request.setAttribute("mensaje", "El formulario ha partido.");
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				}
				break;
			case "3":	//confirma los datos de los estudiante
				try {
					
					System.out.print("Llegue");
					dtec = icon.seleccionarCurso(sesion.getAttribute("cursoSeleccionarEstudiantes").toString(),sesion.getAttribute("nick").toString());
					icon.confirmarSeleccion();
					icon.limpiar();
					
					request.setAttribute("mensaje", "Los datos han sido confirmados");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
				}catch (Exception e) {
					request.setAttribute("mensaje", "El formulario ha partido.");
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				}
				break;
			}
		} // cierra if para verificar si es request ajax o comun
		
	} // cierra doPost

}
