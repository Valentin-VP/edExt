package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.DtCursoBase;
import publicadores.DtEdicionCompleta;
import publicadores.DtInscripcionEd;
//import interfaces.Fabrica;
//import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;
import publicadores.ControladorSeleccionarEstudiantesPublish;
import publicadores.ControladorSeleccionarEstudiantesPublishService;
import publicadores.ControladorSeleccionarEstudiantesPublishServiceLocator;

@WebServlet("/SeleccionarEstudiantesEdicion")
public class SeleccionarEstudiantesEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error;
	
    public SeleccionarEstudiantesEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fabrica fabrica = Fabrica.getInstancia();
		//IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso icon = fabrica.getIControladorSeleccionarEstudiantesParaUnaEdicionDeCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		String curso = request.getParameter("cursoSeleccionarEstudiantes");
		@SuppressWarnings("unused")
		String edicion = (String) request.getAttribute("edicionCompletaSeleccionarEstudiantes");
		// Comparo si es una request de AJAX o una request normal
		boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

		if (ajax) { // Es una request de AJAX
			

			try {
				setEdicion(sesion.getAttribute("edicionSEEC").toString());
			} catch (RemoteException | ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String nick = request.getParameter("nickestudiante");
			String estadonuevo = request.getParameter("estadoestudiante");
			System.out.print(nick);
			System.out.print(estadonuevo);
			try {
				cambiarEstadoInscripcion(nick, estadonuevo);
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
					for(DtCursoBase dtcb: listarCursosInstituto(instituto)) {
						cursos.add(dtcb.getNombre());
					}
					sesion.setAttribute("cursosSeleccionarEstudiantes", cursos);
					sesion.setAttribute("opSeleccionarEstudiantes", "1");
					response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				} catch (ServiceException | RemoteException e) {
					request.setAttribute("mensaje", error);
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					request.setAttribute("mensaje", "El formulario ha partido.");
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}		
				break;
			case "1":	//selecciona curso, devuelve edicion completa vigente
				curso = request.getParameter("cursoSeleccionarEstudiantes");
				sesion.setAttribute("cursoSeleccionarEstudiantes", curso);
				System.out.println("el curso es"+curso);
				DtEdicionCompleta dtec = new DtEdicionCompleta();
				try {
					dtec = seleccionarCurso(curso,sesion.getAttribute("nick").toString());	
					System.out.println("la edicion es "+dtec.getNombre());
					sesion.setAttribute("edicionCompletaSeleccionarEstudiantes", dtec);
					sesion.setAttribute("opSeleccionarEstudiantes", "2");
					response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				} catch (ServiceException | RemoteException e) {
					request.setAttribute("mensaje", error);
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
				System.out.println("esta ordenado por "+ordenar);
				try {
					//dtec = icon.seleccionarCurso(sesion.getAttribute("cursoSeleccionarEstudiantes").toString(),sesion.getAttribute("nick").toString());
					//System.out.println("ediciones: " + dtec.getInscripciones().size());
					sesion.setAttribute("edicionSEEC", request.getParameter("edicionSelect"));
					seleccionarCurso(sesion.getAttribute("cursoSeleccionarEstudiantes").toString(), sesion.getAttribute("nick").toString());
					setEdicion(request.getParameter("edicionSelect"));
					inscripciones = ordenarInscripciones(ordenar);
					System.out.println("cant estudiantes: " + inscripciones.size());
					//System.out.print("Estudiante 2" + inscripciones.get(1).getEstudiante().getNick());
					//System.out.print("Estudiante 3" + inscripciones.get(2).getEstudiante().getNick());
					
					sesion.setAttribute("inscripcionesEstudiantes", inscripciones);
					sesion.setAttribute("opSeleccionarEstudiantes", "3");
					response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
				} catch (Exception e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}
				break;
			case "3":
				try {
					setEdicion(sesion.getAttribute("edicionSEEC").toString());
				} catch (RemoteException | ServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					try {
						confirmarSeleccion();
					}catch(Exception e) {
						request.setAttribute("mensaje", "Error en persistencia");
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					request.setAttribute("mensaje", "Inscripciones actualizadas correctamente");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
				break;
			}
		} // cierra if para verificar si es request ajax o comun
		
	} // cierra doPost
	
	public ArrayList<DtCursoBase> listarCursosInstituto(String instituto) throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		DtCursoBase[] cursos = port.listarCursosInstituto(instituto);
		ArrayList<DtCursoBase> retorno = new ArrayList<DtCursoBase>();
		for (int i = 0; i < cursos.length; i++) {
		    retorno.add(cursos[i]);
		}
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return retorno;
	}
	
	public DtEdicionCompleta seleccionarCurso(String nomCurso, String nick) throws ServiceException, RemoteException{
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		DtEdicionCompleta dtec = new DtEdicionCompleta();
		dtec = port.seleccionarCurso(nomCurso, nick);
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return dtec;
	}
	
	public List<DtInscripcionEd> ordenarInscripciones(String ordenarpor) throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		DtInscripcionEd[] inscripciones = port.ordenarInscripciones(ordenarpor);
		List<DtInscripcionEd> retorno = new ArrayList<DtInscripcionEd>();
		for (int i = 0; i < inscripciones.length; i++) {
		    retorno.add(inscripciones[i]);
		}
		return retorno;
	}
	
	public void cambiarEstadoInscripcion(String nick, String estado) throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		port.cambiarEstadoInscripcion(nick, estado);
	}
	
	public void setEdicion(String edicion) throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		port.setEdicion(edicion);
	}
	
	public void confirmarSeleccion() throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		port.confirmarSeleccion();
	}

	public void limpiar() throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		port.limpiar();
	}
	
}
