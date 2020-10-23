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
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import excepciones.CategoriaInexistente;
import excepciones.CursoNoExiste;
import excepciones.InstitutoInexistente;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;

@WebServlet("/ConsultaEdicion")
public class ConsultaEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConsultaEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		IControladorConsultaEdicionCurso icon = fabrica.getIControladorConsultaEdicionCurso();
		switch(sesion.getAttribute("optConsultaEdicionInfoEdicion").toString()) {
		case "0":	//ingresar instituto, traer cursos y setear el opt en 1
					boolean esInstituto = request.getParameter("esInstitutoInfoEdicion") != null;
					boolean esCategoria = request.getParameter("esCategoriaInfoEdicion") != null;
					String InsCat = request.getParameter("InsCatEd");
					ArrayList<String> cursosInfoEdicion = new ArrayList<String>();
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
						for(DtEdicionBase dteb: icon.seleccionarCurso(curso)) {
							edicionesInfoEdicion.add(dteb.getNombre());
						}
						sesion.setAttribute("edicionesInfoEdicion", edicionesInfoEdicion);
					} catch (CursoNoExiste e) {
						throw new ServletException(e.getMessage());
					}
					sesion.setAttribute("cursoConsultaEdicion", curso);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "2");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		case "2":	//ingresar edicion, traer informacion y setear el opt en 3
					String edicion = request.getParameter("edicion");
					try {
						if((boolean)sesion.getAttribute("esInstituto") && !(boolean)sesion.getAttribute("esCategoria")) {
							@SuppressWarnings("unused")
							ArrayList<DtCursoBase> noLosUso = icon.seleccionarInstituto((String) sesion.getAttribute("InsCat"));
						} else if(!(boolean)sesion.getAttribute("esInstituto") && (boolean)sesion.getAttribute("esCategoria")) {
							@SuppressWarnings("unused")
							ArrayList<DtCursoBase> noLosUso = icon.seleccionarCategoria((String) sesion.getAttribute("InsCat"));
						}
					} catch (InstitutoInexistente | CategoriaInexistente e) {
						throw new ServletException(e.getMessage());
					}	
					try {
						@SuppressWarnings("unused")
						ArrayList<DtEdicionBase> tampocoLasUso = icon.seleccionarCurso((String) sesion.getAttribute("cursoConsultaEdicion"));
					} catch (CursoNoExiste a) {
						throw new ServletException(a.getMessage());
					}
					DtEdicion infoEdicion = icon.seleccionarEdicion(edicion);
					sesion.setAttribute("infoEdicion", infoEdicion);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "3");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		}
	}

}
