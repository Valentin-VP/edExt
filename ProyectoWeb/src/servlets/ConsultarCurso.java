package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DtCursoBase;
import excepciones.CategoriaInexistente;
import excepciones.InstitutoInexistente;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;

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
		switch((String)sesion.getAttribute("optConsultaCurso")) {
		case "0": 	boolean esInstituto = request.getParameter("esInstituto") != null;
					boolean esCategoria = request.getParameter("esCategoria") != null;
					String InsCat = request.getParameter("InsCat");
					ArrayList<String> cursosInfoEdicion = new ArrayList<String>();
					Fabrica fabrica = Fabrica.getInstancia();
					IControladorConsultaEdicionCurso icon = fabrica.getIControladorConsultaEdicionCurso();
					if(!esInstituto && esCategoria) {
						try {
							for(DtCursoBase dtcb: icon.seleccionarCategoria(InsCat)) {
								cursosInfoEdicion.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursosInfoEdicion", cursosInfoEdicion);
						} catch (CategoriaInexistente e) {
							throw new ServletException(e.getMessage());
						}
					} else {//por default busco por instituto
						try {
							for(DtCursoBase dtcb: icon.seleccionarInstituto(InsCat)) {
								cursosInfoEdicion.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursosInfoEdicion", cursosInfoEdicion);
						} catch (InstitutoInexistente e) {
							throw new ServletException(e.getMessage());
						}
					}
					sesion.setAttribute("InsCat", InsCat);
					sesion.setAttribute("esCategoria", esCategoria);
					sesion.setAttribute("esInstituto", esInstituto);
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		}
	}

}
