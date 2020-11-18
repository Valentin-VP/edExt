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

public class LevelZeroSuite {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	static IControladorConsultaCurso iconConsultaCurso;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
		iconConsultaCurso = fabrica.getIControladorConsultaCurso();
	}
	
	@Test(expected = SinInstitutos.class)
	public void test1_NoHayInstitutosParaListar() throws SinInstitutos {
			ArrayList<DtInstituto> NoHayInstitutos = icon.listarInstitutos();
    }
	
	@Test
	public void test2_listarInstitutosInfoCursoSinInstitutos() throws SinInstitutos {
		iconConsultaCurso.listarInstitutos();
	}
	
	@Test
	public void test2_listarCategoriasInfoCursoSinInstitutos() throws SinCategorias {
		iconConsultaCurso.listarCategorias();
	}
}
