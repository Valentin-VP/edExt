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
import publicadores.DtCurso;
import publicadores.DtFecha;
import publicadores.DtUsuarioBase;
import publicadores.InstitutoInexistente;
import publicadores.InstitutoSinCursos;
import publicadores.DtEdicionBase;
import publicadores.ControladorConsultaCursoPublish;
import publicadores.ControladorConsultaCursoPublishService;
import publicadores.ControladorConsultaCursoPublishServiceLocator;

/**
 * Servlet implementation class ConsultarCurso
 */
@WebServlet("/ConsultarCurso")
public class ConsultarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error = new String();
	
    public ConsultarCurso() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		/*Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();*/
		RequestDispatcher rd;
		switch(sesion.getAttribute("optConsultaCursoInfoCurso").toString()) {
		case "0": //carga una variable con los cursos
					boolean esInstituto = request.getParameter("esInstitutoInfoCurso") != null;
					boolean esCategoria = request.getParameter("esCategoriaInfoCurso") != null;
					String insCat = request.getParameter("instituto-categoria");
					ArrayList<String> cursos = new ArrayList<String>();
					if(!esInstituto && esCategoria) {
						try {
							DtCursoBase[] CCat = listarCursosCategoria(insCat);
							System.out.println("paso el listar cursos");
							for(DtCursoBase dtcb: CCat) {
								cursos.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursos", cursos);
						} catch (ServiceException |RemoteException e) {
							request.setAttribute("mensaje", error);
			                rd = request.getRequestDispatcher("/error.jsp");
			                rd.forward(request, response);
						}
					} else {//por default busco por instituto
						
						try {
							System.out.println("antes de listarCursosInstituto");
							DtCursoBase[] CIns = listarCursosInstituto(insCat);
							System.out.println("paso listar cursos");
							for(DtCursoBase dtcb: CIns) {
								cursos.add(dtcb.getNombre());
							}
						} catch (ServiceException |RemoteException e) {
							System.out.println("exception "+ e.getMessage());
							request.setAttribute("mensaje", error);
			                rd = request.getRequestDispatcher("/error.jsp");
			                rd.forward(request, response);
						}
					}
					sesion.setAttribute("cursosConsulta", cursos);
					sesion.setAttribute("instituto-categoria", insCat);
					sesion.setAttribute("esCategoria", esCategoria);
					sesion.setAttribute("esInstituto", esInstituto);
					sesion.setAttribute("optConsultaCursoInfoCurso", "1");
					
					
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					rd.forward(request, response);
					break;	

		case "1":	String nomCurso = request.getParameter("dropdownCursos").toString();
					sesion.setAttribute("cursoConsulta", nomCurso);
					ArrayList<String> infoCurso = new ArrayList<String>();
					DtEdicionBase[] ediciones;
					ArrayList<String> edicionesStr = new ArrayList<String>();
					DtCurso curso = new DtCurso();
					try {
						DtCurso[] CPla = listarCursosPlataforma(); 
						for(int i=0; i<CPla.length; i++) {
							if(CPla[i].getNombre().equals(nomCurso))
								curso = CPla[i];
						}
					} catch (ServiceException| RemoteException e1) {
						request.setAttribute("mensaje", error);
		                rd = request.getRequestDispatcher("/error.jsp");
		                rd.forward(request, response);
					}
					infoCurso.add(nomCurso);
					infoCurso.add(curso.getDescripcion());
					infoCurso.add(curso.getDuracion());
					infoCurso.add(Integer.toString(curso.getCantHoras()));
					infoCurso.add(curso.getCreditos().toString());
					infoCurso.add(curso.getUrl());
					String categorias = "";
					if(curso.getCategorias().length != 0){
						for(String c: curso.getCategorias()){
							categorias = categorias + " " + c;
						}
					}
					infoCurso.add(categorias);
					String previas = "";
					if(curso.getPrevias() != null) {
						if(curso.getPrevias().length != 0){
							for(DtCursoBase p: curso.getPrevias()){
								previas = previas + " " + p.getNombre();
							}
						}
					}	
					if(previas == "") 
						previas = "Sin previas";
					infoCurso.add(previas);
					if(curso.getEdiciones() != null) {
						ediciones = curso.getEdiciones();
						for(DtEdicionBase e: ediciones) {
							edicionesStr.add(e.getNombre());
						}
					}
					sesion.setAttribute("edicionesConsultaCurso", edicionesStr);
					sesion.setAttribute("infoCurso", infoCurso);
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					rd.forward(request, response);
					break;


		}
		
	}
	public DtCursoBase[] listarCursosCategoria(String categoria) throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		DtCursoBase[] ret = port.listarCursosCategoria(categoria);
		if(!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return ret;
	}
	
	public DtCursoBase[] listarCursosInstituto(String instituto) throws RemoteException,  ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		DtCursoBase[] ret =  port.listarCursosInstituto(instituto);
		if(!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		System.out.println("paso el if");
		return ret;
	}
	
	public DtCurso[] listarCursosPlataforma() throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		DtCurso[] ret = port.listarCursosPlataforma();
		if(!port.getMensaje().equals("vacio")) {
			error = port.getMensaje();
			port.setMensaje("vacio");
			throw new RemoteException();
		}
		return ret;
	}

}
