package tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtFecha;
import datatypes.DtUsuarioBase;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.DocenteDeOtroInstituto;
import excepciones.DocenteYaAgregado;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoRepetidoException;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioNoExiste;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaInstituto;
import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Edicion;
import logica.Estudiante;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import logica.Usuario;

public class AltaEdicionCursoTest {
	private static Fabrica fabrica;
	private static IControladorAltaEdicionCurso icon;
	private static IControladorAltaCurso icon2;
	private static ManejadorInstituto mI;
	private static ManejadorCategoria mC;
	private static ManejadorEdicion mE;
	//private static ManejadorCurso mK;
	private static ManejadorUsuario mU;
	
	private Instituto i3 = null;
	private Categoria cat3 = null;
	private Curso c3 = null;
	private Edicion edi = null;
	
	private Instituto i4 = null;
	private Categoria cat4 = null;
	private Curso c4 = null;
	private Usuario u4 = null;
	
	private Usuario u5 = null;
	
	private Usuario u6 = null;
	private Instituto i6 = null;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaEdicionCurso();
		icon2 = fabrica.getIControladorAltaCurso();
		mI = ManejadorInstituto.getInstancia();
		mC = ManejadorCategoria.getInstancia();
		mE = ManejadorEdicion.getInstancia();
		//mK = ManejadorCurso.getInstancia();
		mU = ManejadorUsuario.getInstancia();
		
	}
	
	/*@Before
	public void inicializarTest() throws ParseException {
		
	}*/
	
	@Test(expected = InstitutoInexistente.class)
	public void test1_seleccionarInstitutoInstitutoInexistente() throws InstitutoInexistente {
		List<DtCursoBase> cursos = icon.seleccionarInstituto("");
	}
	
	@Test(expected = InstitutoInexistente.class)
	public void test2_altaEdicionCursoInstitutoInexistente() throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente {
		Counter contador = new Counter();
		String nombre_instituto2 = "ThanosAcademy" + contador.getValue().toString();
		icon.setInstituto(nombre_instituto2);
		icon.altaEdicionCurso("", "", null, null, null, false, null, null);
	}
	
	@Test
	public void test3_seleccionarInstituto() throws CursoRepetido, InstitutoInexistente, ParseException {
		Counter contador = new Counter();
		String nombre_instituto1 = "AvengersAcademy" + contador.getValue().toString();
		String nombre_categoria1 = "Punteria" + contador.getValue().toString();
		String nombre_curso1 = "curso1_Avengers" + contador.getValue().toString();
		String nombre_curso2 = "curso2_Avengers" + contador.getValue().toString();
		String descripcion_curso1 = "desc_c1" + contador.getValue().toString();
		String descripcion_curso2 = "desc_c2" + contador.getValue().toString();
		String duracion_curso1 = "5";
		String duracion_curso2 = "6";
		String url_curso1 = "algo.com" + contador.getValue().toString();
		String url_curso2 = "otroAlgo.com" + contador.getValue().toString();
		int cantHoras_curso1 = 10;
		int cantHoras_curso2 = 10;
		Integer creditos_curso1 = 20;
		Integer creditos_curso2 = 20;
		DtFecha fechaR_curso1 = new DtFecha(10, 10, 1998);
		DtFecha fechaR_curso2 = new DtFecha(11, 11, 1999);
		Date fecha_curso1 = fechaR_curso1.DtFechaToDate();
		Date fecha_curso2 = fechaR_curso2.DtFechaToDate();
		Instituto i1 = new Instituto(nombre_instituto1);
		mI.agregarInstituto(i1);
		icon2.altaCurso(nombre_instituto1, nombre_curso1, descripcion_curso1, duracion_curso1, cantHoras_curso1, creditos_curso1, url_curso1, fechaR_curso1);
		icon2.confirmarAltaCurso();
		icon2.altaCurso(nombre_instituto1, nombre_curso2, descripcion_curso2, duracion_curso2, cantHoras_curso2, creditos_curso2, url_curso2, fechaR_curso2);
		icon2.confirmarAltaCurso();
		Categoria cat1 = new Categoria(nombre_categoria1);
		mC.agregarCategoria(cat1);
		List<Categoria> cats = new ArrayList<Categoria>();
		cats.add(cat1);
		List<Curso> previas = new ArrayList<Curso>();
		Curso c1 = new Curso(nombre_curso1, descripcion_curso1, duracion_curso1, cantHoras_curso1, creditos_curso1, fecha_curso1, url_curso1, null, cats);
		previas.add(c1);
		Curso c2 = new Curso(nombre_curso2, descripcion_curso2, duracion_curso2, cantHoras_curso2, creditos_curso2, fecha_curso2, url_curso2, previas, cats);
		i1.agregarCurso(c1);
		i1.agregarCurso(c2);
		List<DtCursoBase> retorno = icon.seleccionarInstituto(nombre_instituto1);
	}
	
	@Test(expected = CursoNoExiste.class)
	public void test4_altaEdicionCursoCursoNoExiste() throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente {
		icon.altaEdicionCurso("", "", null, null, null, false, null, null);
	}
	
	@Test(expected = EdicionRepetida.class)
	public void test5_altaEdicionCursoEdicionRepetida() throws ParseException, CursoRepetido, InstitutoInexistente, EdicionRepetida, CursoNoExiste, UsuarioNoDocente, InstitutoRepetidoException {
		Counter contador = new Counter();
		DtFecha fechaR_curso3 = new DtFecha(10, 10, 1998);
		Date fecha_curso3 = fechaR_curso3.DtFechaToDate();
		
		this.i3 = new Instituto("StarkAcademy" + contador.getValue());
		mI.agregarInstituto(i3);
		
		this.cat3 = new Categoria("Estrategia" + contador.getValue());
		mC.agregarCategoria(cat3);
		
		List<Categoria> categs = new ArrayList<Categoria>();
		categs.add(cat3);
		
		this.c3 = new Curso("curso3", "estrategia3", "5", 10, 60, fecha_curso3, "curso3.com", null, categs);
		icon2.altaCurso(this.i3.getNombre(), this.c3.getNombre(), this.c3.getDescripcion(), this.c3.getDuracion(), this.c3.getCantHoras(), this.c3.getCreditos(), this.c3.getUrl(), fechaR_curso3);
		icon2.confirmarAltaCurso();
		//mK.agregarCurso(c3);
		//i3.agregarCurso(c3);
		
		DtFecha fechaI_edicion = new DtFecha(10, 10, 1997);
		DtFecha fechaF_edicion = new DtFecha(11, 11, 1998);
		DtFecha fechaP_edicion = new DtFecha(12, 12, 1999);
		Date fechaI = fechaI_edicion.DtFechaToDate();
		Date fechaF = fechaF_edicion.DtFechaToDate();
		Date fechaP = fechaP_edicion.DtFechaToDate();
		this.edi = new Edicion("edicion3", fechaI, fechaF, true, 400, fechaP);
		this.c3.addEdicion(edi);
		mE.agregarEdicion(edi);
		
		/*for(Curso cu: mK.getCursos()) {
			System.out.println(cu.getNombre());
		}
		
		System.out.println(mE.getEdiciones().size());
		for(Edicion ed: mE.getEdiciones()) {
			System.out.println(ed.getNombre());
		}*/
		
		icon.setInstituto(i3.getNombre());
		icon.setCurso(c3.getNombre());
		icon.altaEdicionCurso(this.c3.getNombre(), this.edi.getNombre(), fechaI_edicion, fechaF_edicion, null, true, 400, fechaP_edicion);
	}
	
	@Test
	public void test6_altaEdicionCurso() throws CursoRepetido, InstitutoInexistente, ParseException, EdicionRepetida, CursoNoExiste, UsuarioNoDocente {
		Counter contador = new Counter();
		DtFecha fechaR_curso4 = new DtFecha(10, 10, 1998);
		Date fecha_curso4 = fechaR_curso4.DtFechaToDate();
		DtFecha fechaUser = new DtFecha(10, 10, 1999);
		Date fechau = fechaUser.DtFechaToDate();
		
		this.i4 = new Instituto("EvansAcademy" + contador.getValue());
		mI.agregarInstituto(i4);
		
		this.cat4 = new Categoria("Escudo" + contador.getValue());
		mC.agregarCategoria(cat4);
		
		List<Categoria> categs = new ArrayList<Categoria>();
		categs.add(cat4);
		
		this.c4 = new Curso("curso4", "escudo4", "5", 10, 60, fecha_curso4, "curso4.com", null, categs);
		icon2.altaCurso(this.i4.getNombre(), this.c4.getNombre(), this.c4.getDescripcion(), this.c4.getDuracion(), this.c4.getCantHoras(), this.c4.getCreditos(), this.c4.getUrl(), fechaR_curso4);
		icon2.confirmarAltaCurso();
		
		ArrayList<String> profes = new ArrayList<String>();
		this.u4 = new Docente("Capi", "Steve", "Rogers", "capi@algo.com", fechau, i4, "capiRules");
		mU.agregarUsuario(this.u4);
		profes.add(this.u4.getNick());
		
		DtFecha fechaI_edicion = new DtFecha(10, 10, 1997);
		DtFecha fechaF_edicion = new DtFecha(11, 11, 1998);
		DtFecha fechaP_edicion = new DtFecha(12, 12, 1999);
		icon.setInstituto(i4.getNombre());
		icon.setCurso(c4.getNombre());
		icon.altaEdicionCurso(this.c4.getNombre(), "edicion4", fechaI_edicion, fechaF_edicion, profes, true, 400, fechaP_edicion);
	}

	
	@Test
	public void test7_getUsuarios() {
		ArrayList<DtUsuarioBase> losUsers = icon.getUsuarios();
	}
	
	@Test(expected = UsuarioNoDocente.class)
	public void test8_verificarUsuarioUsuarioNoDocente() throws ParseException, UsuarioNoExiste, UsuarioNoDocente, DocenteDeOtroInstituto, DocenteYaAgregado {
		//Counter contador = new Counter();
		DtFecha fechaUser = new DtFecha(10, 10, 1999);
		Date fechau = fechaUser.DtFechaToDate();
		
		this.u5 = new Estudiante("Manu", "Manuel", "Yo", "yo@algo.com", fechau, "manuRules");
		mU.agregarUsuario(this.u5);
		
		icon.verificarUsuario(this.u5.getNick(), this.u5.getCorreo(), null);
	}
	
	@Test(expected = UsuarioNoExiste.class)
	public void test9_verificarUsuarioUsuarioNoExiste() throws UsuarioNoExiste, UsuarioNoDocente, DocenteDeOtroInstituto, DocenteYaAgregado {
		icon.verificarUsuario("noExisteEsteUsuario", "", null);
	}
	
	@Test(expected = DocenteYaAgregado.class)
	public void test10_verificarUsuarioDocenteYaAgregado() throws ParseException, UsuarioNoExiste, UsuarioNoDocente, DocenteDeOtroInstituto, DocenteYaAgregado {
		Counter contador = new Counter();
		DtFecha fechaUser = new DtFecha(10, 10, 1999);
		Date fechau = fechaUser.DtFechaToDate();
		
		this.i6 = new Instituto("PanterInstitute" + contador.getValue());
		mI.agregarInstituto(i6);
		
		ArrayList<String> profes = new ArrayList<String>();
		this.u6 = new Docente("Vale", "Valentin", "Aquel", "aquel@algo.com", fechau, i6, "valeRules");
		mU.agregarUsuario(this.u6);
		profes.add(this.u6.getNick());
		
		icon.setInstituto(i6.getNombre());
		icon.verificarUsuario(this.u6.getNick(), this.u6.getCorreo(), profes);
	}
	
	@Test
	public void GetersYSeters() {
		icon.setCurso("chanchuyo");
		icon.getCurso();
		icon.setCupos(45);
		icon.getCupos();
		icon.setTieneCupos(false);
		icon.isTieneCupos();
		DtEdicion dtEdi = new DtEdicion();
		icon.setDtEdi(dtEdi);
		icon.getDtEdi();
	}
}
