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
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtUsuarioBase;
import excepciones.CursoNoExiste;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoDocente;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaUsuario;

@WebServlet("/AltaEdicionCurso")
public class AltaEdicionCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AltaEdicionCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaEdicionCurso icon = fabrica.getIControladorAltaEdicionCurso();
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		switch(sesion.getAttribute("optAltaEdicionAltaEd").toString()) {
		case "0"://traerme cursos y docentes del instituto
					String instituto = request.getParameter("institutoAltaEd");
					List<String> cursos = new ArrayList<String>();
					List<String> docentes = new ArrayList<String>();
					sesion.setAttribute("institutoAltaEd", instituto);
					try {
						for(DtCursoBase dtcb: icon.seleccionarInstituto(instituto)) {
							cursos.add(dtcb.getNombre());
						}
						sesion.setAttribute("cursos", cursos);
					} catch (InstitutoInexistente e) {
						throw new ServletException(e.getMessage());
					}
					for(DtUsuarioBase dtub: icon.getDocentes()) {
						docentes.add(dtub.getNick());
					}
					sesion.setAttribute("docentes", docentes);
					sesion.setAttribute("optAltaEdicionAltaEd", "1");
					rd = request.getRequestDispatcher("/altaEdicion.jsp");
					rd.forward(request, response);
					break;
		case "1"://hacer el alta de la edicion
					String curso = request.getParameter("curso");
					String nombre = request.getParameter("nombreEdicion");
					boolean conCupos = request.getParameter("tieneCupos") != null;
					Integer cupos = Integer.parseInt(request.getParameter("cantidadCupos"));
					Integer diaI = Integer.parseInt(request.getParameter("DiaI"));
					Integer mesI = Integer.parseInt(request.getParameter("MesI"));
					Integer anioI = Integer.parseInt(request.getParameter("AnioI"));
					DtFecha fechaI = new DtFecha(diaI, mesI, anioI);
					Integer diaF = Integer.parseInt(request.getParameter("DiaF"));
					Integer mesF = Integer.parseInt(request.getParameter("MesF"));
					Integer anioF = Integer.parseInt(request.getParameter("AnioF"));
					DtFecha fechaF = new DtFecha(diaF, mesF, anioF);
					Integer diaP = Integer.parseInt(request.getParameter("DiaP"));
					Integer mesP = Integer.parseInt(request.getParameter("MesP"));
					Integer anioP = Integer.parseInt(request.getParameter("AnioP"));
					DtFecha fechaP = new DtFecha(diaP, mesP, anioP);
					String[] profesores = request.getParameterValues("docentes");
					ArrayList<String> profes = new ArrayList<String>();
					for(String s: profesores) {
						profes.add(s);
					}
					try {
						String i = (String) sesion.getAttribute("instituto");
						@SuppressWarnings("unused")
						List<DtCursoBase> noLosUso = icon.seleccionarInstituto(i);
						icon.altaEdicionCurso(curso, nombre, fechaI, fechaF, profes, conCupos, cupos, fechaP);
					} catch (EdicionRepetida | CursoNoExiste | InstitutoInexistente | UsuarioNoDocente e) {
						throw new ServletException(e.getMessage());
					}
					request.setAttribute("mensaje", "La edicion fue agregada con exito");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
					break;
		}
	}
}
