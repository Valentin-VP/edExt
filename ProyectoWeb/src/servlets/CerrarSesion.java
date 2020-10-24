package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CerrarSesion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session != null) {
        	session.removeAttribute("tipo");
        	session.removeAttribute("nick");
        	session.removeAttribute("cursos");
        	session.removeAttribute("docentes");
        	session.removeAttribute("instituto");
        	session.removeAttribute("institutosAltaEd");
        	session.removeAttribute("cursosInfoEdicion");
        	session.removeAttribute("edicionesInfoEdicion");
        	session.removeAttribute("infoEdicion");
        	session.removeAttribute("InsCat");
        	session.removeAttribute("InsCatEd");
        	session.removeAttribute("cursoConsultaEdicion");
        	//session.removeAttribute("edicionConsultaEdicion");
        	session.removeAttribute("esInstituto");
        	session.removeAttribute("esCategoria");
        	session.removeAttribute("esInstitutoEd");
        	session.removeAttribute("esCategoriaEd");
        	session.removeAttribute("optConsultaEdicionInfoEdicion");
        	session.removeAttribute("optAltaEdicionAltaEd");
        	session.invalidate();
        }
        
        RequestDispatcher rd;
    	rd = request.getRequestDispatcher("/index.jsp");
    	rd.forward(request, response);    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String tipo = null;
		RequestDispatcher rd;
		request.setAttribute("tipo", tipo);
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);*/
	}

}
