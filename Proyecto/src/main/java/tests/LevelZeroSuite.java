package tests;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtInstituto;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;
import interfaces.IControladorInscripcionEdicionCurso;

public class LevelZeroSuite {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	static IControladorConsultaCurso iconConsultaCurso;
	static IControladorInscripcionEdicionCurso iconInscripcionEdicion;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		iconConsultaCurso = fabrica.getIControladorConsultaCurso();
		iconInscripcionEdicion = fabrica.getIControladorInscripcionEdicionCurso();
	}
	
	@Test (expected = SinInstitutos.class)
	public void test1_NoHayInstitutosParaListar() throws SinInstitutos {
			ArrayList<DtInstituto> NoHayInstitutos = icon.listarInstitutos();
    }
	
	@Test (expected = SinInstitutos.class)
	public void test2_listarInstitutosInfoCursoSinInstitutos() throws SinInstitutos {
		iconConsultaCurso.listarInstitutos();
	}
	
	@Test (expected = SinCategorias.class)
	public void test3_listarCategoriasInfoCursoSinInstitutos() throws SinCategorias {
		iconConsultaCurso.listarCategorias();
	}
	
	@Test (expected = SinInstitutos.class)
	public void test1_listarInstitutos() throws SinInstitutos {
		ArrayList<DtInstituto> institutos = iconInscripcionEdicion.listarInstitutos();
	}
	
}
