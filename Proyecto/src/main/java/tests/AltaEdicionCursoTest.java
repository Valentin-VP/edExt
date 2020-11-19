package tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicionCurso;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;

public class AltaEdicionCursoTest {
	private static Fabrica fabrica;
	private static IControladorAltaEdicionCurso icon;
	private static IControladorAltaCurso icon2;
	private static ManejadorInstituto mI;
	private static ManejadorCategoria mC;
	private static ManejadorEdicion mE;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaEdicionCurso();
		icon2 = fabrica.getIControladorAltaCurso();
		mI = ManejadorInstituto.getInstancia();
		mC = ManejadorCategoria.getInstancia();
		mE = ManejadorEdicion.getInstancia();
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
	public void test5_altaEdicionCursoEdicionRepetida() throws ParseException, CursoRepetido, InstitutoInexistente, EdicionRepetida, CursoNoExiste, UsuarioNoDocente {
		Counter contador2 = new Counter();
		String nombre_instituto3 = "StarkAcademy" + contador2.getValue().toString();
		String nombre_categoria3 = "Estrategia" + contador2.getValue().toString();
		String nombre_curso3 = "curso3_Stark" + contador2.getValue().toString();
		String nombre_curso4 = "curso4_Stark" + contador2.getValue().toString();
		String descripcion_curso3 = "desc_c3" + contador2.getValue().toString();
		String descripcion_curso4 = "desc_c4" + contador2.getValue().toString();
		String duracion_curso3 = "5";
		String duracion_curso4 = "6";
		String url_curso3 = "algomas.com" + contador2.getValue().toString();
		String url_curso4 = "otroAlgo.com" + contador2.getValue().toString();
		int cantHoras_curso3 = 15;
		int cantHoras_curso4 = 30;
		Integer creditos_curso3 = 25;
		Integer creditos_curso4 = 40;
		DtFecha fechaR_curso3 = new DtFecha(10, 10, 1998);
		DtFecha fechaR_curso4 = new DtFecha(11, 11, 1999);
		Date fecha_curso3 = fechaR_curso3.DtFechaToDate();
		Date fecha_curso4 = fechaR_curso4.DtFechaToDate();
		Instituto i3 = new Instituto(nombre_instituto3);
		mI.agregarInstituto(i3);
		icon2.altaCurso(nombre_instituto3, nombre_curso3, descripcion_curso3, duracion_curso3, cantHoras_curso3, creditos_curso3, url_curso3, fechaR_curso3);
		icon2.confirmarAltaCurso();
		icon2.altaCurso(nombre_instituto3, nombre_curso4, descripcion_curso4, duracion_curso4, cantHoras_curso4, creditos_curso4, url_curso4, fechaR_curso4);
		icon2.confirmarAltaCurso();
		Categoria cat3 = new Categoria(nombre_categoria3);
		mC.agregarCategoria(cat3);
		List<Categoria> categs = new ArrayList<Categoria>();
		categs.add(cat3);
		List<Curso> previas2 = new ArrayList<Curso>();
		Curso c3 = new Curso(nombre_curso3, descripcion_curso3, duracion_curso3, cantHoras_curso3, creditos_curso3, fecha_curso3, url_curso3, null, categs);
		previas2.add(c3);
		Curso c4 = new Curso(nombre_curso4, descripcion_curso4, duracion_curso4, cantHoras_curso4, creditos_curso4, fecha_curso4, url_curso4, previas2, categs);
		i3.agregarCurso(c3);
		i3.agregarCurso(c4);
		icon.setInstituto(nombre_instituto3);
		String nombre_edicion3 = "edicion_2020" + contador2.getValue().toString();
		DtFecha fecha_inicio = new DtFecha(10, 10, 1997);
		DtFecha fecha_fin = new DtFecha(11, 11, 1998);
		DtFecha fecha_pub = new DtFecha(12, 12, 1999);
		/*Date fechaI = fecha_inicio.DtFechaToDate();
		Date fechaF = fecha_fin.DtFechaToDate();
		Date fechaP = fecha_pub.DtFechaToDate();*/
		boolean tieneCupos_edicion3 = false;
		Integer cupos_edicion3 = 0;
		//Edicion edicion3 = new Edicion(nombre_edicion3, fechaI, fechaF, tieneCupos_edicion3, cupos_edicion3, fechaP);
		//mE.agregarEdicion(edicion3);
		icon.altaEdicionCurso(nombre_curso4, nombre_edicion3, fecha_inicio, fecha_fin, null, tieneCupos_edicion3, cupos_edicion3, fecha_pub);
		icon.altaEdicionCurso(nombre_curso4, nombre_edicion3, fecha_inicio, fecha_fin, null, tieneCupos_edicion3, cupos_edicion3, fecha_pub);
	}
	
	@Test
	public void test6_altaEdicionCurso() {
		
	}
	
	@Test
	public void test7_getUsuarios() {
		
	}
	
	@Test
	public void test8_getDocentes() {
		
	}
	
	@Test
	public void test9_docenteEnArray() {
		
	}
	
	@Test
	public void test10_verificarUsuarioUsuarioNoDocente() {
		
	}
	
	@Test
	public void test11_verificarUsuarioUsuarioNoExiste() {
		
	}
	
	@Test
	public void test12_verificarUsuarioDocenteYaAgregado() {
		
	}
	
	@Test
	public void test13_verificarUsuarioDocenteDeOtroInsituto() {
		
	}
	
	@Test
	public void test14_GetersYSeters() {
		
	}
}
