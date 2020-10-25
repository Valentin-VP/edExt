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
		ArrayList<DtCurso> misCursos = new ArrayList<DtCurso>();
		try {
			misCursos = icon.listarCursosPlataforma();
			sesion.setAttribute("todosLosCursos", misCursos);
		} catch (SinCursos e) {
			e.printStackTrace();
		}
		String filtrado = (String) request.getParameter("comboFiltrado");
		String ordenado = (String) request.getParameter("comboOrdenado");
		String buscando = (String) request.getParameter("busqueda");
		sesion.setAttribute("buscando", buscando);//falta ponerlo en refresh y cerrar sesion
		if(filtrado != null) {
			switch(filtrado) {//entro desde el jsp de la busqueda
			case "curso":	//filtro por cursos(hace lo mismo que el search)
							ArrayList<String> cursosQueMuestro = new ArrayList<String>();
							for(DtCurso dtc: misCursos) {
								if(dtc.getNombre().contains(sesion.getAttribute("buscando").toString()) || dtc.getDescripcion().contains(sesion.getAttribute("buscando").toString())) {
									cursosQueMuestro.add(dtc.getNombre());
								}
							}
							break;
			case "programa":	//filtro por programas(no lo uso)
								System.out.println("No Disponible");
								break;
			}
		}
		
		if(ordenado != null) {
			switch(ordenado) {//entro desde el jsp de la busqueda
			case "alfabeticamente":	//ordeno alfabeticamente(ascendente)
									
									break;
			case "fecha":	//ordeno por fecha(descendente)
							
							break;
			}
		}
		
		if(filtrado == null && ordenado == null) {//entro desde el search del header(con "busqueda")
			//despliego todos los CURSOS que contienen lo buscado en el nombre o la descripcion
			ArrayList<String> cursosQueMuestro = new ArrayList<String>();
			for(DtCurso dtc: misCursos) {
				if(dtc.getNombre().contains(buscando) || dtc.getDescripcion().contains(buscando)) {
					cursosQueMuestro.add(dtc.getNombre());
				}
			}
		}
		request.setAttribute("filtrado", filtrado);
		request.setAttribute("ordenado", ordenado);
		rd = request.getRequestDispatcher("/BusquedaBarra.jsp");
		rd.forward(request, response);
	}
}
