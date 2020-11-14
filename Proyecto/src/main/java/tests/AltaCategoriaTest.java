package tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import excepciones.CategoriaRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCategoria;
import logica.Categoria;
import logica.ManejadorCategoria;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class AltaCategoriaTest {
	static Fabrica fabrica;
	static IControladorAltaCategoria icon; 
	String nombrec1;
	Integer id1 = 0;
	String nombrec2;
	Integer id2 = 0;
	Categoria categoria1;
	Categoria categoria2;
	static ManejadorCategoria mC;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaCategoria();
		mC = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		nombrec1 = "jedi_arts" + this.id1.toString();
		this.id1 += 1;
		nombrec2 = "sith_arts" + this.id2.toString();
		this.id2 += 1;
	}
	
	@Test
	public void categoriasConMismosDatos() throws CategoriaRepetidaException {
		icon.darAltaCategoria(nombrec1);
		icon.darAltaCategoria(nombrec2);
		categoria1 = mC.find(nombrec1);
		categoria2 = mC.find(nombrec2);
		assertNotSame(categoria1,categoria2);
	}
}
