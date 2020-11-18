package tests;

import org.junit.Test;

import datatypes.DtFecha;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import interfaces.Fabrica;
import interfaces.IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import logica.Usuario;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;

public class SeleccionarEstudiantesTest {
	static Fabrica fabrica = null;
	static IControladorSeleccionarEstudiantesParaUnaEdicionDeCurso icon = null;
	static ManejadorInstituto mI = null;
	static ManejadorUsuario mU = null;
	static ManejadorCurso mC = null;
	static ManejadorEdicion mE = null;
	Instituto ins1 = null;
	Usuario est1 = null;
	Curso c1 = null;
	Edicion ed1 = null;
	DtFecha fecha = null;
	//Categoria categoria1 = null;
	//Categoria categoria2 = null;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSeleccionarEstudiantesParaUnaEdicionDeCurso();
		mI = ManejadorInstituto.getInstancia();
		mU = ManejadorUsuario.getInstancia();
		mC = ManejadorCurso.getInstancia();
		mE = ManejadorEdicion.getInstancia();
		//mC = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		Counter counter1 = new Counter();
		LocalDate hoy = LocalDate.now();
		fecha = new DtFecha(hoy.getDayOfMonth(),hoy.getMonthValue(),hoy.getYear());
		this.ins1 = mI.find("fing1");
		this.est1 = mU.findUsuario("est1");
		this.c1 = mC.find("c2");
		this.ed1 = mE.find("Ed2");
		//this.nombrec1 = "jedi_arts" +  counter1.getValue();
		//System.out.println(this.nombrec1);
		//this.nombrec2 = "sith_arts" + counter1.getValue();
		//System.out.println(this.nombrec2);
	}
	
	@Test
	public void test1_listarCursosInstituto() throws InstitutoInexistente, InstitutoSinCursos{
		//ArrayList<DtCursoBase> cursos = icon.listarCursosInstituto(instituto);
		//assertNotNull(cursos);
	}
	
	@Test
	public void test2_seleccionarCurso() throws EdicionVigenteNoExiste{
		//icon.seleccionarCurso(nomCurso, nick);
	}
	
	@Test
	public void ordenarInscripciones(){
		icon.ordenarInscripciones("no ordenar");
	}
	
	@Test
	public void cambiarEstadoInscripcion() {
		String estado = "Aceptado";
		icon.cambiarEstadoInscripcion("", estado);
	}
	
	@Test
	public void confirmarSeleccion() {
		icon.confirmarSeleccion();
	}
	
	@Test
	public void limpiar() {
		icon.limpiar();
	}
	
}
