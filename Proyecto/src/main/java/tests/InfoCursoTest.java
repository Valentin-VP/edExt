package tests;

import tests.Counter;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorConsultaCurso;
import logica.Categoria;
import logica.Curso;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorInstituto;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InfoCursoTest {
	
	static Fabrica fabrica = null;
	static IControladorConsultaCurso icon = null;
	static IControladorAltaCurso iconAC = null;
	static ManejadorCurso mC = null;
	static ManejadorInstituto mI = null;
	static ManejadorCategoria mCat = null;
	
	String nombreInstitutoUno;
	String nombreCategoriaUno;
	String nombreCursoUno;
	String nombreCursoDos;
	String nombreEdicionUno;
	String nombreEdicionDos;
	String descripcion = "descripcion";
	String duracion = "50";
	int cantHoras = 10;
	int creditos = 13;
	DtFecha fechaR = new DtFecha(17,11,2020);
	String url = "www.starkinstitutes.com";
	ArrayList<DtCursoBase> previas = new ArrayList<DtCursoBase>();
	List<Categoria> categorias = new ArrayList<Categoria>();
	private Instituto institutoUno;
	Categoria categoriaUno;
	Counter counter = new Counter();
	
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaCurso();
		iconAC = fabrica.getIControladorAltaCurso();
		mI = ManejadorInstituto.getInstancia();
		mC = ManejadorCurso.getInstancia();
		mCat = ManejadorCategoria.getInstancia();
	}
	
	@Test
	public void inicializarTest() {
	}
	
	@Test (expected = InstitutoInexistente.class)
	public void test1_listarCursosInstitutoNoExiste() throws InstitutoInexistente, InstitutoSinCursos{
		icon.listarCursosInstituto("EsteInstitutoNoExiste");
	}
	
	@Test (expected = InstitutoSinCursos.class)
	public void test2_listarCursosInstitutoSinCursos() throws InstitutoInexistente, InstitutoSinCursos{
		this.nombreInstitutoUno = "institutoUnoInfoCurso" + this.counter.getValue().toString();
		this.institutoUno = new Instituto(this.nombreInstitutoUno);
		mI.agregarInstituto(this.institutoUno);
		icon.listarCursosInstituto(this.nombreInstitutoUno);
	}
	
	@Test 
	public void test3_listarCursosInstituto() throws InstitutoInexistente, InstitutoSinCursos, CursoRepetido{
		this.nombreCategoriaUno = "categoriaUnoInfoCurso" + counter.getValue().toString();
		this.categoriaUno = new Categoria(this.nombreCategoriaUno);
		mCat.agregarCategoria(this.categoriaUno);
		iconAC.agregarCategoria(this.nombreCategoriaUno);
		this.nombreCursoUno = "cursoUnoInfoCurso" + counter.getValue().toString();
		this.nombreInstitutoUno = "institutoUnoInfoCurso" + this.counter.getValue().toString();
		this.institutoUno = new Instituto(this.nombreInstitutoUno);
		mI.agregarInstituto(this.institutoUno);
		iconAC.altaCurso(this.nombreInstitutoUno, this.nombreCursoUno, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.confirmarAltaCurso();
		icon.listarCursosInstituto(this.nombreInstitutoUno);
	}
	
	@Test
	public void test4_consultarCurso() throws CursoRepetido, InstitutoInexistente {
		this.nombreCategoriaUno = "categoriaUnoInfoCurso" + counter.getValue().toString();
		this.categoriaUno = new Categoria(this.nombreCategoriaUno);
		mCat.agregarCategoria(this.categoriaUno);
		iconAC.agregarCategoria(this.nombreCategoriaUno);
		this.nombreCursoUno = "cursoUnoInfoCurso" + counter.getValue().toString();
		this.nombreInstitutoUno = "institutoUnoInfoCurso" + this.counter.getValue().toString();
		this.institutoUno = new Instituto(this.nombreInstitutoUno);
		mI.agregarInstituto(this.institutoUno);
		iconAC.altaCurso(this.nombreInstitutoUno, this.nombreCursoUno, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.confirmarAltaCurso();
		icon.consultarCurso(this.nombreCursoUno);
	}
	
	@Test (expected = CategoriaInexistente.class)
	public void test5_listarCursosCategoriaNoExiste() throws CategoriaInexistente, CategoriaSinCursos{
		icon.listarCursosCategoria("EstaCategoriaNoExiste");
	}
	
	@Test (expected = CategoriaSinCursos.class)
	public void test6_listarCursosCategoriaSinCursos() throws CategoriaInexistente, CategoriaSinCursos{
		this.nombreCategoriaUno = "categoriaUnoInfoCurso" + this.counter.getValue().toString();
		this.categoriaUno = new Categoria(this.nombreCategoriaUno);
		mCat.agregarCategoria(this.categoriaUno);
		icon.listarCursosCategoria(nombreCategoriaUno);
	}
	
	@Test 
	public void test7_listarCursosCategoria() throws CursoRepetido, CategoriaInexistente, CategoriaSinCursos, InstitutoInexistente{
		this.nombreCategoriaUno = "categoriaUnoInfoCurso" + counter.getValue().toString();
		this.categoriaUno = new Categoria(this.nombreCategoriaUno);
		mCat.agregarCategoria(this.categoriaUno);
		iconAC.agregarCategoria(this.nombreCategoriaUno);
		this.nombreCursoUno = "cursoUnoInfoCurso" + counter.getValue().toString();
		this.nombreInstitutoUno = "institutoUnoInfoCurso" + this.counter.getValue().toString();
		this.institutoUno = new Instituto(this.nombreInstitutoUno);
		mI.agregarInstituto(this.institutoUno);
		iconAC.altaCurso(this.nombreInstitutoUno, this.nombreCursoUno, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.confirmarAltaCurso();
		icon.listarCursosCategoria(this.nombreCategoriaUno);
	}
	
}
