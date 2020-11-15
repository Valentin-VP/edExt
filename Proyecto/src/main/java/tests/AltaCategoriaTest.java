package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import excepciones.CategoriaRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCategoria;
import logica.Categoria;
import logica.ManejadorCategoria;

import tests.Counter;

public class AltaCategoriaTest {
	static Fabrica fabrica = null;
	static IControladorAltaCategoria icon = null; 
	String nombrec1 = "";
	Integer id1 = 0;
	String nombrec2 = "";
	Integer id2 = 0;
	Categoria categoria1 = null;
	Categoria categoria2 = null;
	static ManejadorCategoria mC = null;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaCategoria();
		mC = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		Counter counter1 = new Counter();
		this.nombrec1 = "jedi_arts" +  counter1.getValue();
		System.out.println(this.nombrec1);
		this.nombrec2 = "sith_arts" + counter1.getValue();
		System.out.println(this.nombrec2);
	}
	
	@Test
	public void categoriasConMismosDatos() throws CategoriaRepetidaException {
		icon.darAltaCategoria(nombrec1);
		icon.darAltaCategoria(nombrec2);
		categoria1 = mC.find(nombrec1);
		categoria2 = mC.find(nombrec2);
		assertNotSame(categoria1,categoria2);
	}
	
	@Test (expected = CategoriaRepetidaException.class)
	public void categoriaRepetida() throws CategoriaRepetidaException {
		icon.darAltaCategoria(nombrec1);
		System.out.println("En Categoria Repetida vale "+this.nombrec1);
		icon.darAltaCategoria(nombrec1);
	}

}
