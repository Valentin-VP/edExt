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
import datatypes.DtFecha;
import excepciones.UsuarioRepetido;

public class AltaUsuarioTest {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	Integer id1 = 0;
	Integer id2 = 0;
	Integer id3 = 0;
	Usuario usuario1;
	Usuario usuario2;
	String nick1;
	String nick2;
	String correo1;
	String correo2;
	String nombre1;
	String nombre2;
	String apellido1;
	String apellido2;
	String pass1;
	String pass2;
	DtFecha fecha1;
	DtFecha fecha2;
	boolean esDocente1;
	boolean esDocente2;
	static ManejadorUsuario mU;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		mU = ManejadorUsuario.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		nick1 = "ObiWK" + this.id1.toString();
		nick2 = "DarthM" + this.id2.toString();
		correo1 = "ObiWanKenobi@jedis.republic" + this.id1.toString();
		correo2 = "DarthMaul@siths.empire" + this.id2.toString();
		nombre1 = "ObiWan" + this.id1.toString();
		nombre2 = "Darth" + this.id2.toString();
		apellido1 = "Kenobi" + this.id1.toString();
		apellido2 = "Maul" + this.id2.toString();
		pass1 = "ObiWan" + this.id1.toString();
		pass2 = "DarthMaul" + this.id2.toString();
		fecha1 = new DtFecha(id1, id2, id3);
		fecha2 = new DtFecha(id3, id2, id1);
		esDocente1 = false;
		esDocente2 = true;
		id1++;
		id2++;
		id3++;
	}
	
	@Test
	public void UsuariosConMismosDatos() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon.altaUsuario(nick1, correo1, nombre1, apellido1, fecha1, pass1);
		icon.confirmarAltaUsuario(esDocente1);
		icon.altaUsuario(nick2, correo2, nombre2, apellido2, fecha2, pass2);
		icon.confirmarAltaUsuario(esDocente1);
		usuario1 = mU.findUsuario(nick1);
		usuario2 = mU.findUsuario(nick2);
		assertNotSame(usuario1, usuario2);
	}
}
