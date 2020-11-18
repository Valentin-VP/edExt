package tests;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import datatypes.DtFecha;
import excepciones.UsuarioRepetido;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorSesion;
import logica.Docente;
import logica.Estudiante;
import logica.ManejadorUsuario;
import logica.Usuario;

public class SesionTest {
	private static Fabrica fabrica;
	private static IControladorSesion icon;
	private static IControladorAltaUsuario icon2;
	private static ManejadorUsuario mU;
	
	private String nick_usuario1 = "";
	private String nick_usuario2 = "";
	private String correo_usuario1 = "";
	private String correo_usuario2 = "";
	private String pass_usuario1 = "";
	private String pass_usuario2 = "";
	private DtFecha fechaN_usuario1 = new DtFecha(10, 10, 1998);
	private DtFecha fechaN_usuario2 = new DtFecha(11, 11, 1999);
	private String nick_usuario3 = "";
	private String nick_usuario4 = "";
	private String correo_usuario3 = "";
	private String correo_usuario4 = "";
	private String pass_usuario3 = "";
	private String pass_usuario4 = "";
	private DtFecha fechaN_usuario3 = new DtFecha(11, 11, 1998);
	private DtFecha fechaN_usuario4 = new DtFecha(12, 12, 1999);
	
	private String id_usr1 = "";
	private String id_usr2 = "";
	private String id_usr3 = "";
	private String id_usr4 = "";
	
	/*private Usuario usuario1 = null;
	private Usuario usuario2 = null;*/
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSesion();
		icon2 = fabrica.getIControladorAltaUsuario();
		mU = ManejadorUsuario.getInstancia();
	}
	
	@Before
	public void inicializarTest() throws ParseException {
		Counter contador = new Counter();
		this.nick_usuario1 = "AT" + contador.getValue();
		this.nick_usuario2 = "OWK" + contador.getValue();
		this.correo_usuario1 = "ATano@republic.com" + contador.getValue();
		this.correo_usuario2 = "ObiWK@republic.com" + contador.getValue();
		this.pass_usuario1 = "asokaRules";
		this.pass_usuario2 = "kenobiRules";
		
		this.nick_usuario3 = "Yoda" + contador.getValue();
		this.nick_usuario4 = "Ani" + contador.getValue();
		this.correo_usuario3 = "Yoda@republic.com" + contador.getValue();
		this.correo_usuario4 = "ASkywalker@republic.com" + contador.getValue();
		this.pass_usuario3 = "YodaRules";
		this.pass_usuario4 = "AnakinRules";
		
		this.id_usr1 = this.correo_usuario1;
		this.id_usr2 = this.nick_usuario2;
		this.id_usr3 = this.correo_usuario3;
		this.id_usr4 = this.nick_usuario4;
	}
	
	@Test
	public void test1_existeUsuarioFalseCorreo() {
		boolean retorno = icon.existeUsuario(id_usr1);
		assertEquals(false, retorno);
	}
	
	@Test
	public void test2_existeUsuarioTrueCorreo() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon2.altaUsuario(this.nick_usuario1, this.correo_usuario1, "Asoka", "Tano", fechaN_usuario1, this.pass_usuario1);
		icon2.confirmarAltaUsuario(false);
		boolean retorno = icon.existeUsuario(id_usr1);
		assertEquals(true, retorno);
	}
	
	@Test
	public void test3_existeUsuarioFalseNick() {
		boolean retorno = icon.existeUsuario(id_usr2);
		assertEquals(false, retorno);
	}
	
	@Test
	public void test4_existeUsuarioTrueNick() throws UsuarioRepetido, NoSuchAlgorithmException {
		icon2.altaUsuario(this.nick_usuario2, this.correo_usuario2, "Obi Wan", "Kenobi", fechaN_usuario2, this.pass_usuario2);
		icon2.confirmarAltaUsuario(true);
		boolean retorno = icon.existeUsuario(id_usr2);
		assertEquals(true, retorno);
	}
	
	@Test
	public void test5_identificarUsuarioCorreo() throws NoSuchAlgorithmException, UsuarioRepetido {
		icon2.altaUsuario(this.nick_usuario3, this.correo_usuario3, "Master", "Yoda", fechaN_usuario3, this.pass_usuario3);
		icon2.confirmarAltaUsuario(true);
		String retorno = icon.identificarUsuario(id_usr3, icon.codificarPass(this.pass_usuario3));
		assertEquals("docente", retorno);
	}
	
	@Test
	public void test6_identificarUsaurioNick() throws NoSuchAlgorithmException, UsuarioRepetido {
		icon2.altaUsuario(this.nick_usuario4, this.correo_usuario4, "Anakin", "Skywalker", fechaN_usuario4, this.pass_usuario4);
		icon2.confirmarAltaUsuario(false);
		String retorno = icon.identificarUsuario(id_usr4, icon.codificarPass(this.pass_usuario4));
		assertEquals("estudiante", retorno);
	}
}
