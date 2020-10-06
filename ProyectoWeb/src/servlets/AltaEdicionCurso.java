package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtFecha;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicionCurso;

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
		String nombre = request.getParameter("curso");
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
		String docentes = request.getParameter("docentes");//solo trae al primer docente
		//String[] profes = docentes.split(",");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaEdicionCurso icon = fabrica.getIControladorAltaEdicionCurso();
		//llamar a logica de altaEdicionCurso
		RequestDispatcher rd;
		System.out.println("docentes: " + docentes);
		request.setAttribute("mensaje", "los docentes " + docentes + " fueron ingresados");
		rd = request.getRequestDispatcher("/notifiacion.jsp");
		rd.forward(request, response);
	}

}
