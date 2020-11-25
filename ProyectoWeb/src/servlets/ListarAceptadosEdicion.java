package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.InstitutoInexistente;
import publicadores.InstitutoSinCursos;
//import interfaces.Fabrica;
//import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;

import publicadores.ControladorListarAceptadosAEdicionPublish;
import publicadores.ControladorListarAceptadosAEdicionPublishService;
import publicadores.ControladorListarAceptadosAEdicionPublishServiceLocator;

@WebServlet("/ListarAceptadosEdicion")
public class ListarAceptadosEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error;

    public ListarAceptadosEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fabrica fabrica = Fabrica.getInstancia();
		//IControladorListarAceptadosAUnaEdicionDeCurso icon = fabrica.getIControladorListarAceptadosAUnaEdicionDeCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		//doGet(request, response);
		switch(sesion.getAttribute("opAceptadosEdicion").toString()) {
		case "0":	//selecciona instituto, devuelve cursos
			String instituto = request.getParameter("institutoAceptados");
			ArrayList<String> cursos = new ArrayList<String>();
			
			try {
				for(publicadores.DtCursoBase dtcb: ingresarInstituto(instituto)) {
					cursos.add(dtcb.getNombre());
				}
				sesion.setAttribute("cursosAceptados", cursos);
				sesion.setAttribute("opAceptadosEdicion", "1");
				response.sendRedirect("ListarAceptadosEdicion.jsp");
			} catch (RemoteException | ServiceException e) {
				request.setAttribute("mensaje", error);
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
			if(curso==null) {
				request.setAttribute("mensaje", "No se ha ingresado el curso.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			try {
				for(publicadores.DtEdicionBase dteb: ingresarCurso(curso)) {
					ediciones.add(dteb.getNombre());
				}
				sesion.setAttribute("edicionesAceptados", ediciones);
				sesion.setAttribute("opAceptadosEdicion", "2");
				response.sendRedirect("ListarAceptadosEdicion.jsp");
			} catch (RemoteException | ServiceException e) {
				request.setAttribute("mensaje", error);
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);

			}
			
			
			
			break;
			
		case "2":	//selecciona edicion, devuelve sus datos + los 'aceptados'
			String edicion = request.getParameter("edicionSelectAceptados");
			//sin comprobacion de curso
			if(edicion==null) {
				request.setAttribute("mensaje", "No se ha ingresado la edicion.");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			try {
				publicadores.DtEdicionCompleta infoEdicion = ingresarEdicion(edicion);
				//if (infoEdicion.getInscripciones().length==0) System.out.println("vacio");
				//System.out.println(infoEdicion.getInscripciones().length);
				sesion.setAttribute("infoFinalAceptados", infoEdicion);
				sesion.setAttribute("opAceptadosEdicion", "3");
				response.sendRedirect("ListarAceptadosEdicion.jsp");
				
			} catch (RemoteException | ServiceException e) {
				request.setAttribute("mensaje", error);
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);

			}
			break;
		}
	}
	public ArrayList<publicadores.DtInstituto> listarInstitutos() throws  RemoteException, ServiceException {
		ControladorListarAceptadosAEdicionPublishService cps = new ControladorListarAceptadosAEdicionPublishServiceLocator();
		ControladorListarAceptadosAEdicionPublish port = cps.getControladorListarAceptadosAEdicionPublishPort();
		publicadores.DtInstituto[] ins = port.listarInstitutos();
		if (port.getMensaje() != null) {
			error = port.getMensaje();
			throw new RemoteException();
		}
		ArrayList<publicadores.DtInstituto> retorno = new ArrayList<publicadores.DtInstituto>();
		for (int i = 0; i < ins.length; ++i) {
		    retorno.add(ins[i]);
		}
		return retorno;
	}
	
	public ArrayList<publicadores.DtCursoBase> ingresarInstituto(String nomIns) throws InstitutoInexistente, InstitutoSinCursos, RemoteException, ServiceException {
		ControladorListarAceptadosAEdicionPublishService cps = new ControladorListarAceptadosAEdicionPublishServiceLocator();
		ControladorListarAceptadosAEdicionPublish port = cps.getControladorListarAceptadosAEdicionPublishPort();
		publicadores.DtCursoBase[] ins = port.ingresarInstituto(nomIns);
		if (!port.getMensaje().equals("")) {
			System.out.println(port.getMensaje());
			error = port.getMensaje();
			throw new RemoteException();
		}
		ArrayList<publicadores.DtCursoBase> retorno = new ArrayList<publicadores.DtCursoBase>();
		for (int i = 0; i < ins.length; ++i) {
		    retorno.add(ins[i]);
		}
		return retorno;
	}
	public ArrayList<publicadores.DtEdicionBase> ingresarCurso(String nomCur) throws  RemoteException, ServiceException  {
		ControladorListarAceptadosAEdicionPublishService cps = new ControladorListarAceptadosAEdicionPublishServiceLocator();
		ControladorListarAceptadosAEdicionPublish port = cps.getControladorListarAceptadosAEdicionPublishPort();
		publicadores.DtEdicionBase[] ins = port.ingresarCurso(nomCur);
		if (!port.getMensaje().equals("")) {
			error = port.getMensaje();
			throw new RemoteException();
		}
		ArrayList<publicadores.DtEdicionBase> retorno = new ArrayList<publicadores.DtEdicionBase>();
		for (int i = 0; i < ins.length; ++i) {
		    retorno.add(ins[i]);
		}
		return retorno;
	}
	public publicadores.DtEdicionCompleta ingresarEdicion(String edicion) throws  RemoteException, ServiceException  {
		ControladorListarAceptadosAEdicionPublishService cps = new ControladorListarAceptadosAEdicionPublishServiceLocator();
		ControladorListarAceptadosAEdicionPublish port = cps.getControladorListarAceptadosAEdicionPublishPort();
		publicadores.DtEdicionCompleta retorno = port.ingresarEdicion(edicion);
		if (!port.getMensaje().equals("")) {
			error = port.getMensaje();
			throw new RemoteException();
		}
		return retorno;
	}
}
