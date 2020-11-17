package tests;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import logica.Usuario;
import logica.ManejadorUsuario;
import logica.Instituto;
import logica.ManejadorInstituto;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetido;
import excepciones.SinInstitutos;

public class AltaUsuarioTest {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	Usuario usuario1 = null;
	Usuario usuario2 = null;
	
	String nick1 = "";
	String nick2 = "";
	String correo1 = "";
	String correo2 = "";
	String nombre1 = "";
	String nombre2 = "";
	String apellido1 = "";
	String apellido2 = "";
	String pass1 = "";
	String pass2 = "";
	DtFecha fecha1 = null;
	DtFecha fecha2 = null;
	boolean esDocente1 = false;
	boolean esDocente2 = false;
	
	String instituto1 = "";
	String instituto2 = "";
	static ManejadorUsuario mU;
	static ManejadorInstituto mI;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		mU = ManejadorUsuario.getInstancia();
		mI = ManejadorInstituto.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		Counter contador = new Counter();
		this.nick1 = "ObiWK" + contador.getValue();
		this.nick2 = "DarthM" + contador.getValue();
		this.correo1 = "ObiWanKenobi@jedis.republic" + contador.getValue();
		this.correo2 = "DarthMaul@siths.empire" + contador.getValue();
		this.nombre1 = "ObiWan" + contador.getValue();
		this.nombre2 = "Darth" + contador.getValue();
		this.apellido1 = "Kenobi" + contador.getValue();
		this.apellido2 = "Maul" + contador.getValue();
		this.pass1 = "ObiWan" + contador.getValue();
		this.pass2 = "DarthMaul" + contador.getValue();
		this.fecha1 = new DtFecha(30, 11, 1999);
		this.fecha2 = new DtFecha(25, 12, 1998);
		this.esDocente1 = false;
		this.esDocente2 = true;
		this.instituto1 = "JediAcademy" + contador.getValue();
		this.instituto2 = "SithAcademy" + contador.getValue();
	}
	
	@Test
	public void test2_UsuariosConMismosDatos() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon.altaUsuario(nick1, correo1, nombre1, apellido1, fecha1, pass1);
		icon.confirmarAltaUsuario(esDocente1);
		icon.altaUsuario(nick2, correo2, nombre2, apellido2, fecha2, pass2);
		icon.confirmarAltaUsuario(esDocente2);
		usuario1 = mU.findUsuario(nick1);
		usuario2 = mU.findUsuario(nick2);
		assertNotSame(usuario1, usuario2);
	}
	
	@Test(expected = UsuarioRepetido.class)
	public void test3_UsuarioRepetidoCorreo() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon.altaUsuario(nick1, correo1, nombre1, apellido1, fecha1, pass1);
		icon.confirmarAltaUsuario(esDocente1);
		icon.altaUsuario(nick2, correo1, nombre1, apellido1, fecha1, pass1);
		//icon.confirmarAltaUsuario(esDocente1);
	}
	
	@Test(expected = UsuarioRepetido.class)
	public void test4_UsuarioRepetidoNick() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon.altaUsuario(nick1, correo1, nombre1, apellido1, fecha1, pass1);
		icon.confirmarAltaUsuario(esDocente1);
		icon.altaUsuario(nick1, correo2, nombre1, apellido1, fecha1, pass1);
		//icon.confirmarAltaUsuario(esDocente1);
	}
	
	@Test
	public void test5_CrearYListarInstitutos() throws SinInstitutos {
		Instituto i1 = new Instituto(this.instituto1);
		Instituto i2 = new Instituto(this.instituto2);
		mI.agregarInstituto(i1);
		mI.agregarInstituto(i2);
		icon.seleccionarInstituto(this.instituto1);
		icon.seleccionarInstituto(this.instituto2);
		icon.listarInstitutos();
	}
	
	@Test
	public void test6_SetersYGeters() {
		DtUsuario dtu = new DtUsuario(nick1, correo1, nombre1, apellido1, fecha1, pass1);
		icon.setUsuario(dtu);
		DtUsuario user = icon.getUsuario();
		Instituto ii = new Instituto(instituto1);
		icon.setInstituto(ii);
		Instituto ins = icon.getInstituto();
	}
	
	@Test
	public void test7_ObtenerInstitutos() {
		List<Instituto> institutos1 = mI.getInstitutos();
		List<Instituto> institutos2 = icon.getInstitutos();
		Assert.assertEquals(institutos1, institutos2);
	}
}
