package servlets;

import java.io.IOException;
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

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorConsultaCurso;

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
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso icon = fabrica.getIControladorAltaCurso();
		IControladorConsultaCurso iconaux = fabrica.getIControladorConsultaCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		String instituto = "";
		ArrayList<String> categorias = new ArrayList<>();
		ArrayList<String> previas = new ArrayList<String>();
		
		switch(sesion.getAttribute("optAltaCurso").toString()) {
		case "inicio" : 
			instituto = request.getParameter("institutoAltaCurso").toString();

			try {
				for(String strcat: icon.listarCategorias()) {
					categorias.add(strcat);
				}
				sesion.setAttribute("categoriasAltaCurso", categorias);
			} catch (SinCategorias e) {
				throw new ServletException(e.getMessage());
			}
			
			try {
				for(DtCursoBase dtcb: iconaux.listarCursosInstituto(instituto)) {
					previas.add(dtcb.getNombre());
				}
				sesion.setAttribute("previasAltaCurso", previas);
			} catch (InstitutoInexistente | InstitutoSinCursos e) {
				throw new ServletException(e.getMessage());
			}
			sesion.setAttribute("institutoAltaCurso", instituto);
			sesion.setAttribute("optAltaCurso", "cargaDatos");
			System.out.println("Saliendo de Servlet");
			rd = request.getRequestDispatcher("/agregarCurso.jsp");
			rd.forward(request, response);
			break;
		case "cargaDatos" :
			instituto = request.getParameter("institutoAltaCurso").toString();
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
			
			// previas = new ArrayList<>();
			// categorias = new ArrayList<>();
		
			// chequeo
			if (checkeo(instituto,nombre,descripcion,duracion,request.getParameter("cantHorasAltaCurso"),request.getParameter("creditosAltaCurso"),url)) {
				Integer cantHoras = Integer.parseInt(request.getParameter("cantHorasAltaCurso"));
				Integer creditos = Integer.parseInt(request.getParameter("creditosAltaCurso"));
				System.out.println("cantHoras vale: " + cantHoras + "creditos vale:" + creditos);
				try {
					icon.altaCurso(instituto, nombre, descripcion, duracion, cantHoras, creditos, url, fechaR);
				} catch (CursoRepetido | InstitutoInexistente e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
				}
				
				if(selprevias != null) {
					for(String p: selprevias) {
						icon.agregarPrevia(p);
						// previas.add(p);
					}
				}
				if(selcategorias != null) {
					for(String c: selcategorias) {
						icon.agregarCategoria(c);
						// categorias.add(c);
					}
				}
				
				icon.confirmarAltaCurso();
				request.setAttribute("mensaje", "El curso fue ingresado con exito");
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("mensaje", "Revise los datos ingresados");
				rd = request.getRequestDispatcher("/notificacion.jsp");
				rd.forward(request, response);
			}

			break;
		default :
			System.out.println("Ha ocurrido un error en servlet de Alta Curso");
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

}
