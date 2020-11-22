package tests;

import tests.Counter;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.SinCursos;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioRepetido;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InfoCursoTest {
	
	static Fabrica fabrica = null;
	static IControladorConsultaCurso icon = null;
	static IControladorAltaCurso iconAC = null;
	static IControladorAltaEdicionCurso iconEd = null;
	static IControladorAltaUsuario iconAu = null;
	static ManejadorCurso mC = null;
	static ManejadorInstituto mI = null;
	static ManejadorCategoria mCat = null;
	static ManejadorEdicion mEd = null;
	
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
		iconEd = fabrica.getIControladorAltaEdicionCurso();
		iconAu = fabrica.getIControladorAltaUsuario();
		mI = ManejadorInstituto.getInstancia();
		mC = ManejadorCurso.getInstancia();
		mCat = ManejadorCategoria.getInstancia();
		mEd = ManejadorEdicion.getInstancia();
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
	
	@Test
	public void test8_listarCursoConPreviasYEdiciones() throws CursoRepetido, InstitutoInexistente, ParseException, EdicionRepetida, CursoNoExiste, UsuarioNoDocente, UsuarioRepetido, NoSuchAlgorithmException {
		Counter counter = new Counter();
		this.nombreCategoriaUno = "categoriaUnoInfoCurso" + counter.getValue().toString();
		this.categoriaUno = new Categoria(this.nombreCategoriaUno);
		mCat.agregarCategoria(this.categoriaUno);
		this.nombreCursoUno = "cursoUnoInfoCurso" + counter.getValue().toString();
		this.nombreCursoDos = "cursoDosConPreviasInfoCurso" + counter.getValue().toString();
		this.nombreInstitutoUno = "institutoUnoInfoCurso" + this.counter.getValue().toString();
		this.institutoUno = new Instituto(this.nombreInstitutoUno);
		mI.agregarInstituto(this.institutoUno);
		iconAC.altaCurso(this.nombreInstitutoUno, this.nombreCursoUno, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.confirmarAltaCurso();
		iconAC.altaCurso(nombreInstitutoUno, this.nombreCursoDos, descripcion, duracion, cantHoras, creditos, url, fechaR);
		iconAC.agregarPrevia(this.nombreCursoDos);
		iconAC.confirmarAltaCurso();
		String nombreCurso3 = "cursoConPrevias" + counter.getValue().toString();
		iconAC.altaCurso(this.nombreInstitutoUno, nombreCurso3, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.agregarPrevia(this.nombreCursoUno);
		iconAC.agregarPrevia(this.nombreCursoDos);
		iconAC.confirmarAltaCurso();
		DtFecha nacimiento = new DtFecha(10, 10, 1991);
		iconAu.altaUsuario("doc" + counter.getValue().toString(), "doc@gmail.com" + counter.getValue().toString(), "elDoc", "suApellido", nacimiento, "12345");
		iconAu.confirmarAltaUsuario(true);
		ArrayList<String> docentes = new ArrayList<>();
		docentes.add("doc");
		DtFecha fechaI_edicion = new DtFecha(10, 10, 1997);
		DtFecha fechaF_edicion = new DtFecha(11, 11, 1998);
		DtFecha fechaP_edicion = new DtFecha(12, 12, 1999);
		iconEd.seleccionarInstituto(nombreInstitutoUno);
		iconEd.altaEdicionCurso(nombreCurso3, "edicion3" + counter.getValue().toString(), fechaI_edicion, fechaF_edicion, docentes, true, 100, fechaP_edicion);
		DtCurso recuperado = icon.consultarCurso(nombreCurso3);
		assertSame(recuperado.getNombre(), nombreCurso3);
	}
	
	@Test
	public void test9_listarInstitutos() throws SinInstitutos {
		Counter counter = new Counter();
		Instituto unInstituto = new Instituto("algunInstituto" + counter.getValue().toString());
		mI.agregarInstituto(unInstituto);
		Instituto otroInstituto = new Instituto("otroInstituto" + counter.getValue().toString());
		mI.agregarInstituto(otroInstituto);
		ArrayList<DtInstituto> recuperados = icon.listarInstitutos();
		assertNotSame(recuperados.get(0).getNombre(), "algunInstituto" + counter.getValue().toString()); 
	}
	
	@Test
	public void test10_listarCategorias() throws SinCategorias {
		Counter counter = new Counter();
		Categoria unaCategoria = new Categoria("nombreDeCategoria"+ counter.getValue().toString());
		mCat.agregarCategoria(unaCategoria);
		Categoria otraCategoria = new Categoria("nombreDeCategoriaSegunda"+ counter.getValue().toString());
		mCat.agregarCategoria(otraCategoria);
		ArrayList<String> recuperadas = icon.listarCategorias();
		assertNotSame(recuperadas.get(0), "nombreDeCategoriaSegunda"+ counter.getValue().toString());
	}
	
	@Test
	public void test11_listarCursosPlataforma() throws CursoRepetido, InstitutoInexistente, UsuarioRepetido, NoSuchAlgorithmException, EdicionRepetida, CursoNoExiste, UsuarioNoDocente, SinCursos {
		Counter counter = new Counter();
		this.nombreCategoriaUno = "categoriaUnoInfoCurso" + counter.getValue().toString();
		this.categoriaUno = new Categoria(this.nombreCategoriaUno + counter.getValue().toString());
		mCat.agregarCategoria(this.categoriaUno);
		Categoria otraCat = new Categoria ("algunaCategoria"+counter.getValue().toString());
		mCat.agregarCategoria(otraCat);
		this.nombreCursoUno = "cursoUnoInfoCurso" + counter.getValue().toString();
		this.nombreCursoDos = "cursoDosConPreviasInfoCurso" + counter.getValue().toString();
		this.nombreInstitutoUno = "institutoUnoInfoCurso" + this.counter.getValue().toString();
		this.institutoUno = new Instituto(this.nombreInstitutoUno + counter.getValue().toString());
		mI.agregarInstituto(this.institutoUno);
		iconAC.altaCurso(this.nombreInstitutoUno + counter.getValue().toString(), this.nombreCursoUno, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.confirmarAltaCurso();
		iconAC.altaCurso(nombreInstitutoUno + counter.getValue().toString(), this.nombreCursoDos, descripcion, duracion, cantHoras, creditos, url, fechaR);
		iconAC.agregarPrevia(this.nombreCursoDos);
		iconAC.confirmarAltaCurso();
		String nombreCurso3 = "cursoConPrevias" + counter.getValue().toString();
		iconAC.altaCurso(this.nombreInstitutoUno + counter.getValue().toString(), nombreCurso3, this.descripcion,this.duracion, this.cantHoras, this.creditos, this.url, this.fechaR);
		iconAC.agregarPrevia(this.nombreCursoUno);
		iconAC.agregarPrevia(this.nombreCursoDos);
		iconAC.confirmarAltaCurso();
		DtFecha nacimiento = new DtFecha(10, 10, 1991);
		iconAu.altaUsuario("doc" + counter.getValue().toString(), "doc@gmail.com" + counter.getValue().toString(), "elDoc", "suApellido", nacimiento, "12345");
		iconAu.confirmarAltaUsuario(true);
		ArrayList<String> docentes = new ArrayList<>();
		docentes.add("doc");
		DtFecha fechaI_edicion = new DtFecha(10, 10, 1997);
		DtFecha fechaF_edicion = new DtFecha(11, 11, 1998);
		DtFecha fechaP_edicion = new DtFecha(12, 12, 1999);
		iconEd.seleccionarInstituto(nombreInstitutoUno + counter.getValue().toString());
		iconEd.altaEdicionCurso(nombreCurso3, "edicion3" + counter.getValue().toString(), fechaI_edicion, fechaF_edicion, docentes, true, 100, fechaP_edicion);
		ArrayList<DtCurso> recuperados = null;
		recuperados = icon.listarCursosPlataforma();
		assertNotSame(recuperados.get(0).getNombre(), nombreCurso3);
	}
}
