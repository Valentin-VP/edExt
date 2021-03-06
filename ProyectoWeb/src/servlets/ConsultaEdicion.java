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
							request.setAttribute("mensaje", e.getMessage());
							rd = request.getRequestDispatcher("/error.jsp");
							rd.forward(request, response);
						}
					} else {//por default busco por instituto
						try {
							for(DtCursoBase dtcb: icon.seleccionarInstituto(InsCat)) {
								cursosInfoEdicion.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursosInfoEdicion", cursosInfoEdicion);
						} catch (InstitutoInexistente e) {
							request.setAttribute("mensaje", e.getMessage());
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
						for(DtEdicionBase dteb: icon.seleccionarCurso(curso)) {
							edicionesInfoEdicion.add(dteb.getNombre());
						}
						sesion.setAttribute("edicionesInfoEdicion", edicionesInfoEdicion);
					} catch (CursoNoExiste e) {
						request.setAttribute("mensaje", e.getMessage());
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
							ArrayList<DtCursoBase> noLosUso = icon.seleccionarInstituto((String) sesion.getAttribute("InsCatEd"));
						} else if(!esInstituto2 && esCategoria2) {
							@SuppressWarnings("unused")
							ArrayList<DtCursoBase> noLosUso = icon.seleccionarCategoria((String) sesion.getAttribute("InsCatEd"));
						}
					} catch (InstitutoInexistente | CategoriaInexistente e) {
						request.setAttribute("mensaje", e.getMessage());
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}	
					try {
						@SuppressWarnings("unused")
						ArrayList<DtEdicionBase> tampocoLasUso = icon.seleccionarCurso((String) sesion.getAttribute("cursoConsultaEdicion"));
					} catch (CursoNoExiste a) {
						request.setAttribute("mensaje", a.getMessage());
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					DtEdicion infoEdicion = icon.seleccionarEdicion(edicion);
					sesion.setAttribute("infoEdicion", infoEdicion);
					sesion.setAttribute("edicionConsultaEdicion",edicion);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "3");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		
		case "5":	String edicion3 = request.getParameter("edicion");
					DtEdicion infoEdicion3 = icon.seleccionarEdicion(edicion3);
					sesion.setAttribute("infoEdicion", infoEdicion3);
					sesion.setAttribute("edicionConsultaEdicion",edicion3);
					sesion.setAttribute("optConsultaEdicionInfoEdicion", "3");
					rd = request.getRequestDispatcher("/infoEdicion.jsp");
					rd.forward(request, response);
					break;
		}
	}

}
