package tests;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtEdicionCompleta;
import datatypes.DtFecha;
import datatypes.DtInstituto;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

import excepciones.CategoriaRepetidaException;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.EdicionNoExiste;
import excepciones.EdicionRepetida;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioNoEstudiante;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioRepetido;
import interfaces.Fabrica;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorInscripcionEdicionCurso;
import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;

import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;
import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Edicion;
import logica.Estudiante;
import tests.Counter;

import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListarAceptadosTest {

	static Fabrica fabrica = null;
	static IControladorListarAceptadosAUnaEdicionDeCurso icon = null; 
	static IControladorAltaCurso iconCurso = null; 
	static IControladorAltaEdicionCurso iconEdicion = null; 
	static IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso iconSelect = null; 
	static IControladorInscripcionEdicionCurso iconInsc = null; 
	static IControladorAltaUsuario iconUser = null; 
	String estudiante1 = "";
	String estudiante2 = "";
	String docente1 = "";
	
	String nombre_curso_uno = "";
	String nombre_curso_dos = "";
	String nombre_edicion_uno = "";
	String nombre_edicion_dos = "";
	String nombre_instituto_uno = "instituto_uno_listarAceptados";
	String nombre_instituto_dos = "instituto_dos_listarAceptados";
	String nombre_categoria_uno = "categoria_uno_listarAceptados";
	static ManejadorCurso mC = null;
	static ManejadorEdicion mE = null;
	static ManejadorInstituto mI = null;
	static ManejadorCategoria mCat = null;
	
	String desc1 = "d1";
	String desc2 = "d2";
	
	DtFecha fechaR_uno = null;
	DtFecha fechaR_dos= null;
	DtFecha fechaF_uno = null;
	DtFecha fechaF_dos= null;
	DtFecha fechaI_uno = null;
	DtFecha fechaI_dos= null;
	DtFecha fechaP_uno = null;
	DtFecha fechaP_dos= null;

	Categoria categoria_uno = null;
	Instituto instituto_uno = null;
	Instituto instituto_dos = null;
	Edicion e1 = null;
	Edicion e2 = null;
	Curso c1 = null;
	Curso c2 = null;
	Estudiante est1 = null;
	Estudiante est2 = null;
	Docente doc1 = null;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorListarAceptadosAUnaEdicionDeCurso();
		iconCurso = fabrica.getIControladorAltaCurso();
		iconEdicion = fabrica.getIControladorAltaEdicionCurso();
		iconSelect = fabrica.getIControladorSeleccionarEstudiantesParaUnaEdicionDeCurso();
		iconInsc = fabrica.getIControladorInscripcionEdicionCurso();
		iconUser = fabrica.getIControladorAltaUsuario();
		mI = ManejadorInstituto.getInstancia();
		mE = ManejadorEdicion.getInstancia();
		mC = ManejadorCurso.getInstancia();
		mCat = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		Counter counter1 = new Counter();
		this.nombre_curso_uno = "bakers_mansion_" + counter1.getValue();
		this.nombre_curso_dos = "dulvey_" + counter1.getValue();
		this.nombre_edicion_uno = "chainsaw_fight_" + counter1.getValue();
		this.nombre_edicion_dos = "saw_traps_" + counter1.getValue();
		this.estudiante1 = "e_winters_" + counter1.getValue();
		this.estudiante2 = "c_redfield_" + counter1.getValue();
		this.docente1 = "o_spencer_" + counter1.getValue();
		this.fechaR_uno = new DtFecha(30,9,2020);
		this.fechaR_dos = new DtFecha(30,10,2020);
		this.fechaF_uno = new DtFecha(31,12,2000);
		this.fechaF_dos = new DtFecha(31,12,2022);
		this.fechaI_uno = new DtFecha(1,1,2000);
		this.fechaI_dos = new DtFecha(1,1,2020);
		this.fechaP_uno = new DtFecha(1,1,2000);
		this.fechaP_dos = new DtFecha(1,1,2020);

	}
	

	
	@Test (expected = InstitutoInexistente.class)
	public void test02_ingresarInstitutoInexistente() throws SinInstitutos, InstitutoInexistente, InstitutoSinCursos {
		List<DtCursoBase> instNoExiste = icon.ingresarInstituto("a");
	}
	
	@Test (expected = InstitutoSinCursos.class)
	public void test03_ingresarInstitutoSinCursos() throws InstitutoInexistente, InstitutoSinCursos {
		Counter counter = new Counter();
		instituto_uno = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto_uno);	
		List<DtCursoBase> instNoExiste = icon.ingresarInstituto(nombre_instituto_uno+counter.getValue().toString());
	}
	@Test 
	public void test04_ingresarInstituto() throws InstitutoSinCursos, CursoRepetido, InstitutoInexistente, ParseException   {
		Counter counter = new Counter();
		categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		instituto_dos = new Instituto(nombre_instituto_dos+counter.getValue().toString());
		mI.agregarInstituto(instituto_dos);	
		iconCurso.altaCurso(nombre_instituto_dos+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), desc1, "1", 1, 1, "www.1", fechaR_uno);
		iconCurso.confirmarAltaCurso();
		iconCurso.altaCurso(nombre_instituto_dos+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString(), desc2, "2", 2, 2, "www.2", fechaR_dos);
		iconCurso.confirmarAltaCurso();
		
		//e1 = new Edicion(nombre_edicion_uno, fechaI_uno.DtFechaToDate(), fechaF_uno.DtFechaToDate(), true, 5, fechaP_uno.DtFechaToDate());
		//e2 = new Edicion(nombre_edicion_dos, fechaI_dos.DtFechaToDate(), fechaF_dos.DtFechaToDate(), false, 0, fechaP_dos.DtFechaToDate());

		List<DtCursoBase> institutos = icon.ingresarInstituto(nombre_instituto_dos+counter.getValue().toString());

		assertNotNull(institutos);
	}
	@Test 
	public void test05_listarInstituto() throws SinInstitutos {
		ArrayList<DtInstituto> inst = icon.listarInstitutos();
	}
	
	@Test (expected = CursoNoExiste.class)
	public void test06_ingresarCursoInexistente() throws CursoNoExiste, EdicionNoExiste {
		icon.ingresarCurso("lol");
	}
	
	@Test  (expected = EdicionNoExiste.class)
	public void test07_ingresarCursoSinEdicion() throws InstitutoSinCursos, CursoRepetido, InstitutoInexistente, ParseException, CursoNoExiste, EdicionNoExiste   {
		Counter counter = new Counter();
		categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		instituto_dos = new Instituto(nombre_instituto_dos+counter.getValue().toString());
		mI.agregarInstituto(instituto_dos);	
		iconCurso.altaCurso(nombre_instituto_dos+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), desc1, "1", 1, 1, "www.1", fechaR_uno);
		iconCurso.confirmarAltaCurso();

		icon.ingresarCurso(nombre_curso_uno+counter.getValue().toString());

	}
	
	@Test 
	public void test08_ingresarCurso() throws  CursoRepetido, InstitutoInexistente, ParseException, EdicionRepetida, CursoNoExiste, UsuarioNoDocente, EdicionNoExiste   {
		//Docente sin persistir
		Counter counter = new Counter();
		ArrayList<String> docentes = new ArrayList<String>();
		docentes.add(docente1+counter.getValue().toString());
		categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		instituto_dos = new Instituto(nombre_instituto_dos+counter.getValue().toString());
		mI.agregarInstituto(instituto_dos);	
		iconCurso.altaCurso(nombre_instituto_dos+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString(), desc1, "1", 1, 1, "www.1", fechaR_uno);
		iconCurso.confirmarAltaCurso();
		Docente docente = new Docente(docente1+counter.getValue().toString(), "irrelevante", "irrelevante", "d@d"+counter.getValue().toString(), fechaR_uno.DtFechaToDate(), instituto_dos, "1");
		iconEdicion.seleccionarInstituto(nombre_instituto_dos+counter.getValue().toString());
		iconEdicion.altaEdicionCurso(nombre_curso_dos+counter.getValue(), nombre_edicion_uno+counter.getValue(), fechaI_uno, fechaF_uno, docentes, false, 0, fechaP_uno);

		List<DtEdicionBase> ediciones = icon.ingresarCurso(nombre_curso_dos+counter.getValue());
		assertNotNull(ediciones);
	}
	
	@Test (expected = EdicionNoExiste.class)
	public void test09_ingresarEdicionInexistente() throws EdicionNoExiste {
		icon.ingresarEdicion("lol");
	}
	
	@Test 
	public void test10_ingresarEdicion() throws  CursoRepetido, InstitutoInexistente, ParseException, EdicionRepetida, CursoNoExiste, UsuarioNoDocente, EdicionNoExiste, EdicionVigenteNoExiste, UsuarioNoExiste, UsuarioNoEstudiante, InscripcionEdRepetido, UsuarioRepetido, NoSuchAlgorithmException, InstitutoSinCursos   {

		Counter counter = new Counter();
		ArrayList<String> docentes = new ArrayList<String>();
		docentes.add(docente1+counter.getValue().toString());
		categoria_uno = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria_uno);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		instituto_dos = new Instituto(nombre_instituto_dos+counter.getValue().toString());
		mI.agregarInstituto(instituto_dos);	
		iconCurso.altaCurso(nombre_instituto_dos+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString(), desc1, "1", 1, 1, "www.1", fechaR_uno);
		iconCurso.confirmarAltaCurso();
		//Docente docente = new Docente(docente1+counter.getValue().toString(), "irrelevante", "irrelevante", "d@d"+counter.getValue().toString(), fechaR_uno.DtFechaToDate(), instituto_dos, "1");
		iconUser.altaUsuario(docente1+counter.getValue().toString(), "d@d"+counter.getValue().toString(), "irrelevante", "irrelevante", fechaR_uno, "1");
		iconUser.seleccionarInstituto(nombre_instituto_dos+counter.getValue().toString());
		iconUser.confirmarAltaUsuario(true);
		iconEdicion.seleccionarInstituto(nombre_instituto_dos+counter.getValue().toString());
		iconEdicion.altaEdicionCurso(nombre_curso_dos+counter.getValue(), nombre_edicion_dos+counter.getValue(), fechaI_dos, fechaF_dos, docentes, false, 0, fechaP_dos);

		//Estudiante estudiante = new Estudiante(estudiante1+counter.getValue().toString(), "irrelevante", "irrelevante", "e@e"+counter.getValue().toString(), fechaR_dos.DtFechaToDate(), "1");
		iconUser.altaUsuario(estudiante1+counter.getValue().toString(), "e@e"+counter.getValue().toString(), "irrelevante", "irrelevante", fechaR_uno, "1");
		iconUser.confirmarAltaUsuario(false);
		iconInsc.seleccionarInstituto(nombre_instituto_dos+counter.getValue().toString());
		iconInsc.seleccionarCurso(nombre_curso_dos+counter.getValue().toString());
		iconInsc.registrarInscripcionEd(estudiante1+counter.getValue().toString(), "e@e"+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString(), fechaR_dos);
		iconInsc.confirmar();
		DtEdicionCompleta edicion = icon.ingresarEdicion(nombre_edicion_dos+counter.getValue());
		assertNotNull(edicion);
		iconSelect.listarCursosInstituto(nombre_instituto_dos+counter.getValue().toString());
		iconSelect.seleccionarCurso(nombre_curso_dos+counter.getValue().toString(), docente1+counter.getValue().toString());
		iconSelect.setEdicion(nombre_edicion_dos+counter.getValue());
		iconSelect.cambiarEstadoInscripcion(estudiante1+counter.getValue().toString(), "Aceptada");
		iconSelect.confirmarSeleccion();
		DtEdicionCompleta edicion_final = icon.ingresarEdicion(nombre_edicion_dos+counter.getValue());
		assertNotNull(edicion.getInscripciones());
	}
	
}
