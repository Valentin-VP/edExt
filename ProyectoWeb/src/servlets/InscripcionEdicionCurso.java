package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
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
import javax.xml.rpc.ServiceException;

import com.google.gson.Gson;

import publicadores.DtCursoBase;
import publicadores.DtEdicionBase;
import publicadores.DtFecha;
import publicadores.DtInstituto;
import publicadores.CursoNoExiste;
import publicadores.EdicionVigenteNoExiste;
import publicadores.InscripcionEdRepetido;
import publicadores.SinInstitutos;
import publicadores.UsuarioNoExiste;
//import interfaces.Fabrica;
//import interfaces.IControladorInscripcionEdicionCurso;
import publicadores.ControladorInscripcionEdicionPublish;
import publicadores.ControladorInscripcionEdicionPublishService;
import publicadores.ControladorInscripcionEdicionPublishServiceLocator;

@WebServlet("/InscripcionEdicionCurso")
public class InscripcionEdicionCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InscripcionEdicionCurso() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Fabrica fabrica = Fabrica.getInstancia();
		//IControladorInscripcionEdicionCurso icon = fabrica.getIControladorInscripcionEdicionCurso();
		List<DtInstituto> institutos = new ArrayList<DtInstituto>();
		try {
			institutos = listarInstitutos();
		} catch (SinInstitutos | ServiceException e) {
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
		//Fabrica fabrica = Fabrica.getInstancia();
		//IControladorInscripcionEdicionCurso icon = fabrica.getIControladorInscripcionEdicionCurso();
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
				cursos = seleccionarInstituto(ins);
			} catch (CursoNoExiste | ServiceException e) {
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
			System.out.println(curso);
		
			
			DtEdicionBase dteb = new DtEdicionBase();
			try {
				dteb = seleccionarCurso(curso);
			} catch (ServiceException | RemoteException e) {
				request.setAttribute("mensaje", "No existe edicion vigente");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			try {
				registrarInscripcionEd(nick, correo, curso, fecha);
				confirmar();
			} catch (ServiceException | RemoteException e) {
				request.setAttribute("mensaje", "Ya esta inscripto a la edicion");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				//System.out.print("El mensaje es: " + e.getMessage());
			}
			try {
				cancelar();
			} catch (ServiceException e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
			
			request.setAttribute("mensaje", "La inscripcion a la edicion "+ dteb.getNombre() +" se realizo correctamente");
			rd = request.getRequestDispatcher("/notificacion.jsp");
			rd.forward(request, response);
			
		}
		
	}
	
	public List<DtInstituto> listarInstitutos() throws SinInstitutos, ServiceException, RemoteException {
		ControladorInscripcionEdicionPublishService cps = new ControladorInscripcionEdicionPublishServiceLocator();
		ControladorInscripcionEdicionPublish port = cps.getControladorInscripcionEdicionPublishPort();
		DtInstituto[] institutos = port.listarInstitutos();
		List<DtInstituto> retorno = new ArrayList<DtInstituto>();
		for (int i = 0; i < institutos.length; i++) {
		    retorno.add(institutos[i]);
		}
		return retorno;
	}
	
	public ArrayList<DtCursoBase> seleccionarInstituto(String nomIns) throws CursoNoExiste, ServiceException, RemoteException{
		ControladorInscripcionEdicionPublishService cps = new ControladorInscripcionEdicionPublishServiceLocator();
		ControladorInscripcionEdicionPublish port = cps.getControladorInscripcionEdicionPublishPort();
		DtCursoBase[] cursos = port.seleccionarInstituto(nomIns);
		ArrayList<DtCursoBase> retorno = new ArrayList<DtCursoBase>();
		for (int i = 0; i < cursos.length; i++) {
		    retorno.add(cursos[i]);
		}
		return retorno;
	}
	
	public DtEdicionBase seleccionarCurso(String nomCurso) throws ServiceException, RemoteException{
		ControladorInscripcionEdicionPublishService cps = new ControladorInscripcionEdicionPublishServiceLocator();
		ControladorInscripcionEdicionPublish port = cps.getControladorInscripcionEdicionPublishPort();
		return port.seleccionarCurso(nomCurso);
	}
	
	public void registrarInscripcionEd(String nick, String correo, String nomCurso, DtFecha fecha) throws ServiceException, RemoteException{
		ControladorInscripcionEdicionPublishService cps = new ControladorInscripcionEdicionPublishServiceLocator();
		ControladorInscripcionEdicionPublish port = cps.getControladorInscripcionEdicionPublishPort();
		port.registrarInscripcionEd(nick, correo, nomCurso, fecha);
	}
	
	public void cancelar() throws ServiceException, RemoteException {
		ControladorInscripcionEdicionPublishService cps = new ControladorInscripcionEdicionPublishServiceLocator();
		ControladorInscripcionEdicionPublish port = cps.getControladorInscripcionEdicionPublishPort();
		port.cancelar();
	}
	
	public void confirmar() throws InscripcionEdRepetido, EdicionVigenteNoExiste, UsuarioNoExiste, ServiceException, RemoteException{
		ControladorInscripcionEdicionPublishService cps = new ControladorInscripcionEdicionPublishServiceLocator();
		ControladorInscripcionEdicionPublish port = cps.getControladorInscripcionEdicionPublishPort();
		port.confirmar();
	}
	
}
