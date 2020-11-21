package tests;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtFecha;
import excepciones.ProgramaRepetido;
import interfaces.Fabrica;
import interfaces.IControladorAltaProgFormacion;
import logica.ManejadorProgFormacion;

import static org.junit.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaProgFormacionTest {
	static Fabrica fabrica;
	static IControladorAltaProgFormacion icon;
	static ManejadorProgFormacion mI;
	String programa1 = "";
	String programa2 = "";
	static String progAgregado;
	LocalDate factual;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaProgFormacion();
		mI = ManejadorProgFormacion.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		LocalDate hoy = LocalDate.now();
		this.factual = hoy;
		Counter counter = new Counter();
		this.programa1 = "prog" +  counter.getValue();
		System.out.println(this.programa1);
		this.programa2 = "prog_jedis" + counter.getValue();
		System.out.println(this.programa2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test1_ingresarProgFormacion() throws ProgramaRepetido {
		// FechaI random
		int minyear = 2015;
		int maxyear = 2025;
		int yeari = (int)(Math.random()*(maxyear-minyear+1)+minyear);
		int minmes = 1;
		int maxmes = 11;
		int mesi = (int)(Math.random()*(maxmes-minmes+1)+minmes);
		int mindia = 1;
		int maxdia = 31;
		int diai = (int)(Math.random()*(maxdia-mindia+1)+mindia);
		
		// FechaF random
		int minyearf = 2015;
		int maxyearf = 2025;
		int yearf = (int)(Math.random()*(maxyearf-minyearf+1)+minyearf);
		int minmesf = 1;
		int maxmesf = 11;
		int mesf = (int)(Math.random()*(maxmesf-minmesf+1)+minmes);
		int mindiaf = 1;
		int maxdiaf = 31;
		int diaf = (int)(Math.random()*(maxdiaf-mindiaf+1)+mindiaf);
		
		DtFecha fechaI = new DtFecha(diai,mesi,yeari);
		DtFecha fechaF = new DtFecha(diaf,mesf,yearf);
		System.out.println("El mes com int"+mesi);
		System.out.println("El mes del dtfecha"+fechaI.getMes());
		System.out.println("El programa 1" + this.programa1);
		System.out.print("El programa 2" + this.programa2);
		
		icon.ingresarProgFormacion(this.programa1, "ni idea", fechaI, fechaF, factual);
		icon.confirmar();
		icon.cancelar();
		this.progAgregado = this.programa1;
		icon.ingresarProgFormacion(this.programa2, "ni idea", fechaI, fechaF, factual);
		icon.confirmar();
		icon.cancelar();
		
	}

	@SuppressWarnings("static-access")
	// El testeo sale bien si ocurre la excepcion, en este caso la generamos a proposito
	// el expected funciona igual
	@Test //(expected = ProgramaRepetido.class)
	public void test2_programaRepetido() {
		// FechaI random
		int minyear = 2015;
		int maxyear = 2025;
		int yeari = (int)(Math.random()*(maxyear-minyear+1)+minyear);
		int minmes = 1;
		int maxmes = 11;
		int mesi = (int)(Math.random()*(maxmes-minmes+1)+minmes);
		int mindia = 1;
		int maxdia = 31;
		int diai = (int)(Math.random()*(maxdia-mindia+1)+mindia);
		
		// FechaF random
		int minyearf = 2015;
		int maxyearf = 2025;
		int yearf = (int)(Math.random()*(maxyearf-minyearf+1)+minyearf);
		int minmesf = 1;
		int maxmesf = 11;
		int mesf = (int)(Math.random()*(maxmesf-minmesf+1)+minmes);
		int mindiaf = 1;
		int maxdiaf = 31;
		int diaf = (int)(Math.random()*(maxdiaf-mindiaf+1)+mindiaf);
		
		DtFecha fechaI = new DtFecha(diai,mesi,yeari);
		DtFecha fechaF = new DtFecha(diaf,mesf,yearf);
		
		// Ya existe el programa
		assertThrows(ProgramaRepetido.class, () -> {
			icon.ingresarProgFormacion(this.progAgregado, "ni idea", fechaI, fechaF, factual);
		});
	}
	
}
