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

import datatypes.DtCursoBase;
import datatypes.DtCurso;
import datatypes.DtFecha;
import datatypes.DtEdicionBase;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCursos;
import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;

/**
 * Servlet implementation class ConsultarCurso
 */
@WebServlet("/ConsultarCurso")
public class ConsultarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ConsultarCurso() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		System.out.println(sesion.getAttribute("optConsultaCursoInfoCurso").toString());
		Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();
		switch(sesion.getAttribute("optConsultaCursoInfoCurso").toString()) {
		case "0": //carga una variable con los cursos
					boolean esInstituto = request.getParameter("esInstitutoInfoCurso") != null;
					boolean esCategoria = request.getParameter("esCategoriaInfoCurso") != null;
					String insCat = request.getParameter("instituto-categoria");
					ArrayList<String> cursos = new ArrayList<String>();
					System.out.println(esInstituto);
					System.out.println(esCategoria);
					if(!esInstituto && esCategoria) {
						try {
							for(DtCursoBase dtcb: icon.listarCursosCategoria(insCat)) {
								cursos.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursos", cursos);
						} catch (CategoriaInexistente |CategoriaSinCursos e) {
							request.setAttribute("mensaje", e.getMessage());
			                rd = request.getRequestDispatcher("/error.jsp");
			                rd.forward(request, response);
						}
					} else {//por default busco por instituto
						try {
							for(DtCursoBase dtcb: icon.listarCursosInstituto(insCat)) {
								cursos.add(dtcb.getNombre());
							}
						} catch (InstitutoInexistente | InstitutoSinCursos e) {
							request.setAttribute("mensaje", e.getMessage());
			                rd = request.getRequestDispatcher("/error.jsp");
			                rd.forward(request, response);
						}
					}
					sesion.setAttribute("cursosConsulta", cursos);
					sesion.setAttribute("instituto-categoria", insCat);
					sesion.setAttribute("esCategoria", esCategoria);
					sesion.setAttribute("esInstituto", esInstituto);
					sesion.setAttribute("optConsultaCursoInfoCurso", "1");
					
					
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					rd.forward(request, response);
					break;	

		case "1":	String nomCurso = request.getParameter("dropdownCursos").toString();
					System.out.println("Recibe el nomcurso: "+nomCurso);
					sesion.setAttribute("cursoConsulta", nomCurso);
					ArrayList<String> infoCurso = new ArrayList<String>();
					ArrayList<DtEdicionBase> ediciones = new ArrayList<DtEdicionBase>();
					ArrayList<String> edicionesStr = new ArrayList<String>();
					DtCurso curso = new DtCurso();
					try {
						for(DtCurso dtc: icon.listarCursosPlataforma()) {
							if(dtc.getNombre().equals(nomCurso))
								curso = dtc;
						}
					} catch (SinCursos e1) {
						request.setAttribute("mensaje", e1.getMessage());
		                rd = request.getRequestDispatcher("/error.jsp");
		                rd.forward(request, response);
					}
					infoCurso.add(nomCurso);
					infoCurso.add(curso.getDescripcion());
					infoCurso.add(curso.getDuracion());
					infoCurso.add(Integer.toString(curso.getCantHoras()));
					infoCurso.add(curso.getCreditos().toString());
					infoCurso.add(curso.getUrl());
					String categorias = "";
					if(!curso.getCategorias().isEmpty()){
						for(String c: curso.getCategorias()){
							categorias = categorias + " " + c;
						}
					}
					infoCurso.add(categorias);
					ediciones = curso.getEdiciones();
					for(DtEdicionBase e: ediciones) {
						edicionesStr.add(e.getNombre());
					}
					sesion.setAttribute("edicionesConsultaCurso", edicionesStr);
					sesion.setAttribute("infoCurso", infoCurso);
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					rd.forward(request, response);
					break;


		}
		
	}

}
