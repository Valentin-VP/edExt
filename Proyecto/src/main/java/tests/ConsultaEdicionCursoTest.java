package tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.InstitutoInexistente;
import excepciones.CategoriaInexistente;
import excepciones.CursoNoExiste;

import static org.junit.Assert.*;

import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;

public class ConsultaEdicionCursoTest {
	static Fabrica fabrica;
	static IControladorConsultaEdicionCurso icon;
	static ManejadorEdicion mE;
	static ManejadorInstituto mI;
	static ManejadorCategoria mC;
	static ManejadorCurso mK;
	
	Instituto instituto1 = null;
	Categoria categoria1 = null;
	Categoria categoria2 = null;
	Curso curso1 = null;
	Curso curso2 = null;
	Curso previa_curso1 = null;
	Curso previa_curso2 = null;
	Edicion edicion_curso1 = null;

	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaEdicionCurso();
		mE = ManejadorEdicion.getInstancia();
		mI = ManejadorInstituto.getInstancia();
		mC = ManejadorCategoria.getInstancia();
		mK = ManejadorCurso.getInstancia();
	}
	
	@Before
	public void inicializarTest() throws ParseException {
		Counter contador = new Counter();
		
		this.instituto1 = new Instituto("instituto_uno_consultaEdicion" + contador.getValue());
		
		this.categoria1 = new Categoria("categoria_uno_consultaEdicion" + contador.getValue());
		this.categoria2 = new Categoria("categoria_dos_consultaEdicion" + contador.getValue());
		List<Categoria> cats = new ArrayList<Categoria>();
		cats.add(this.categoria1);
		cats.add(this.categoria2);
		
		DtFecha fechaR = new DtFecha(10, 10, 1869);
		List<Curso> previasCurso1 = new ArrayList<Curso>();
		List<Curso> previasCurso2 = new ArrayList<Curso>();
		this.previa_curso1 = new Curso("previaCurso1", "tampocoimporta", "7", 5, 10, fechaR.DtFechaToDate(), "algomas", null, cats);
		previasCurso1.add(this.previa_curso1);
		this.previa_curso2 = new Curso("previaCurso2", "tampocose", "8", 7, 12, fechaR.DtFechaToDate(), "otroalgomas", null, cats);
		previasCurso2.add(this.previa_curso2);
		this.curso1 = new Curso("Fuerza", "noimporta", "7", 5, 10, fechaR.DtFechaToDate(), "algo", previasCurso1, cats);
		this.curso2 = new Curso("Agilidad", "nose", "8", 7, 12, fechaR.DtFechaToDate(), "otroalgo", previasCurso2, cats);
		
		this.instituto1.agregarCurso(curso1);
		this.instituto1.agregarCurso(previa_curso1);
		
		Date fechaI = new DtFecha(10, 10, 1997).DtFechaToDate();
		Date fechaF = new DtFecha(11, 11, 1998).DtFechaToDate();
		Date fechaP = new DtFecha(12, 12, 1999).DtFechaToDate();
		this.edicion_curso1 = new Edicion("Fuerza2020", fechaI, fechaF, false, 0, fechaP);
		this.curso1.addEdicion(edicion_curso1);
	}
	
	@Test(expected = InstitutoInexistente.class)
	public void test1_seleccionarInstitutoInstitutoInexistente() throws InstitutoInexistente {
		ArrayList<DtCursoBase> dtcb = icon.seleccionarInstituto("");
	}
	
	@Test
	public void test2_seleccionarInstituto() throws InstitutoInexistente {
		mI.agregarInstituto(instituto1);
		ArrayList<DtCursoBase> dtcb = icon.seleccionarInstituto(this.instituto1.getNombre());
	}
	
	@Test(expected = CategoriaInexistente.class)
	public void test3_seleccionarCategoriaCategoriaInexistente() throws CategoriaInexistente {
		ArrayList<DtCursoBase> dtcb = icon.seleccionarCategoria("");
	}
	
	@Test
	public void test4_seleccionarCategoria() throws CategoriaInexistente {
		mC.agregarCategoria(categoria1);
		ArrayList<DtCursoBase> dtcb = icon.seleccionarCategoria(categoria1.getNombre());
	}
	
	@Test(expected = CursoNoExiste.class)
	public void test5_seleccionarCursoCursoInexistente() throws CursoNoExiste {
		ArrayList<DtEdicionBase> dtcb = icon.seleccionarCurso("");
	}
	
	@Test
	public void test6_seleccionarCurso() throws CursoNoExiste {
		ArrayList<DtEdicionBase> dtcb = icon.seleccionarCurso(this.curso1.getNombre());
	}
	
	@Test
	public void test7_seleccionarEdicion() {
		DtEdicion dte = icon.seleccionarEdicion(this.edicion_curso1.getNombre());//se rompe en el controlador(convirtiendo el DtFecha a Date)
	}
	
	@Test
	public void test8_getDocentes() {
		ArrayList<String> dte = icon.getDocentes(this.edicion_curso1.getNombre());
	}
	
	@Test
	public void test_9getDtEdicion() {
		DtEdicion dted = icon.getDtEdicion(this.edicion_curso1.getNombre());
	}
	
	@Test
	public void test10_getInstitutosConCurso() {
		ArrayList<DtInstituto> dte = icon.getInstitutosConCurso(curso1.getNombre());
	}
	
	@Test
	public void test11_getNombreCurso() {
		String cursoInstituto = curso1.getNombre() + "-" + instituto1.getNombre();
		String nombresSeparados = icon.getNombreCurso(cursoInstituto);
	}
	
	@Test
	public void test12_GetersYSeters() {
		icon.setEdicion("edicionRelleno");
		String e = icon.getEdicion();
		icon.setInstituto("institutoRelleno");
		String i = icon.getInstituto();
		icon.setCurso("cursoRelleno");
		String c = icon.getCurso();
		icon.setCategoria("categoriaRelleno");
		String cat = icon.getCategoria();
	}
}
