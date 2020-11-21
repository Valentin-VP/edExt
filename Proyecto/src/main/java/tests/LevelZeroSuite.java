package tests;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtInstituto;
import datatypes.DtProgramaBase;
import datatypes.DtUsuarioBase;
import excepciones.SinCategorias;
import excepciones.SinCursos;
import excepciones.SinInstitutos;
import excepciones.SinProgramas;
import excepciones.SinUsuarios;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoProgFormacion;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;
import interfaces.IControladorConsultaPrograma;
import interfaces.IControladorInscripcionEdicionCurso;
import interfaces.IControladorListarAceptadosAUnaEdicionDeCurso;
import interfaces.IControladorModificarDatosUsuario;

public class LevelZeroSuite {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	static IControladorConsultaCurso iconConsultaCurso;
	static IControladorInscripcionEdicionCurso iconInscripcionEdicion;
	static IControladorListarAceptadosAUnaEdicionDeCurso iconListarAceptados;
	static IControladorAgregarCursoProgFormacion iconAgregarCursoProg; 
	static IControladorConsultaPrograma iconConsultaPrograma; 
	static IControladorModificarDatosUsuario iconModificarDatosUsuario;
	static IControladorAltaCurso iconAltaCurso;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		iconConsultaCurso = fabrica.getIControladorConsultaCurso();
		iconInscripcionEdicion = fabrica.getIControladorInscripcionEdicionCurso();
		iconListarAceptados = fabrica.getIControladorListarAceptadosAUnaEdicionDeCurso();
		iconAgregarCursoProg = fabrica.getIControladorAgregarCursoAPF();
		iconConsultaPrograma = fabrica.getIControladorConsultaPrograma();
		iconModificarDatosUsuario = fabrica.getIControladorModificarDatosUsuario();
		iconAltaCurso = fabrica.getIControladorAltaCurso();
	}
	
	@Test
	public void test1_listarInstitutos() throws SinInstitutos {
		assertThrows(SinInstitutos.class, () -> {
			ArrayList<DtInstituto> institutos = iconInscripcionEdicion.listarInstitutos();
		});
	}
	
	@Test (expected = SinInstitutos.class)
	public void test2_listarInstitutoSinInstitutos() throws SinInstitutos {
		ArrayList<DtInstituto> instNoExiste = iconListarAceptados.listarInstitutos();
	}
	
	@Test (expected = SinInstitutos.class)
	public void test3_NoHayInstitutosParaListar() throws SinInstitutos {
		iconAltaCurso.listarInstitutos();
    }
	
	@Test (expected = SinInstitutos.class)
	public void test4_listarInstitutosInfoCursoSinInstitutos() throws SinInstitutos {
		iconConsultaCurso.listarInstitutos();
	}
	
	@Test (expected = SinInstitutos.class)
	public void test5_listarInstitutosSinInstitutos() throws SinInstitutos {
		iconAltaCurso.listarInstitutos();
	}
	
	@Test (expected = SinCategorias.class)
	public void test6_listarCategoriasInfoCursoSinInstitutos() throws SinCategorias {
		iconConsultaCurso.listarCategorias();
	}
	
	@Test (expected = SinCategorias.class)
	public void test7_listarCategoriasNoExistenCategorias() throws SinCategorias{
		iconAltaCurso.listarCategorias();
	}
	
	
	@Test (expected = SinProgramas.class)
	public void test8_listarProgramasSinProgACPF() throws SinProgramas {
		List<DtProgramaBase> progNoExiste = iconAgregarCursoProg.getDtPFs();
	}
	
	@Test(expected = SinCursos.class)
	public void test9_listarCursosSinCursos() throws SinCursos  {

		List<DtCursoBase> sincursos = iconAgregarCursoProg.getDtCurso();
	}
	
	@Test (expected = SinProgramas.class)
	public void test10_listarProgramasSinProgConsulta() throws SinProgramas {
		List<DtProgramaBase> progNoExiste = iconConsultaPrograma.listarProgramas();
	}
	
	@Test
	public void test11_mostrarUsuarios() throws SinUsuarios {
		assertThrows(SinUsuarios.class, () -> {
			ArrayList<DtUsuarioBase> usuarios = iconModificarDatosUsuario.mostrarUsuarios();
		});
	}
	
}
