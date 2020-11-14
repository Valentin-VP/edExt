package tests;

import org.junit.Test;

import excepciones.CategoriaRepetidaException;

import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import logica.Usuario;
import logica.ManejadorUsuario;

public class AltaUsuarioTest {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	Integer id1 = 0;
	Integer id2 = 0;
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
	String nick1;
	String nick2;
	static ManejadorUsuario mU;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		mU = ManejadorUsuario.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		nick1 = "ObiWanKenobi" + this.id1.toString();
		this.id1 += 1;
		nick2 = "AsokaTano" + this.id2.toString();
		this.id2 += 1;
	}
	
	@Test
	public void categoriasConMismosDatos() throws CategoriaRepetidaException {
		icon.altaUsuario(nick1, correo, nombre, apellido, fechaNac, password);
		icon.altaUsuario(nick2, correo, nombre, apellido, fechaNac, password);
		usuario1 = mU.findUsuario(nombrec1);
		usuario2 = mU.findUsuario(nombrec2);
		assertNotSame(usuario1, usuario2);
	}
}
