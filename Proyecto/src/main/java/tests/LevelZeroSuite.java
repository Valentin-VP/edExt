package tests;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtInstituto;
import excepciones.SinInstitutos;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;

public class LevelZeroSuite {
	static Fabrica fabrica;
	static IControladorAltaUsuario icon;
	
	@BeforeClass
	public static void preparacionTests() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaUsuario();
	}
	
	@Test(expected = SinInstitutos.class)
	public void test1_NoHayInstitutosParaListar() throws SinInstitutos {
			ArrayList<DtInstituto> NoHayInstitutos = icon.listarInstitutos();
    }
}
