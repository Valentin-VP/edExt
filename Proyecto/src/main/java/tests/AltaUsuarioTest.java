package tests;

import org.junit.Test;

import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import logica.Usuario;
import logica.ManejadorUsuario;
import logica.ManejadorInstituto;
import datatypes.DtFecha;
import excepciones.UsuarioRepetido;
import excepciones.SinInstitutos;

public class AltaUsuarioTest {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	Integer id1 = 0;
	Integer id2 = 0;
	Integer id3 = 0;
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
	}
	
	@Test
	public void test1_UsuariosConMismosDatos() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon.altaUsuario(nick1, correo1, nombre1, apellido1, fecha1, pass1);
		icon.confirmarAltaUsuario(esDocente1);
		icon.altaUsuario(nick2, correo2, nombre2, apellido2, fecha2, pass2);
		icon.confirmarAltaUsuario(esDocente2);
		usuario1 = mU.findUsuario(nick1);
		usuario2 = mU.findUsuario(nick2);
		assertNotSame(usuario1, usuario2);
	}
	
	@Test(expected = UsuarioRepetido.class)
	public void test2_UsuarioRepetido() {
		//crear un usuario y ver que no lo puedo crear devuelta
	}
	
	@Test
	public void test3_ListarInstitutos() {
		//listar los institutos que hay
	}
	
	@Test(expected = SinInstitutos.class)
	public void test4_NoHayInstitutosParaListar() {
		//ver que no hay institutos para listar
	}
	
	@Test
	public void test5_ObtenerInstitutos() {
		//traer los institutos que hay en la base de datos
	}
}
