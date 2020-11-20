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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaCategoriaTest {
	static Fabrica fabricaAltaCategoria = null;
	static IControladorAltaCategoria iconAltaCategory = null; 
	String var1 = "";
	String var2 = "";
	Categoria category1 = null;
	Categoria category2 = null;
	static ManejadorCategoria mCategory = null;
	
	@BeforeClass
	public static void preparacionTests() {
		fabricaAltaCategoria = Fabrica.getInstancia();
		iconAltaCategory = fabricaAltaCategoria.getIControladorAltaCategoria();
		mCategory = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		Counter counter1 = new Counter();
		this.var1 = "jedi_arts_" +  counter1.getValue();
		System.out.println(this.var1);
		this.var2 = "sith_arts_" + counter1.getValue();
		System.out.println(this.var2);
	}
	
	@Test
	public void test1_categoriasConMismosDatos() throws CategoriaRepetidaException {
		Counter counter = new Counter();
		iconAltaCategory.darAltaCategoria(this.var1+counter.getValue().toString());
		iconAltaCategory.darAltaCategoria(this.var2+counter.getValue().toString());
		category1 = mCategory.find("AltaCategoria: " + this.var1+counter.getValue().toString());
		category2 = mCategory.find("AltaCategoria: " + this.var2+counter.getValue().toString());
		assertNotSame(category1,category2);
	}
	
	@Test (expected = CategoriaRepetidaException.class)
	public void test2_categoriaRepetida() throws CategoriaRepetidaException {
		Counter counter = new Counter();
		iconAltaCategory.darAltaCategoria(this.var1+counter.getValue().toString());
		System.out.println("En Categoria Repetida vale "+this.var1+counter.getValue().toString());
		iconAltaCategory.darAltaCategoria(this.var1+counter.getValue().toString());
	}

}
