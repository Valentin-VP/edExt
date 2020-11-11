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

import datatypes.DtCursoBase;
import datatypes.DtCurso;
import datatypes.DtFecha;
import datatypes.DtEdicionBase;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCursos;
import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;
import publicadores.ControladorAltaUsuarioPublish;
import publicadores.ControladorAltaUsuarioPublishService;
import publicadores.ControladorAltaUsuarioPublishServiceLocator;
import publicadores.ControladorConsultaCursoPublish;
import publicadores.ControladorConsultaCursoPublishService;
import publicadores.ControladorConsultaCursoPublishServiceLocator;

/**
 * Servlet implementation class ConsultarCurso
 */
@WebServlet("/ConsultarCurso")
public class ConsultarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ConsultarCurso() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		System.out.println(sesion.getAttribute("optConsultaCursoInfoCurso").toString());
		/*Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();*/
		RequestDispatcher rd;
		switch(sesion.getAttribute("optConsultaCursoInfoCurso").toString()) {
		case "0": //carga una variable con los cursos
					boolean esInstituto = request.getParameter("esInstitutoInfoCurso") != null;
					boolean esCategoria = request.getParameter("esCategoriaInfoCurso") != null;
					String insCat = request.getParameter("instituto-categoria");
					ArrayList<String> cursos = new ArrayList<String>();
					System.out.println(esInstituto);
					System.out.println(esCategoria);
					if(!esInstituto && esCategoria) {
						try {
							publicadores.DtCursoBase[] CCat = listarCursosCategoria(insCat);
							for(publicadores.DtCursoBase dtcb: CCat) {
								cursos.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursos", cursos);
						} catch (ServiceException |RemoteException e) {
							request.setAttribute("mensaje", "Categoria inexistente o sin cursos");
			                rd = request.getRequestDispatcher("/error.jsp");
			                rd.forward(request, response);
						}
					} else {//por default busco por instituto
						try {
							publicadores.DtCursoBase[] CIns = listarCursosInstituto(insCat);
							for(publicadores.DtCursoBase dtcb: CIns) {
								cursos.add(dtcb.getNombre());
							}
						} catch (ServiceException |RemoteException e) {
							request.setAttribute("mensaje", "Instituto inexistente o sin cursos");
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
					System.out.println("Recibe el nomcurso: "+nomCurso);
					sesion.setAttribute("cursoConsulta", nomCurso);
					ArrayList<String> infoCurso = new ArrayList<String>();
					publicadores.DtEdicionBase[] ediciones;
					ArrayList<String> edicionesStr = new ArrayList<String>();
					publicadores.DtCurso curso = new publicadores.DtCurso();
					try {
						publicadores.DtCurso[] CPla = listarCursosPlataforma(); 
						for(int i=0; i<CPla.length; i++) {
							if(CPla[i].getNombre().equals(nomCurso))
								curso = CPla[i];
						}
					} catch (ServiceException| RemoteException e1) {
						request.setAttribute("mensaje", "Error: sin cursos");
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
					if(curso.getPrevias().length != 0){
						for(publicadores.DtCursoBase p: curso.getPrevias()){
							previas = previas + " " + p.getNombre();
						}
					}
					if(previas == "") 
						previas = "Sin previas";
					infoCurso.add(previas);
					ediciones = curso.getEdiciones();
					for(publicadores.DtEdicionBase e: ediciones) {
						edicionesStr.add(e.getNombre());
					}
					sesion.setAttribute("edicionesConsultaCurso", edicionesStr);
					sesion.setAttribute("infoCurso", infoCurso);
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					rd.forward(request, response);
					break;


		}
		
	}
	public publicadores.DtCursoBase[] listarCursosCategoria(String categoria) throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		return port.listarCursosCategoria(categoria);
	}
	
	public publicadores.DtCursoBase[] listarCursosInstituto(String instituto) throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		return port.listarCursosInstituto(instituto);
	}
	
	public publicadores.DtCurso[] listarCursosPlataforma() throws RemoteException, ServiceException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		return port.listarCursosPlataforma();
	}

}
