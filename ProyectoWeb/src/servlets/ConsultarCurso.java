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
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
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
		Fabrica fabrica = Fabrica.getInstancia();
		RequestDispatcher rd;
		IControladorConsultaCurso icon = fabrica.getIControladorConsultaCurso();
		switch(sesion.getAttribute("optConsultaCursoInfoCurso").toString()) {
		case "0": //carga una variable con los cursos
					boolean esInstituto = request.getParameter("esInstitutoInfoCurso") != null;
					boolean esCategoria = request.getParameter("esCategoriaInfoCurso") != null;
					String InsCat = request.getParameter("instituto-categoria");
					ArrayList<String> cursos = new ArrayList<String>();
					if(!esInstituto && esCategoria) {
						try {
							for(DtCursoBase dtcb: icon.listarCursosCategoria(InsCat)) {
								cursos.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursos", cursos);
						} catch (CategoriaInexistente |CategoriaSinCursos e) {
							throw new ServletException(e.getMessage());
						}
					} else {//por default busco por instituto
						try {
							for(DtCursoBase dtcb: icon.listarCursosInstituto(InsCat)) {
								cursos.add(dtcb.getNombre());
							}
							sesion.setAttribute("cursosConsulta", cursos);
						} catch (InstitutoInexistente | InstitutoSinCursos e) {
							throw new ServletException(e.getMessage());
						}
					}
					sesion.setAttribute("instituto-categoria", InsCat);
					sesion.setAttribute("esCategoria", esCategoria);
					sesion.setAttribute("esInstituto", esInstituto);
					sesion.setAttribute("optConsultaCursoInfoCurso", "1");
					
					
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					
					System.out.println("ConsultarCurso setea: " + sesion.getAttribute("optConsultaCursoInfoCurso"));
					rd.forward(request, response);
					break;	

		case "1": 	String nomCurso = (String) request.getParameter("dropdownCursos");
					ArrayList<String> infoCurso = new ArrayList<String>();
					DtCurso curso = icon.consultarCurso(nomCurso);
					infoCurso.add(nomCurso);
					infoCurso.add(curso.getDescripcion());
					infoCurso.add(curso.getDuracion());
					infoCurso.add(Integer.toString(curso.getCantHoras()));
					infoCurso.add(curso.getCreditos().toString());
					infoCurso.add(curso.getUrl());
					String categorias = "";
					if(!curso.getCategorias().isEmpty()){
						for(String c: curso.getCategorias()){
							categorias = categorias + ", " + c;
						}
					}
					infoCurso.add(categorias);
					sesion.setAttribute("infoCurso", infoCurso);
					rd = request.getRequestDispatcher("/infoCurso.jsp");
					rd.forward(request, response);
					break;

		case "2":	
					break;
		}
		
	}

}
