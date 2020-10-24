package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		String tipo = (String) sesion.getAttribute("tipo");
		String nick = (String) sesion.getAttribute("nick");
		String correo = (String) sesion.getAttribute("correo");
		String instituto = (String) request.getAttribute("instituto");
		String curso = (String) request.getAttribute("curso");
		LocalDate hoy = LocalDate.now();
		DtFecha fecha = new DtFecha(hoy.getDayOfMonth(),hoy.getMonthValue(),hoy.getYear());
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorInscripcionEdicionCurso icon = fabrica.getIControladorInscripcionEdicionCurso();
		ArrayList<DtInstituto> institutos = new ArrayList<>();
		try {
			institutos = icon.listarInstitutos();
		} catch (SinInstitutos e) {
			e.printStackTrace();
		}
		ArrayList<DtCursoBase> cursos = new ArrayList<>();
		try {
			cursos = icon.seleccionarInstituto(instituto);
		} catch (CursoNoExiste e) {
			e.printStackTrace();
		}
		DtEdicionBase dteb = new DtEdicionBase();
		try {
			dteb = icon.seleccionarCurso(curso);
		} catch (EdicionVigenteNoExiste e) {
			e.printStackTrace();
		}
		try {
			icon.registrarInscripcionEd(nick, correo, curso, fecha);
		} catch (InscripcionEdRepetido | UsuarioNoExiste | UsuarioNoEstudiante e) {
			e.printStackTrace();
		}
		icon.confirmar();
		icon.cancelar();
		
		doGet(request, response);
	}

}
