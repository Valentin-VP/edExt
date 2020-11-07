package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.DtCursoBase;
import publicadores.DtFecha;
import publicadores.DtUsuarioBase;
import publicadores.ControladorAltaEdicionCursoPublish;
import publicadores.ControladorAltaEdicionCursoPublishService;
import publicadores.ControladorAltaEdicionCursoPublishServiceLocator;

@WebServlet("/AltaEdicionCurso")
public class AltaEdicionCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AltaEdicionCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		RequestDispatcher rd;
		
		switch(sesion.getAttribute("optAltaEdicionAltaEd").toString()) {
		case "0"://traerme cursos y docentes del instituto
					String instituto = request.getParameter("institutoAltaEd");
					List<String> cursos = new ArrayList<String>();
					List<String> docentes = new ArrayList<String>();
					sesion.setAttribute("institutoAltaEd", instituto);
					try {
						for(DtCursoBase dtcb: seleccionarInstituto(instituto)) {
							cursos.add(dtcb.getNombre());
						}
						sesion.setAttribute("cursos", cursos);
					} catch (Exception e) {
						request.setAttribute("mensaje", e.getMessage());
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
			try {
				for(DtUsuarioBase dtub: getDocentes()) {
					docentes.add(dtub.getNick());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
					sesion.setAttribute("docentes", docentes);
					sesion.setAttribute("optAltaEdicionAltaEd", "1");
					rd = request.getRequestDispatcher("/altaEdicion.jsp");
					rd.forward(request, response);
					break;
		case "1"://hacer el alta de la edicion
					String curso = request.getParameter("curso");
					String nombre = request.getParameter("nombreEdicion");
					boolean conCupos = request.getParameter("tieneCupos") != null;
					
					Integer cupos = 0;
					try {
						 cupos = Integer.parseInt(request.getParameter("cantidadCupos"));
					}catch(NumberFormatException e) {
						request.setAttribute("mensaje", "Valor incorrecto en Cupos");
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					Integer diaI = Integer.parseInt(request.getParameter("DiaI"));
					Integer mesI = Integer.parseInt(request.getParameter("MesI"));
					Integer anioI = Integer.parseInt(request.getParameter("AnioI"));
					DtFecha fechaI = new DtFecha(diaI, mesI, anioI);
					Integer diaF = Integer.parseInt(request.getParameter("DiaF"));
					Integer mesF = Integer.parseInt(request.getParameter("MesF"));
					Integer anioF = Integer.parseInt(request.getParameter("AnioF"));
					DtFecha fechaF = new DtFecha(diaF, mesF, anioF);
					Integer diaP = Integer.parseInt(request.getParameter("DiaP"));
					Integer mesP = Integer.parseInt(request.getParameter("MesP"));
					Integer anioP = Integer.parseInt(request.getParameter("AnioP"));
					DtFecha fechaP = new DtFecha(diaP, mesP, anioP);
					String[] profesores = request.getParameterValues("docentes");
					if (profesores==null)
					{
						request.setAttribute("mensaje", "No hay profesores ingresados.");
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					ArrayList<String> profes = new ArrayList<String>();
					for(String s: profesores) {
						profes.add(s);
					}

					try {
						String i = (String) sesion.getAttribute("institutoAltaEd");
						@SuppressWarnings("unused")
						List<DtCursoBase> noLosUso = seleccionarInstituto(i);
						altaEdicionCurso(curso, nombre, fechaI, fechaF, profes, conCupos, cupos, fechaP);
					} catch (Exception e) {
						request.setAttribute("mensaje", e.getMessage());
						rd = request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
					request.setAttribute("mensaje", "La edicion fue agregada con exito");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
					break;
		}
	}

	public List<DtCursoBase> seleccionarInstituto(String instituto) throws Exception {
		ControladorAltaEdicionCursoPublishService cps = new ControladorAltaEdicionCursoPublishServiceLocator();
		ControladorAltaEdicionCursoPublish port = cps.getControladorAltaEdicionCursoPublishPort();
		DtCursoBase[] cursos = port.seleccionarInstituto(instituto);
		List<DtCursoBase> retorno = new ArrayList<DtCursoBase>();
		for (int i = 0; i < cursos.length; ++i) {
		    retorno.add(cursos[i]);
		}
		return retorno;
	}
	
	public ArrayList<DtUsuarioBase> getDocentes() throws Exception {
		ControladorAltaEdicionCursoPublishService cps = new ControladorAltaEdicionCursoPublishServiceLocator();
		ControladorAltaEdicionCursoPublish port = cps.getControladorAltaEdicionCursoPublishPort();
		DtUsuarioBase[] profes = port.getDocentes();
		ArrayList<DtUsuarioBase> retorno = new ArrayList<DtUsuarioBase>();
		for (int i = 0; i < profes.length; ++i) {
		    retorno.add(profes[i]);
		}
		return retorno;
	}
	
	public ArrayList<DtUsuarioBase> getUsuarios() throws Exception{
		ControladorAltaEdicionCursoPublishService cps = new ControladorAltaEdicionCursoPublishServiceLocator();
		ControladorAltaEdicionCursoPublish port = cps.getControladorAltaEdicionCursoPublishPort();
		DtUsuarioBase[] users = port.getUsuarios();
		ArrayList<DtUsuarioBase> retorno = new ArrayList<DtUsuarioBase>();
		for (int i = 0; i < users.length; ++i) {
		    retorno.add(users[i]);
		}
		return retorno;
	}
	
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws Exception {
		ControladorAltaEdicionCursoPublishService cps = new ControladorAltaEdicionCursoPublishServiceLocator();
		ControladorAltaEdicionCursoPublish port = cps.getControladorAltaEdicionCursoPublishPort();		
		port.altaEdicionCurso(curso, nombre, fechaI, fechaF, docentes, tieneCupos, cupos, fechaPub);
		//problema con el ArrayList<String> de docentes
	}
}
