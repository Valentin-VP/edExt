package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtFecha;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;

@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AltaUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String nick = request.getParameter("nick");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String pass = request.getParameter("pass");
		String verificacion = request.getParameter("verificar");
		String instituto = request.getParameter("instituto");
		boolean esDocente = request.getParameter("esDocente") != null;
		Integer dia = Integer.parseInt(request.getParameter("DiaNac"));
		Integer mes = Integer.parseInt(request.getParameter("MesNac"));
		Integer anio = Integer.parseInt(request.getParameter("AnioNac"));
		DtFecha fechaNac = new DtFecha(dia, mes, anio);
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaUsuario icon = fabrica.getIControladorAltaUsuario();
		RequestDispatcher rd;
		if(pass.equals(verificacion)) {
			try {
				icon.seleccionarInstituto(instituto);
				icon.altaUsuario(nick, correo, nombre, apellido, fechaNac, pass);
				icon.confirmarAltaUsuario(esDocente);
			} catch(Exception e) {
				throw new ServletException(e.getMessage());
			}
		}
		String tipo;
		if(esDocente) {
			tipo="Docente";
		} else tipo="Estudiante";
		request.setAttribute("mensaje", "El usuario de tipo " + tipo + " se ha ingresado correctamente");
		rd = request.getRequestDispatcher("/notifiacion.jsp");
		rd.forward(request, response);
	}
}
