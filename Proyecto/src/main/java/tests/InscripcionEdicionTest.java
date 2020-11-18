package tests;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoEstudiante;
import excepciones.UsuarioNoExiste;
import interfaces.Fabrica;
import interfaces.IControladorInscripcionEdicionCurso;
import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Edicion;
import logica.Estudiante;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InscripcionEdicionTest {
	static Fabrica fabrica;
	static IControladorInscripcionEdicionCurso icon;
	static ManejadorInstituto mI;
	static ManejadorUsuario mU;
	static ManejadorCurso mC;
	static ManejadorEdicion mE;
	static ManejadorCategoria mCat;
	String instituto1 = "";
	String instituto2 = "";
	static Instituto ins1;
	static Instituto ins2;
	String categoria1 = "";
	String categoria2 = "";
	String estudiante1 = "";
	String estudiante2 = "";
	String docente1 = "";
	String docente2 = "";
	String curso1 = "";
	String curso2 = "";
	static Curso c1;
	Curso c2;
	String edicion1 = "";
	String edicion2 = "";
	static Edicion ed1;
	static Edicion ed2;
	DtFecha factual;
	//InscripcionEd ied1 = null;
	//InscripcionEd ied2 = null;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorInscripcionEdicionCurso();
		mI = ManejadorInstituto.getInstancia();
		mU = ManejadorUsuario.getInstancia();
		mC = ManejadorCurso.getInstancia();
		mE = ManejadorEdicion.getInstancia();
		mCat = ManejadorCategoria.getInstancia();
		//mC = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		LocalDate hoy = LocalDate.now();
		this.factual = new DtFecha(hoy.getDayOfMonth(),hoy.getMonthValue(),hoy.getYear());
		//this.ins1 = mI.find("fing1");
		//this.est1 = mU.findUsuario("est1");
		//this.c1 = mC.find("c2");
		//this.ed1 = mE.find("Ed2");
		Counter counter = new Counter();
		
		this.categoria1 = "cat" +  counter.getValue();
		System.out.println(this.categoria1);
		this.categoria2 = "cat_jedis" + counter.getValue();
		System.out.println(this.categoria2);
		
		this.instituto1 = "ins" +  counter.getValue();
		System.out.println(this.instituto1);
		this.instituto2 = "ins_jedis" + counter.getValue();
		System.out.println(this.instituto2);
		
		this.estudiante1 = "est" +  counter.getValue();
		System.out.println(this.estudiante1);
		this.estudiante2 = "est_jedis" + counter.getValue();
		System.out.println(this.estudiante2);
		
		this.docente1 = "doc" +  counter.getValue();
		System.out.println(this.docente1);
		this.docente2 = "doc_jedis" + counter.getValue();
		System.out.println(this.docente2);
		
		this.curso1 = "curso" +  counter.getValue();
		System.out.println(this.curso1);
		this.curso2 = "curso_jedis" + counter.getValue();
		System.out.println(this.curso2);
		
		this.edicion1 = "edicion" + counter.getValue();
		System.out.println(this.edicion1);
		this.edicion2 = "edicion_jedis" + counter.getValue();
		System.out.println(this.edicion2);
	}
	
	@Test (expected = SinInstitutos.class)
	public void test1_listarInstitutos() throws SinInstitutos {
		icon.listarInstitutos();
	}
	
	@SuppressWarnings("static-access")
	@Test (expected = CursoNoExiste.class)
	public void test2_seleccionarInstituto() throws CursoNoExiste, ParseException {
		Instituto i = new Instituto(this.instituto1);
		Instituto i2 = new Instituto(this.instituto2);
		this.ins1 = i;
		this.ins2 = i2;
		mI.agregarInstituto(i);
		mI.agregarInstituto(i2);
		
		// Fecha realizacion random
		int minyear = 2010;
		int maxyear = 2020;
		int year = (int)(Math.random()*(maxyear-minyear+1)+minyear);
		int minmes = 1;
		int maxmes = 11;
		int mesr = (int)(Math.random()*(maxmes-minmes+1)+minmes);
		int mindia = 1;
		int maxdia = 31;
		int diar = (int)(Math.random()*(maxdia-mindia+1)+mindia);
		DtFecha r = new DtFecha(diar,mesr,year);
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria ca1 = new Categoria(this.categoria1);
		Categoria ca2 = new Categoria(this.categoria2);
		mCat.agregarCategoria(ca1);
		mCat.agregarCategoria(ca2);
		categorias.add(ca1);
		Curso cur1 = new Curso(this.curso1,"nose","10 horas",5,10,r.DtFechaToDate(),"www",null,categorias);
		this.c1 = cur1;
		categorias.add(ca2);
		Curso cur2 = new Curso(this.curso2,"nose","10 horas",5,10,r.DtFechaToDate(),"www",null,categorias);
		this.c2 = cur2;

		i.agregarCurso(cur1);
		i.agregarCurso(cur2);
		mI.agregarInstituto(i);
		mC.agregarCurso(cur1);
		mC.agregarCurso(cur2);
		
		icon.seleccionarInstituto(i.getNombre());
	}
	
	@SuppressWarnings("static-access")
	@Test (expected = EdicionVigenteNoExiste.class)
	public void test3_seleccionarCurso() throws EdicionVigenteNoExiste, ParseException{
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
		DtFecha fechaIv = new DtFecha(15,10,2015);
		DtFecha fechaFv = new DtFecha(15,10,2022);
		Edicion e1 = new Edicion(this.edicion1, fechaIv.DtFechaToDate(), fechaFv.DtFechaToDate(), false, 0, factual.DtFechaToDate());
		Edicion e2 = new Edicion(this.edicion2, fechaI.DtFechaToDate(), fechaF.DtFechaToDate(), true, 10, factual.DtFechaToDate());
		this.ed1 = e1;
		this.ed2 = e2;
		Curso c = mC.find(c1.getNombre());
		c.addEdicion(e1);
		c.addEdicion(e2);
		
		mC.agregarCurso(c);
		mE.agregarEdicion(e1);
		mE.agregarEdicion(e2);
		
		icon.seleccionarCurso(c.getNombre());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test4_registrarInscripcionEd() throws UsuarioNoExiste, UsuarioNoEstudiante, ParseException {
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
		// (String nick, String nombre, String apellido, String correo, Date  fechaNac, String password)
		
		// (String nick, String nombre, String apellido, String correo, Date  fechaNac, String password) {
		Estudiante est1 = new Estudiante(this.estudiante1,"est1","nose", "est1@gmail.com", fnac.DtFechaToDate(), "j2343ka34sdbyq623");
		Estudiante est2 = new Estudiante(this.estudiante2,"est2","nose", "est2@gmail.com", fnac.DtFechaToDate(), "asd3549as34d732asd");
		
		// Docente(String nick, String nombre, String apellido, String correo, Date fechaNac, Instituto instituto, String password)
		Docente doc1 = new Docente(this.docente1,"doc1","nose","doc1@gmail.com",fnac.DtFechaToDate(),this.ins1,"23472364asdwqe213");
		Docente doc2 = new Docente(this.docente2,"doc2","nose","doc2@gmail.com",fnac.DtFechaToDate(),this.ins2,"lkkhgñojoijodwqe213");
		((Docente) doc1).addDictaEdicion(this.ed1);
		((Docente) doc1).addDictaEdicion(this.ed2);
		
		mU.agregarUsuario(est1);
		mU.agregarUsuario(est2);
		mU.agregarUsuario(doc1);
		mU.agregarUsuario(doc2);		
		
		icon.registrarInscripcionEd(est1.getNick(), est1.getCorreo(), c1.getNombre(), factual);
	}
	
	@Test
	public void test5_confirmar() throws InscripcionEdRepetido, EdicionVigenteNoExiste, UsuarioNoExiste {
		icon.confirmar();
	}
	
	@Test
	public void test6_cancelar() {
		icon.cancelar();
	}
}

