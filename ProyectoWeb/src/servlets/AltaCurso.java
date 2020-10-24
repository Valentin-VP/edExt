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
import datatypes.DtInstituto;
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
		
		switch(sesion.getAttribute("optAltaCurso").toString()) {
		case "inicio" : 
			DtInstituto instituto = new DtInstituto (request.getParameter("institutoAltaCurso").toString());
			List<String> categorias = new ArrayList<String>();
			ArrayList<DtCursoBase> previas = new ArrayList<DtCursoBase>();
			try {
				for(String strcat: icon.listarCategorias()) {
					categorias.add(strcat);
				}
				sesion.setAttribute("categoriasAltaCurso", categorias);
			} catch (SinCategorias e) {
				throw new ServletException(e.getMessage());
			}
			
			try {
				for(DtCursoBase dtcb: iconaux.listarCursosInstituto(instituto.getNombre())) {
					previas.add(dtcb);
				}
				sesion.setAttribute("previasAltaCurso", previas);
			} catch (InstitutoInexistente | InstitutoSinCursos e) {
				throw new ServletException(e.getMessage());
			}
			
			sesion.setAttribute("optAltaCurso", "cargaDatos");
			System.out.println("Saliendo de Servlet");
			rd = request.getRequestDispatcher("/agregarCurso.jsp");
			rd.forward(request, response);
			break;
		default :
			
		}
		
	}

}
