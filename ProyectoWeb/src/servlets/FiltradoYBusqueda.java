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
		} catch (SinCursos e) {
			e.printStackTrace();
		}
		for(DtCurso cu: misCursos) {
			System.out.println("Curso: " + cu.getNombre());
		}
		String filtrado = (String) request.getParameter("comboFiltrado");
		String ordenado = (String) request.getParameter("comboOrdenado");
		String buscando = (String) request.getParameter("busqueda");
		if(buscando == null) {
			buscando = (String) sesion.getAttribute("buscando");
		}
		System.out.println("Buscando vale " + buscando);
		
		ArrayList<String> cursosQueMuestro = new ArrayList<String>();
		sesion.setAttribute("buscando", buscando);//falta ponerlo en refresh y cerrar sesion
		if(filtrado != null) {
			switch(filtrado) {//entro desde el jsp de la busqueda
			case "curso":	//filtro por cursos(hace lo mismo que el search)
							for(DtCurso dtc: misCursos) {
								if(dtc.getNombre().toLowerCase().contains(sesion.getAttribute("buscando").toString().toLowerCase()) || dtc.getDescripcion().toLowerCase().contains(sesion.getAttribute("buscando").toString().toLowerCase())) {
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
									System.out.println("Ordenando alfabeticamente");
									break;
			case "fecha":	//ordeno por fecha(descendente)
									System.out.println("Ordenando por fecha");
									break;
			}
		}
		
		if(filtrado == null && ordenado == null) {//entro desde el search del header(con "busqueda")
			//despliego todos los CURSOS que contienen lo buscado en el nombre o la descripcion
			
			for(DtCurso dtc: misCursos) {
				if(dtc.getNombre().toLowerCase().contains(buscando.toLowerCase()) || dtc.getDescripcion().toLowerCase().contains(buscando.toLowerCase())) {
					cursosQueMuestro.add(dtc.getNombre());
					System.out.println("Curso que matchea: "+dtc.getNombre());
				}
			}
		}
		System.out.println("comboFiltrado vale " + filtrado);
		System.out.println("comboOrdenado vale " + ordenado);
		sesion.setAttribute("filtrado", filtrado);
		sesion.setAttribute("ordenado", ordenado);
		sesion.setAttribute("todosLosCursos", cursosQueMuestro);
		rd = request.getRequestDispatcher("/BusquedaBarra.jsp");
		rd.forward(request, response);
	}
}
