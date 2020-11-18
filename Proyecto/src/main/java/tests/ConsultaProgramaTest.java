package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtPrograma;
import datatypes.DtProgramaBase;
import excepciones.CursoNoExiste;
import excepciones.CursoRepetido;
import excepciones.InstitutoInexistente;
import excepciones.ProgramaInexistente;
import excepciones.ProgramaRepetido;
import excepciones.ProgramaSinCursos;
import excepciones.SinProgramas;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoProgFormacion;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorConsultaPrograma;
import logica.Categoria;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorInstituto;
import logica.ManejadorProgFormacion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultaProgramaTest {

	static Fabrica fabrica = null;
	static IControladorAltaCurso iconCurso = null; 
	static IControladorAgregarCursoProgFormacion iconACPF = null; 
	static IControladorAltaProgFormacion iconAPF = null; 
	static IControladorConsultaPrograma icon = null; 
	static ManejadorCurso mC = null;
	static ManejadorProgFormacion mPF = null;
	static ManejadorInstituto mI = null;
	static ManejadorCategoria mCat = null;
	
	DtFecha fechaA_uno = null;
	DtFecha fechaF_uno = null;
	DtFecha fechaI_uno = null;
	DtFecha fechaP_uno = null;
	
	String nombre_curso_uno = "curso_uno_consultaPrograma";
	String nombre_instituto_uno = "instituto_uno_consultaPrograma";
	String nombre_categoria_uno = "categoria_uno_consultaPrograma";
	String nombre_prog_uno = "prog_uno_consultaPrograma";
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaPrograma();
		iconCurso = fabrica.getIControladorAltaCurso();
		iconAPF = fabrica.getIControladorAltaProgFormacion();	
		iconACPF = fabrica.getIControladorAgregarCursoAPF();
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
		List<DtProgramaBase> progs = icon.listarProgramas();
		assertNotNull(progs);
	}
	
	@Test (expected = ProgramaInexistente.class)
	public void test03_selectProgramaInexistente() throws ProgramaInexistente, ProgramaSinCursos {
		DtPrograma progNoExiste = icon.seleccionarPrograma("NO");
	}
	
	@Test	//no hace throw en el codigo
	public void test04_selectProgramaSinCursos() throws ProgramaInexistente, ProgramaSinCursos, ProgramaRepetido {
		Counter counter = new Counter();
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		DtPrograma progSinCursos = icon.seleccionarPrograma(nombre_prog_uno+counter.getValue().toString());
		assertNotNull(progSinCursos);
	}
	
	@Test
	public void test05_selectPrograma() throws ProgramaInexistente, ProgramaSinCursos, ProgramaRepetido, CursoRepetido, InstitutoInexistente, CursoNoExiste {
		Counter counter = new Counter();
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		
		Categoria categoria = new Categoria(nombre_categoria_uno+counter.getValue().toString());
		mCat.agregarCategoria(categoria);
		iconCurso.agregarCategoria(nombre_categoria_uno+counter.getValue().toString());
		Instituto instituto = new Instituto(nombre_instituto_uno+counter.getValue().toString());
		mI.agregarInstituto(instituto);	
		iconCurso.altaCurso(nombre_instituto_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString(), "irrelevante", "1", 1, 1, "www.1", fechaA_uno);
		iconCurso.confirmarAltaCurso();
		iconACPF.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
		iconACPF.confirmar();
		DtPrograma progSinCursos = icon.seleccionarPrograma(nombre_prog_uno+counter.getValue().toString());
		assertNotNull(progSinCursos);
	}
	
	@Test (expected = ProgramaInexistente.class)
	public void test06_listarCursosProgramaInexistente() throws ProgramaInexistente, ProgramaSinCursos {
		ArrayList<DtCurso> progNoExiste = icon.listarCursosPrograma("NO");
	}
	
	@Test (expected = ProgramaSinCursos.class)
	public void test07_listarCursosProgramaSinCursos() throws ProgramaInexistente, ProgramaSinCursos, ProgramaRepetido {
		Counter counter = new Counter();
		Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		iconAPF.ingresarProgFormacion(nombre_prog_uno+counter.getValue().toString(), "irrelevante", fechaI_uno, fechaF_uno, date);
		iconAPF.confirmar();
		ArrayList<DtCurso> progSinCursos = icon.listarCursosPrograma(nombre_prog_uno+counter.getValue().toString());
		//assertNotNull(progSinCursos);
	}
	
	@Test
	public void test08_listarCursosPrograma() throws CursoRepetido, InstitutoInexistente, SinProgramas, ProgramaRepetido, ProgramaSinCursos, ProgramaInexistente, CursoNoExiste {
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
		iconACPF.agregarCurso(nombre_prog_uno+counter.getValue().toString(), nombre_curso_uno+counter.getValue().toString());
		iconACPF.confirmar();
		ArrayList<DtCurso> prog = icon.listarCursosPrograma(nombre_prog_uno+counter.getValue().toString());
		assertNotNull(prog);
	}

}
