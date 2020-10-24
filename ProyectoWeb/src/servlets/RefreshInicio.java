package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RefreshInicio")
public class RefreshInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RefreshInicio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session != null) {
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
        	session.removeAttribute("edicionConsultaEdicion");
        	session.removeAttribute("esInstituto");
        	session.removeAttribute("esCategoria");
        	session.removeAttribute("esInstitutoEd");
        	session.removeAttribute("esCategoriaEd");
        	session.removeAttribute("optConsultaEdicionInfoEdicion");
			session.removeAttribute("optAltaEdicionAltaEd");
			session.removeAttribute("optConsultaCursoInfoCurso");
			session.removeAttribute("cursosConsulta");
			session.removeAttribute("infoCurso");
			session.removeAttribute("institutoConsultaCurso");
        	session.removeAttribute("optAltaCurso");
        	session.removeAttribute("institutoAltaCurso");
        	session.removeAttribute("previasAltaCurso");
        	session.removeAttribute("categoriasAltaCurso");
        	session.removeAttribute("institutoAltaCurso");
        	session.removeAttribute("opAceptadosEdicion");
        	session.removeAttribute("cursosAceptados");
        	session.removeAttribute("edicionesAceptados");
        	session.removeAttribute("infoFinalAceptados");
        	session.removeAttribute("todosLosCursos");
        	//session.invalidate();
        }

        RequestDispatcher rd;
    	rd = request.getRequestDispatcher("/index.jsp");
    	rd.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nada
	}

}
