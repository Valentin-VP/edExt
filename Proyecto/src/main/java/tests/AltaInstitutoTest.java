package tests;

import tests.Counter;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import excepciones.InstitutoRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import logica.Instituto;
import logica.ManejadorInstituto;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaInstitutoTest {
	static Fabrica fabrica = null;
	static IControladorAltaInstituto icon = null;
	static ManejadorInstituto mI = null;
	String nombre_base_uno = "instituto";
	String nombre_base_dos = "academia";
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaInstituto();
		mI = ManejadorInstituto.getInstancia();
		
	}
	
	@Before
	public void inicializarTest() {
		Counter counter = new Counter();
		this.nombre_base_uno += counter.getValue();
		this.nombre_base_dos += counter.getValue();
	}
	
	@Test
	public void test1_institutosConMismosDatos() throws InstitutoRepetidoException {
		icon.darAltaInstituto(this.nombre_base_uno);
		icon.darAltaInstituto(this.nombre_base_dos);
		assertNotSame(mI.find(this.nombre_base_uno),mI.find(this.nombre_base_dos));
	}
	
	@Test (expected = InstitutoRepetidoException.class)
	public void test2_institutoRepetido() throws InstitutoRepetidoException {
		icon.darAltaInstituto(this.nombre_base_uno);
		icon.darAltaInstituto(this.nombre_base_uno);
	}

}
