package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoEstudiante;
import excepciones.UsuarioNoExiste;
import interfaces.Fabrica;
import interfaces.IControladorInscripcionEdicionCurso;

@WebServlet("/InscripcionEdicionCurso")
public class InscripcionEdicionCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InscripcionEdicionCurso() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorInscripcionEdicionCurso icon = fabrica.getIControladorInscripcionEdicionCurso();
		List<DtInstituto> institutos = new ArrayList<DtInstituto>();
		try {
			institutos = icon.listarInstitutos();
		} catch (SinInstitutos e) {
			e.printStackTrace();
		}
		
		//Ejemplo con Lista de Objetos JSON funcionando
		//Returning List<Entity> as JSON
		List<DtInstituto> products = institutos;
		String json = new Gson().toJson(products);
		// Gson es una clase de google que permite convertir en objetos JSON
		// La dependencia de Maven esta incluida en el POM
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);		
		
		// Ejemplo con lista de String funcionando
		/*Returning List<String> as JSON
		List<String> list = new ArrayList<>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		String json = new Gson().toJson(list);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		*/
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorInscripcionEdicionCurso icon = fabrica.getIControladorInscripcionEdicionCurso();
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick");
		String correo = (String) sesion.getAttribute("correo");
		LocalDate hoy = LocalDate.now();
		DtFecha fecha = new DtFecha(hoy.getDayOfMonth(),hoy.getMonthValue(),hoy.getYear());
		RequestDispatcher rd;
		
		// Comparo si es una request de AJAX o una request normal
		boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

		if (ajax) { // Es una request de AJAX
			
			String ins = request.getParameter("institutoselect");
			ArrayList<DtCursoBase> cursos = new ArrayList<>();
			try {
				cursos = icon.seleccionarInstituto(ins);
			} catch (CursoNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			
			// Ejemplo con lista de String funcionando
			//Returning List<String> as JSON
			List<String> strcursos = new ArrayList<String>();
			for(DtCursoBase dtcb:cursos) {
				strcursos.add(dtcb.getNombre());
			}
			
			String json = new Gson().toJson(strcursos);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			
		    // Devuelve un String
			//String name = request.getParameter("name");
			//response.getWriter().print("Hello "+ name + "!!");
		}
		else { // Sino es una request normal
			
			String instituto = request.getParameter("selectInstitutos");
			String curso = request.getParameter("selectCursos");
			System.out.println("\n"+nick);
			System.out.println(correo);
			System.out.println(instituto);
			System.out.print(curso);
			
			@SuppressWarnings("unused")
			ArrayList<DtInstituto> institutos = new ArrayList<>();
			
			try {
				institutos = icon.listarInstitutos();
			} catch (SinInstitutos e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			
			@SuppressWarnings("unused")
			ArrayList<DtCursoBase> cursos = new ArrayList<>();
			try {
				cursos = icon.seleccionarInstituto(instituto);
			} catch (CursoNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			DtEdicionBase dteb = new DtEdicionBase();
			try {
				dteb = icon.seleccionarCurso(curso);
			} catch (EdicionVigenteNoExiste e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			try {
				icon.registrarInscripcionEd(nick, correo, curso, fecha);
			} catch (InscripcionEdRepetido | UsuarioNoExiste | UsuarioNoEstudiante e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			icon.confirmar();
			icon.cancelar();
			
			request.setAttribute("mensaje", "La inscripcion a la edicion"+ dteb.getNombre() +"se realizo correctamente");
			rd = request.getRequestDispatcher("/notificacion.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
