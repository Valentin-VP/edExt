package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtProgramaBase;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.ProgramaInexistente;
import excepciones.ProgramaRepetido;
import excepciones.ProgramaSinCursos;
import excepciones.SinCursos;
import excepciones.SinInstitutos;
import excepciones.SinProgramas;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoProgFormacion;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaProgFormacion;
import logica.Categoria;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicion;
import logica.ManejadorInstituto;
import logica.ManejadorProgFormacion;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgregarCursoProgTest {
	static Fabrica fabrica = null;
	static IControladorAltaCurso iconCurso = null; 
	static IControladorAgregarCursoProgFormacion icon = null; 
	static IControladorAltaProgFormacion iconAPF = null; 
	static ManejadorCurso mC = null;
	static ManejadorProgFormacion mPF = null;
	static ManejadorInstituto mI = null;
	static ManejadorCategoria mCat = null;
	
	DtFecha fechaA_uno = null;
	DtFecha fechaF_uno = null;
	DtFecha fechaI_uno = null;
	DtFecha fechaP_uno = null;
	
	String nombre_curso_uno = "curso_uno_agregarCursoProg";
	String nombre_curso_dos = "curso_dos_agregarCursoProg";
	String nombre_instituto_uno = "instituto_uno_agregarCursoProg";
	String nombre_categoria_uno = "categoria_uno_agregarCursoProg";
	String nombre_prog_uno = "prog_uno_agregarCursoProg";
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAgregarCursoAPF();
		iconCurso = fabrica.getIControladorAltaCurso();
		iconAPF = fabrica.getIControladorAltaProgFormacion();		
		//iconUser = fabrica.getIControladorAltaUsuario();
		mI = ManejadorInstituto.getInstancia();
		mPF = ManejadorProgFormacion.getInstancia();
		mC = ManejadorCurso.getInstancia();
		mCat = ManejadorCategoria.getInstancia();
	}
	
	@Before
	public void inicializarTest() {
		//Counter counter1 = new Counter();
		//this.estudiante1 = "e_winters_" + counter1.getValue();
		//this.estudiante2 = "c_redfield_" + counter1.getValue();
		//this.docente1 = "o_spencer_" + counter1.getValue();
		this.fechaA_uno = new DtFecha(1,1,2000);

		this.fechaF_uno = new DtFecha(31,12,2000);

		this.fechaI_uno = new DtFecha(1,1,2000);

		this.fechaP_uno = new DtFecha(1,1,2000);


	}
	

	
	@Test
	public void test02_listarProgramas() throws SinProgramas, ProgramaRepetido  {
		Counter counter = new Counter();
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		List<DtProgramaBase> progs = icon.getDtPFs();
		assertNotNull(progs);
	}
	

	
	@Test
	public void test04_listarCursos() throws SinCursos, CursoRepetido, InstitutoInexistente  {
		Counter counter = new Counter();
		Categoria categoria = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		Instituto instituto = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto);	
		iconCurso.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), "irrelevante", "1", 1, 1, "www.1", fechaA_uno);
		iconCurso.confirmarAltaCurso();
		List<DtCursoBase> cursos = icon.getDtCurso();
		assertNotNull(cursos);
	}
	
	@Test (expected = ProgramaInexistente.class)
	public void test05_agregarCursoProgInexistente() throws CursoRepetido, InstitutoInexistente, SinProgramas, ProgramaRepetido, CursoNoExiste, ProgramaInexistente {
		icon.agregarCurso("No", "No");
	}
	
	@Test (expected = CursoNoExiste.class)
	public void test06_agregarCursoProgCursoInexistente() throws CursoRepetido, InstitutoInexistente, SinProgramas, ProgramaRepetido, CursoNoExiste, ProgramaInexistente {
		Counter counter = new Counter();
		
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		icon.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
	}
	
	@Test (expected = CursoRepetido.class)
	public void test07_agregarCursoProgCursoRepetido() throws CursoRepetido, InstitutoInexistente, SinProgramas, ProgramaRepetido, CursoNoExiste, ProgramaInexistente {
		Counter counter = new Counter();
		Categoria categoria = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		Instituto instituto = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto);	
		iconCurso.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), "irrelevante", "1", 1, 1, "www.1", fechaA_uno);
		iconCurso.confirmarAltaCurso();
		
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		icon.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
		icon.confirmar();
		icon.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
	}
	
	@Test
	public void test08_agregarCursoProgUnCurso() throws CursoRepetido, InstitutoInexistente, SinProgramas, ProgramaRepetido, CursoNoExiste, ProgramaInexistente {
		Counter counter = new Counter();
		Categoria categoria = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		Instituto instituto = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto);	
		iconCurso.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), "irrelevante", "1", 1, 1, "www.1", fechaA_uno);
		iconCurso.confirmarAltaCurso();
		
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		icon.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
		icon.confirmar();
		assertNotNull(icon.getDtPFs());
	}
	
	@Test
	public void test09_agregarCursoProg() throws CursoRepetido, InstitutoInexistente, SinProgramas, ProgramaRepetido, CursoNoExiste, ProgramaInexistente {
		Counter counter = new Counter();
		Categoria categoria = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		Instituto instituto = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto);	
		iconCurso.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), "irrelevante", "1", 1, 1, "www.1", fechaA_uno);
		iconCurso.confirmarAltaCurso();
		iconCurso.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString(), "irrelevante", "2", 2, 2, "www.2", fechaA_uno);
		iconCurso.confirmarAltaCurso();
		
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		icon.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
		icon.confirmar();
		icon.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_dos+counter.getValue().toString());	
		icon.confirmar();
		assertNotNull(icon.getDtPFs());
	}
}
