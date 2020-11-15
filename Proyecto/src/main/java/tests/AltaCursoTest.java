package tests;

import tests.Counter;
import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import logica.Categoria;
import logica.Curso;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorInstituto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaCursoTest {
	static Fabrica fabrica = null;
	static IControladorAltaCurso icon = null;
	static ManejadorCurso mC = null;
	static ManejadorInstituto mI = null;
	static ManejadorCategoria mCat = null;
	
	String nombre_curso_uno = "";
	String nombre_curso_dos = "";
	String nombre_instituto_uno = "instituto_uno_altaCurso";
	String nombre_instituto_dos = "instituto_dos_altaCurso";
	String nombre_categoria_uno = "categoria_uno_altaCurso";
	String nombre_categoria_dos = "categoria_dos_altaCurso";
	
	String descripcion_uno = "Desc curso uno";
	String descripcion_dos = "Desc curso dos";
	String duracion_uno = "1";
	String duracion_dos = "2";
	int cantHoras_uno = 0;
	int cantHoras_dos = 0;
	int creditos_uno = 0;
	int creditos_dos = 0;
	String url_uno = "www.curso_uno.com";
	String url_dos = "www.curso_dos.com";
	DtFecha fechaR_uno = null;
	DtFecha fechaR_dos= null;
	
	Curso c1 = null;
	Curso c2 = null;
	
	
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaCurso();
		mC = ManejadorCurso.getInstancia();
		mI = ManejadorInstituto.getInstancia();
		mCat = ManejadorCategoria.getInstancia();
				
	}
	
	@Before
	public void inicializarTest() {
		Counter counter1 = new Counter();
		this.nombre_curso_uno = "lightsaber_combat_" + counter1.getValue();
		this.fechaR_uno = new DtFecha(30,10,2020);
		this.fechaR_dos = new DtFecha(30,12,2020);
		this.nombre_curso_dos = "mind_trick_" + counter1.getValue();
	}
	
	@Test (expected = SinCategorias.class)
	public void test1_listarCategoriasNoExistenCategorias() throws SinCategorias{
		ArrayList<String> categoriasInexistentes = icon.listarCategorias();
	}
	
	@Test
	public void test2_crearYListarCategorias() throws SinCategorias {
		Counter counter = new Counter();
		Categoria categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		Categoria categoria_dos = new Categoria(nombre_categoria_dos+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		mCat.agregarCategoria(categoria_dos);
		ArrayList<String> categorias = icon.listarCategorias();
		icon.cleanCategorias();
		assertNotNull(categorias);
	}
	
	@Test (expected = InstitutoInexistente.class)
	public void test3_institutoNoExiste() throws CursoRepetido, InstitutoInexistente{
		Counter counter = new Counter();
		Categoria categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		icon.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		icon.altaCurso(nombre_instituto_uno, nombre_curso_uno, descripcion_uno, duracion_uno, cantHoras_uno, creditos_uno, url_uno, fechaR_uno);
	}
	
	@Test (expected = SinInstitutos.class)
	public void test4_listarInstitutosSinInstitutos() throws SinInstitutos {
		ArrayList<DtInstituto> institutos = icon.listarInstitutos();
	}
	
	@Test
	public void test5_crearUnCurso() throws CursoRepetido, InstitutoInexistente{
		Counter counter = new Counter();
		Instituto instituto_uno = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto_uno);	
		Categoria categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		icon.agregarCategoria(nombre_categoria_uno);
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno, descripcion_uno, duracion_uno, cantHoras_uno, creditos_uno, url_uno, fechaR_uno);
		icon.confirmarAltaCurso();
		Curso recuperado = mC.find(nombre_curso_uno);
		assertSame(nombre_curso_uno,recuperado.getNombre());
	}
	
	@Test
	public void test6_listarInstitutos() throws SinInstitutos {
		Counter counter = new Counter();
		Instituto instituto_uno = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto_uno);	
		ArrayList<DtInstituto> institutos = icon.listarInstitutos();
		assertNotNull(institutos);
	}
	
	
	@Test (expected = CursoRepetido.class)
	public void test7_altaCursoYaExiste() throws CursoRepetido, InstitutoInexistente{
		Counter counter = new Counter();
		Instituto instituto_uno = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto_uno);	
		Categoria categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		icon.agregarCategoria(nombre_categoria_uno);
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno, descripcion_uno, duracion_uno, cantHoras_uno, creditos_uno, url_uno, fechaR_uno);
		icon.confirmarAltaCurso();
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno, descripcion_uno, duracion_uno, cantHoras_uno, creditos_uno, url_uno, fechaR_uno);
		icon.confirmarAltaCurso();
	}
	
	@Test
	public void test8_crearCursoConPrevias() throws CursoRepetido, InstitutoInexistente{
		Counter counter = new Counter();
		Instituto instituto_uno = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto_uno);	
		Categoria categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		icon.agregarCategoria(nombre_categoria_uno);
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno, descripcion_uno, duracion_uno, cantHoras_uno, creditos_uno, url_uno, fechaR_uno);
		icon.confirmarAltaCurso();
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_dos, descripcion_dos, duracion_dos, cantHoras_dos, creditos_dos, url_dos, fechaR_dos);
		icon.agregarPrevia(nombre_curso_uno);
		icon.confirmarAltaCurso();
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString(), descripcion_dos, duracion_dos, cantHoras_dos, creditos_dos, url_dos, fechaR_dos);
		icon.agregarPrevia(nombre_curso_uno);
		icon.agregarPrevia(nombre_curso_dos);
		icon.confirmarAltaCurso();
		ArrayList<DtCursoBase> previasNulas = new ArrayList<DtCursoBase>();
		icon.setPrevias(previasNulas);
		List <Curso> previas = new ArrayList<>();
		previas.add(mC.find(nombre_curso_uno));
		previas.add(mC.find(nombre_curso_dos));
		Curso recuperadoConPrevias = mC.find(nombre_curso_dos+counter.getValue().toString());
		assertSame(recuperadoConPrevias.getPrevias().get(0), previas.get(0));
	}
	
	@Test
	public void test9_gettersAndSetters() throws CursoRepetido, InstitutoInexistente {
		Counter counter = new Counter();
		Instituto instituto_uno = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto_uno);	
		Categoria categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		icon.agregarCategoria(nombre_categoria_uno);
		icon.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno, descripcion_uno, duracion_uno, cantHoras_uno, creditos_uno, url_uno, fechaR_uno);
		icon.confirmarAltaCurso();
	}
}
