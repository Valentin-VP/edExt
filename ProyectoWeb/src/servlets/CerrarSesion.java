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
			session.removeAttribute("edicionesConsultaCurso");
			session.removeAttribute("institutoConsultaCurso");
			session.removeAttribute("cursoConsulta");
			session.removeAttribute("edicionConsulta");
        	session.removeAttribute("optAltaCurso");
        	session.removeAttribute("institutoAltaCurso");
        	session.removeAttribute("previasAltaCurso");
        	session.removeAttribute("categoriasAltaCurso");
        	session.removeAttribute("institutoAltaCurso");
        	session.removeAttribute("todosLosCursos");
        	session.removeAttribute("buscando");
        	session.removeAttribute("opAceptadosEdicion");
        	session.removeAttribute("cursosAceptados");
        	session.removeAttribute("edicionesAceptados");
        	session.removeAttribute("infoFinalAceptados");
        	
        	session.removeAttribute("opSeleccionarEstudiantes");
        	session.removeAttribute("cursosSeleccionarEstudiantes");
        	session.removeAttribute("edicionCompletaSeleccionarEstudiantes");
        	session.removeAttribute("inscripcionesEstudiantes");
        	
        	session.removeAttribute("filtrado");
        	session.removeAttribute("ordenado");
        	session.removeAttribute("todosLosCursos");
        	session.removeAttribute("dropdownCursos");
        	session.removeAttribute("optConsultaUsuario");
        	session.removeAttribute("usuariosConsultaUsuario");
        	session.removeAttribute("DtUser");
        	session.removeAttribute("seguido");
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
