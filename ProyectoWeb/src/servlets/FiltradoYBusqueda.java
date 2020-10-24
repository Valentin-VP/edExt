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

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import excepciones.SinCursos;
import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;

@WebServlet("/FiltradoYBusqueda")
public class FiltradoYBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FiltradoYBusqueda() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();
		try {
			ArrayList<DtCursoBase> cursosPlataforma = icon.listarCursosPlataforma();
			ArrayList<DtCurso> misCursos = new ArrayList<DtCurso>();
			for(DtCursoBase dtcb: cursosPlataforma) {
				DtCurso dtc = icon.consultarCurso(dtcb.getNombre());
				misCursos.add(dtc);
			}
			sesion.setAttribute("todosLosCursos", misCursos);
		} catch (SinCursos e) {
			e.printStackTrace();
		}
		String filtrado = request.getParameter("comboFiltrado");
		String ordenado = request.getParameter("comboOrdenado");
		if(filtrado != null) {
			switch(filtrado) {//entro desde el jsp de la busqueda
			case "curso":	//filtro por cursos(hace lo mismo que el search)
							break;
			case "programa":	//filtro por programas(no lo uso)
								System.out.println("No Disponible");
								break;
			}
		}
		
		if(ordenado != null) {
			switch(ordenado) {//entro desde el jsp de la busqueda
			case "alfabeticamente":	//ordeno alfabeticamente(lo que esta en la lista "todosLosCursos")
									break;
			case "fecha":	//ordeno por fecha(lo que esta en la lista "todosLosCursos")
							break;
			}
		}
		
		if(filtrado == null && ordenado == null) {//entro desde el search del header
			//despliego todos los CURSOS que contienen lo buscado en el nombre o la descripcion
		}
	}

}
