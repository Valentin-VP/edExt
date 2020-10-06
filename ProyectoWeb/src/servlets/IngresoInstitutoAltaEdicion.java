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
import datatypes.DtUsuarioBase;
import excepciones.InstitutoInexistente;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicionCurso;

@WebServlet("/IngresoInstitutoAltaEdicion")
public class IngresoInstitutoAltaEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IngresoInstitutoAltaEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String instituto = request.getParameter("instituto");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaEdicionCurso icon = fabrica.getIControladorAltaEdicionCurso();
		List<String> cursos = new ArrayList<String>();
		List<String> docentes = new ArrayList<String>();
		HttpSession sesion = request.getSession(true);
		try {
			for(DtCursoBase dtcb: icon.seleccionarInstituto(instituto)) {
				cursos.add(dtcb.getNombre());
			}
			sesion.setAttribute("cursos", cursos);
		} catch (InstitutoInexistente e) {
			e.printStackTrace();
		}
		for(DtUsuarioBase dtub: icon.getDocentes()) {
			docentes.add(dtub.getNick());
		}
		sesion.setAttribute("docentes", docentes);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/altaEdicion.jsp");
		rd.forward(request, response);
	}

}
