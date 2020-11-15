package tests;

import tests.Counter;
import org.junit.Test;

import datatypes.DtFecha;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import logica.Categoria;
import logica.Curso;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorInstituto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

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
	
	Curso c1 = null;
	Curso c2 = null;
	
	String url = "";
	DtFecha fechaR = null;
	
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
		
		this.nombre_curso_dos = "mind_trick_" + counter1.getValue();
	}
	// 	(String instituto, String nombre, String descripcion, String duracion, int cantHoras, int creditos, String url, DtFecha fechaR) throws CursoRepetido, InstitutoInexistente {

	@Test
	public void crearUnCurso() throws CursoRepetido, InstitutoInexistente{
		Instituto instituto_uno = new Instituto("instituto_uno_altaCurso");
		mI.agregarInstituto(instituto_uno);	
		Categoria categoria_uno = new Categoria("categoria_uno_altaCurso");
		mCat.agregarCategoria(categoria_uno);
	}
	
	@Test
	public void institutoNoExiste() throws CursoRepetido, InstitutoInexistente{
		
	}
	
	@Test
	public void cursoYaExiste() throws CursoRepetido, InstitutoInexistente{
		
	}
}
