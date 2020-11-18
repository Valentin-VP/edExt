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
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorInstituto;

public class AltaEdicionCursoTest {
	private static Fabrica fabrica;
	private static IControladorAltaEdicionCurso icon;
	private static IControladorAltaCurso icon2;
	private static ManejadorInstituto mI;
	private static ManejadorCategoria mC;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaEdicionCurso();
		icon2 = fabrica.getIControladorAltaCurso();
		mI = ManejadorInstituto.getInstancia();
		mC = ManejadorCategoria.getInstancia();
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
	
	@Test
	public void test5_altaEdicionCursoUsuarioNoDocente() {
		
	}
	
	@Test
	public void test6_altaEdicionCursoEdicionRepetida() {
		
	}
	
	@Test
	public void test7_altaEdicionCurso() {
		
	}
	
	@Test
	public void test8_getUsuarios() {
		
	}
	
	@Test
	public void test9_getDocentes() {
		
	}
	
	@Test
	public void test10_docenteEnArray() {
		
	}
	
	@Test
	public void test11_verificarUsuarioUsuarioNoDocente() {
		
	}
	
	@Test
	public void test12_verificarUsuarioUsuarioNoExiste() {
		
	}
	
	@Test
	public void test13_verificarUsuarioDocenteYaAgregado() {
		
	}
	
	@Test
	public void test14_verificarUsuarioDocenteDeOtroInsituto() {
		
	}
	
	@Test
	public void test15_GetersYSeters() {
		
	}
}
