package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.DtCurso;
import publicadores.DtFecha;
import publicadores.SinCursos;
//import interfaces.Fabrica;
//import interfaces.IControladorConsultaCurso;
import publicadores.ControladorConsultaCursoPublish;
import publicadores.ControladorConsultaCursoPublishService;
import publicadores.ControladorConsultaCursoPublishServiceLocator;

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
		// Cuando se tengan programas de formacion, se deben tener 2 Array (los cursos y progF), y luego aplicar los filtros (es decir, retornar solo 1 de ellos)
		
		HttpSession sesion = request.getSession(true);
		//Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		//IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();
		ArrayList<DtCurso> misCursos = new ArrayList<DtCurso>();
		ArrayList<DtCurso> cursosCompletos = new ArrayList<DtCurso>();
		try {
			misCursos = listarCursosPlataforma();
			// misProgramas = icon.listarProgramasPlataforma(); WARNING, NO EXISTE AUN
			
		} catch (SinCursos | ServiceException e) {
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
		
		// Se hace MATCH con la palabra buscada
		ArrayList<String> cursosQueMuestro = new ArrayList<String>();
		for(DtCurso dtc: misCursos) {
			if(dtc.getNombre().toLowerCase().contains(buscando.toLowerCase()) || dtc.getDescripcion().toLowerCase().contains(buscando.toLowerCase())) {
				cursosCompletos.add(dtc);
			}
		}
		
//		for(DtCurso dtc: misCursos) {
//			if(dtc.getNombre().toLowerCase().contains(buscando.toLowerCase()) || dtc.getDescripcion().toLowerCase().contains(buscando.toLowerCase())) {
//				cursosQueMuestro.add(dtc.getNombre());
//				System.out.println("Curso que matchea: "+dtc.getNombre());
//			}
//		}
//		
		// Lo mismo con PF (no disponible) 
		
		ArrayList<String> ResultadosFinales = new ArrayList<String>();
		
		for(DtCurso dtc: cursosCompletos){
			ResultadosFinales.add(dtc.getNombre()); 
		} 
		
		sesion.setAttribute("buscando", buscando);//falta ponerlo en refresh y cerrar sesion
		if(filtrado != null) { // QUIERO FILTRAR
			switch(filtrado) {//entro desde el jsp de la busqueda
			case "curso":		//filtro por cursos(hace lo mismo que el search)
								for(DtCurso dtc: cursosCompletos) {
									cursosQueMuestro.add(dtc.getNombre());
									System.out.println("Curso que matchea: "+dtc.getNombre());
								}
								ResultadosFinales = cursosQueMuestro;
								break;
			case "programa":	//filtro por programas(no lo uso)
								// ResultadosFinales = programasQueMuestro;
								request.setAttribute("mensaje", "Funcionalidad no disponible en la version gratuita :wink ");
								rd = request.getRequestDispatcher("/error.jsp");
								rd.forward(request, response);
								break;
			}
		}			 
		
		if(ordenado != null) { //QUIERO ORDENAR
			switch(ordenado) {//entro desde el jsp de la busqueda
			case "alfabeticamente":	//ordeno alfabeticamente(ascendente)
									Collections.sort(ResultadosFinales);
									break;
			case "fecha":	//ordeno por fecha(descendente)
									Collections.sort(cursosCompletos, new Comparator<DtCurso>() {
										  public int compare(DtCurso o1, DtCurso o2) {
										      try {
												if (DtFechaToDate(o1.getFechaR()) == null || DtFechaToDate(o2.getFechaR()) == null)
												    return 0;
											} catch (ParseException e) {
												e.printStackTrace();
											}
										      try {
												return DtFechaToDate(o1.getFechaR()).compareTo(DtFechaToDate(o2.getFechaR()));
											} catch (ParseException e) {
												e.printStackTrace();
											}
											return 0;
										  }
										});
									break;
			}
		}
		System.out.println("comboFiltrado vale " + filtrado);
		System.out.println("comboOrdenado vale " + ordenado);
		sesion.setAttribute("filtrado", filtrado);
		sesion.setAttribute("ordenado", ordenado);
		sesion.setAttribute("todosLosCursos", ResultadosFinales);
		rd = request.getRequestDispatcher("/BusquedaBarra.jsp");
		rd.forward(request, response);
	}
	
	public ArrayList<DtCurso> listarCursosPlataforma() throws ServiceException, SinCursos, RemoteException {
		ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
		ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();
		DtCurso[] cursos = port.listarCursosPlataforma();
		ArrayList<DtCurso> retorno = new ArrayList<DtCurso>();
		for (int i = 0; i < cursos.length; i++) {
		    retorno.add(cursos[i]);
		}
		return retorno;
	}
	
	public Date DtFechaToDate(DtFecha fecha) throws ParseException {
		String strdtf = aString(fecha.getDia(), fecha.getMes(), fecha.getAnio());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date date = sdf.parse(strdtf);
		return date;
	}
	
	public String aString(int dia, int mes, int anio) {
		return ""+dia+"/"+mes+"/"+anio;
	}
}
