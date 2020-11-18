package tests;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtFecha;
import excepciones.SinUsuarios;
import excepciones.UsuarioNoExiste;
import interfaces.Fabrica;
import interfaces.IControladorModificarDatosUsuario;
import logica.Estudiante;
import logica.ManejadorUsuario;

import java.text.ParseException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModificarDatosUsuarioTest {
	static Fabrica fabrica;
	static IControladorModificarDatosUsuario icon;
	static ManejadorUsuario mU;
	String estudiante1 = "";
	String estudiante2 = "";
	static Estudiante est1;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorModificarDatosUsuario();
		mU = ManejadorUsuario.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		Counter counter = new Counter();
		this.estudiante1 = "est" +  counter.getValue();
		System.out.println(this.estudiante1);
		this.estudiante2 = "est_jedis" + counter.getValue();
		System.out.println(this.estudiante2);
	}
	
	@Test (expected = SinUsuarios.class)
	public void test1_mostrarUsuarios() throws SinUsuarios {
		icon.mostrarUsuarios();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test2_seleccionarUsuario() throws UsuarioNoExiste, ParseException{
		// Fecha nacimiento random
		int minyear = 1990;
		int maxyear = 2005;
		int yearnac = (int)(Math.random()*(maxyear-minyear+1)+minyear);
		int minmes = 1;
		int maxmes = 12;
		int mesnac = (int)(Math.random()*(maxmes-minmes+1)+minmes);
		int mindia = 1;
		int maxdia = 31;
		int dianac = (int)(Math.random()*(maxdia-mindia+1)+mindia);
		DtFecha fnac = new DtFecha(dianac, mesnac, yearnac);

		Estudiante est1 = new Estudiante(this.estudiante1,"est1","nose", "est1@gmail.com", fnac.DtFechaToDate(), "j2343ka34sdbyq623");
		Estudiante est2 = new Estudiante(this.estudiante2,"est2","nose", "est2@gmail.com", fnac.DtFechaToDate(), "asd3549as34d732asd");
		this.est1 = est1;
		
		mU.agregarUsuario(est1);
		mU.agregarUsuario(est2);
		
		icon.seleccionarUsuario(est1.getNick(), est1.getCorreo());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test3_modificarDatosUsuario() {
		// Fecha nacimiento random
		int minyear = 1990;
		int maxyear = 2005;
		int yearnac = (int)(Math.random()*(maxyear-minyear+1)+minyear);
		int minmes = 1;
		int maxmes = 12;
		int mesnac = (int)(Math.random()*(maxmes-minmes+1)+minmes);
		int mindia = 1;
		int maxdia = 31;
		int dianac = (int)(Math.random()*(maxdia-mindia+1)+mindia);
		DtFecha fnac = new DtFecha(dianac, mesnac, yearnac);
		char[] pass = this.est1.getNick().toCharArray();
		icon.modificarDatosUsuario(this.est1.getNick(), this.est1.getCorreo(), this.est1.getNombre(), this.est1.getApellido(), fnac, pass);
	}
	
	@Test
	public void test4_limpiar() {
		icon.limpiar();
	}

}
