package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import publicadores.DtCursoBase;
import publicadores.DtFecha;
import publicadores.DtInstituto;
import publicadores.CursoRepetido;
import publicadores.InstitutoInexistente;
import publicadores.InstitutoSinCursos;
import publicadores.SinCategorias;
import publicadores.ControladorAltaCursoPublish;
import publicadores.ControladorAltaCursoPublishService;
import publicadores.ControladorAltaCursoPublishServiceLocator;
import publicadores.ControladorInscripcionEdicionPublish;
import publicadores.ControladorInscripcionEdicionPublishService;
import publicadores.ControladorInscripcionEdicionPublishServiceLocator;

/**
 * Servlet implementation class altaCurso
 */
@WebServlet("/AltaCurso")
public class AltaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String error = "";

    public AltaCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Fabrica fabrica = Fabrica.getInstancia(); IControladorAltaCurso icon =
		 * fabrica.getIControladorAltaCurso(); IControladorConsultaCurso iconaux =
		 * fabrica.getIControladorConsultaCurso();
		 */
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		String instituto = "";
		ArrayList<String> categorias = new ArrayList<>();
		ArrayList<String> previas = new ArrayList<String>();
		
		switch(sesion.getAttribute("optAltaCurso").toString()) {
		case "inicio" : 
			instituto = request.getParameter("institutoAltaCurso").toString();

			try {
				for(String strcat: listarCategorias()) {
					categorias.add(strcat);
				}
				sesion.setAttribute("categoriasAltaCurso", categorias);
			} catch (RemoteException| ServiceException e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			
			try {
				for(DtCursoBase dtcb: iconaux.listarCursosInstituto(instituto)) {
					previas.add(dtcb.getNombre());
				}
				sesion.setAttribute("previasAltaCurso", previas);
			}catch (InstitutoInexistente e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}catch (InstitutoSinCursos e) {
				previas = null;
				sesion.setAttribute("previasAltaCurso", previas);
			}
			sesion.setAttribute("institutoAltaCurso", instituto);
			sesion.setAttribute("optAltaCurso", "cargaDatos");
			rd = request.getRequestDispatcher("/agregarCurso.jsp");
			rd.forward(request, response);
			break;
		case "cargaDatos" :
			instituto = sesion.getAttribute("institutoAltaCurso").toString();
			String[] selcategorias = request.getParameterValues("categoriasAltaCurso");
			String[] selprevias = request.getParameterValues("previasAltaCurso");
			String nombre = request.getParameter("cursoAltaCurso");
			String descripcion = request.getParameter("descripcionAltaCurso");
			String duracion = request.getParameter("duracionAltaCurso");
			String url = request.getParameter("urlAltaCurso");
			
			LocalDate date = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-u");
			ArrayList<Integer> datos = new ArrayList<>();
			String valores [] = (date.format(format)).split("-");
			for(String s: valores) {
				int temp = Integer.parseInt(s);
				datos.add(temp);
			}
			DtFecha fechaR = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
			
			if (checkeo(instituto,nombre,descripcion,duracion,request.getParameter("cantHorasAltaCurso"),request.getParameter("creditosAltaCurso"),url)) {
				Integer cantHoras = Integer.parseInt(request.getParameter("cantHorasAltaCurso"));
				Integer creditos = Integer.parseInt(request.getParameter("creditosAltaCurso"));
				System.out.println("cantHoras vale: " + cantHoras + "creditos vale:" + creditos);
				try {
					icon.altaCurso(instituto, nombre, descripcion, duracion, cantHoras, creditos, url, fechaR);
				} catch (CursoRepetido | InstitutoInexistente e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				}
				
				if(selprevias != null) {
					for(String p: selprevias) {
						icon.agregarPrevia(p);
					}
				}
				if(selcategorias != null) {
					for(String c: selcategorias) {
						icon.agregarCategoria(c);
					}
				}
				
				icon.confirmarAltaCurso();
				request.setAttribute("mensaje", "El curso fue ingresado con exito");
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("mensaje", error);
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}

			break;
		default :
			request.setAttribute("mensaje", "Ha ocurrido un error en servlet de Alta Curso");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			break;
		}
		
	}
	
	protected boolean checkeo(String instituto, String nombre, String descripcion, String duracion, String strcantHoras, String strcreditos, String url) {
		System.out.println(instituto + nombre + descripcion + strcantHoras + strcreditos + url);
		int cantHoras = 0;
		int creditos = 0;
		
		if(instituto.isEmpty() || nombre.isEmpty() || url.isEmpty() || descripcion.isEmpty() || duracion.isEmpty()){
			error = "No puede haber campos vacios";
			return false;
		}else {
			try {
				cantHoras = Integer.parseInt(strcantHoras);
			}catch(NumberFormatException e) {
				error = "Valor incorrecto en cantHoras";
				return false;
			}
			try {
				creditos = Integer.parseInt(strcreditos);
			}catch(NumberFormatException e) {
				error = "Valor incorrecto en creditos";
				return false;
			}
			
			if(cantHoras < 1 || creditos < 1) {
				error = "No se permiten valores menores a 1";
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<String> listarCategorias() throws RemoteException, ServiceException {
		ControladorAltaCursoPublishService cps = new ControladorAltaCursoPublishServiceLocator();
		ControladorAltaCursoPublish port = cps.getControladorAltaCursoPublishPort();
		String[] categorias = port.listarCategorias();
		ArrayList<String> retorno = new ArrayList<String>();
		for (int i = 0; i < categorias.length; ++i) {
		    retorno.add(categorias[i]);
		}
		return retorno;
	}

}
