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

import publicadores.DtCursoBase;
import publicadores.DtEdicion;
import publicadores.DtEdicionBase;
import publicadores.CategoriaInexistente;
import publicadores.CursoNoExiste;
import publicadores.InstitutoInexistente;
import publicadores.ControladorAltaEdicionCursoPublish;
import publicadores.ControladorAltaEdicionCursoPublishService;
import publicadores.ControladorAltaEdicionCursoPublishServiceLocator;
import publicadores.ControladorConsultaEdicionCursoPublish;
import publicadores.ControladorConsultaEdicionCursoPublishService;
import publicadores.ControladorConsultaEdicionCursoPublishServiceLocator;
import publicadores.DtUsuarioBase;

@WebServlet("/ConsultaEdicion")
public class ConsultaEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error;

    public ConsultaEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		switch(sesion.getAttribute("optConsultaEdicionInfoEdicion").toString()) {
		case "0":	//ingresar instituto, traer cursos y setear el opt en 1
					boolean esInstituto = request.getParameter("esInstitutoInfoEdicion") != null;
					boolean esCategoria = request.getParameter("esCategoriaInfoEdicion") != null;
					String InsCat = request.getParameter("InsCatEd");
					ArrayList<String> cursosInfoEdicion = new ArrayList<String>();
					if(!esInstituto && esCategoria) {
						try {
							for(DtCursoBase dtcb: seleccionarCategoria(InsCat)) {
								cursosInfoEdicion.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursosInfoEdicion", cursosInfoEdicion);
						} catch (RemoteException | ServiceException e) {
							request.setAttribute("mensaje", error);
							rd = request.getRequestDispatcher("/error.jsp");
							rd.forward(request, response);
						}
					} else {//por default busco por instituto
						try {
							for(DtCursoBase dtcb: seleccionarInstituto(InsCat)) {
								cursosInfoEdicion.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursosInfoEdicion", cursosInfoEdicion);
						} catch (RemoteException | ServiceException e) {
							request.setAttribute("mensaje", error);
							rd = request.getRequestDispatcher("/error.jsp");
							rd.forward(request, response);
						}
					}
					sesion.setAttribute("InsCatEd", InsCat);
					sesion.setAttribute("esCategoriaEd", esCategoria);
					sesion.setAttribute("esInstitutoEd", esInstituto);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "1");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		case "1":	//ingresar curso, traer ediciones y setear el opt en 2
					String curso = request.getParameter("cursoInfoEdicion");
					ArrayList<String> edicionesInfoEdicion = new ArrayList<String>();
					try {
						for(DtEdicionBase dteb: seleccionarCurso(curso)) {
							edicionesInfoEdicion.add(dteb.getNombre());
						}
						sesion.setAttribute("edicionesInfoEdicion", edicionesInfoEdicion);
					} catch (RemoteException | ServiceException e) {
						request.setAttribute("mensaje", error);
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					sesion.setAttribute("cursoConsultaEdicion", curso);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "2");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		case "2":	//ingresar edicion, traer informacion y setear el opt en 3
					String edicion = request.getParameter("edicion");
					boolean esInstituto2 = request.getParameter("esInstitutoInfoEdicion") != null;
					boolean esCategoria2 = request.getParameter("esCategoriaInfoEdicion") != null;
					try {
						if(esInstituto2 && !esCategoria2) {
							@SuppressWarnings("unused")
							ArrayList<DtCursoBase> noLosUso = seleccionarInstituto((String) sesion.getAttribute("InsCatEd"));
						} else if(!esInstituto2 && esCategoria2) {
							@SuppressWarnings("unused")
							ArrayList<DtCursoBase> noLosUso = seleccionarCategoria((String) sesion.getAttribute("InsCatEd"));
						}
					} catch (RemoteException | ServiceException e) {
						request.setAttribute("mensaje", error);
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}	
					try {
						@SuppressWarnings("unused")
						ArrayList<DtEdicionBase> tampocoLasUso = seleccionarCurso((String) sesion.getAttribute("cursoConsultaEdicion"));
					} catch (RemoteException | ServiceException a) {
						request.setAttribute("mensaje", error);
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					DtEdicion infoEdicion = null;
					try {
						infoEdicion = seleccionarEdicion(edicion);
					} catch (RemoteException | ServiceException e1) {
						request.setAttribute("mensaje", "La edicion es incorrecta");
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					sesion.setAttribute("infoEdicion", infoEdicion);
					sesion.setAttribute("edicionConsultaEdicion",edicion);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "3");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		
		case "5":	String edicion3 = request.getParameter("edicion");
					DtEdicion infoEdicion3 = null;
					try {
						infoEdicion3 = seleccionarEdicion(edicion3);
					} catch (RemoteException | ServiceException e) {
						request.setAttribute("mensaje", "La edicion es incorrecta");
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					sesion.setAttribute("infoEdicion", infoEdicion3);
					sesion.setAttribute("edicionConsultaEdicion",edicion3);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "3");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		}
	}
	
	public ArrayList<DtCursoBase> seleccionarCategoria(String categoria) throws CategoriaInexistente, ServiceException, publicadores.CategoriaInexistente, RemoteException {
		ControladorConsultaEdicionCursoPublishService cps = new ControladorConsultaEdicionCursoPublishServiceLocator();
		ControladorConsultaEdicionCursoPublish port = cps.getControladorConsultaEdicionCursoPublishPort();
		DtCursoBase[] cursos = port.seleccionarCategoria(categoria);
		ArrayList<DtCursoBase> retorno = new ArrayList<DtCursoBase>();
		for(int i = 0; i < cursos.length; ++i) {
			retorno.add(cursos[i]);
		}
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		System.out.println("El mensaje es: " + port.getMensaje());
		return retorno;
	}
	
	public ArrayList<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente, ServiceException, InstitutoInexistente, RemoteException {
		ControladorConsultaEdicionCursoPublishService cps = new ControladorConsultaEdicionCursoPublishServiceLocator();
		ControladorConsultaEdicionCursoPublish port = cps.getControladorConsultaEdicionCursoPublishPort();
		DtCursoBase[] cursos = port.seleccionarInstituto(instituto);
		ArrayList<DtCursoBase> retorno = new ArrayList<DtCursoBase>();
		System.out.println(retorno.size());
		for(int i = 0; i < cursos.length; ++i) {
			retorno.add(cursos[i]);
		}
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		System.out.println("El mensaje es: " + port.getMensaje());
		return retorno;
	}
	
	public ArrayList<DtEdicionBase> seleccionarCurso(String curso) throws CursoNoExiste, RemoteException, ServiceException {
		ControladorConsultaEdicionCursoPublishService cps = new ControladorConsultaEdicionCursoPublishServiceLocator();
		ControladorConsultaEdicionCursoPublish port = cps.getControladorConsultaEdicionCursoPublishPort();
		DtEdicionBase[] cursos = port.seleccionarCurso(curso);
		ArrayList<DtEdicionBase> retorno = new ArrayList<DtEdicionBase>();
		for(int i = 0; i < cursos.length; ++i) {
			retorno.add(cursos[i]);
		}
		if (!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		System.out.println("El mensaje es: " + port.getMensaje());
		return retorno;
	}
	
	public DtEdicion seleccionarEdicion(String edicion) throws RemoteException, ServiceException {
		ControladorConsultaEdicionCursoPublishService cps = new ControladorConsultaEdicionCursoPublishServiceLocator();
		ControladorConsultaEdicionCursoPublish port = cps.getControladorConsultaEdicionCursoPublishPort();
		return port.seleccionarEdicion(edicion);
	}

}