package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Incluir aqui los Tests que deben ejecutarse en Primer Lugar por dependencia del estado de la DB
@SuiteClasses({ConsultaProgramaTest.class, AgregarCursoProgTest.class, AltaCursoTest.class, ListarAceptadosTest.class, AltaUsuarioTest.class, ConsultaEdicionCursoTest.class, SesionTest.class, AltaInstitutoTest.class, AltaEdicionCursoTest.class})
@RunWith(Suite.class)
public class LevelOneSuite {}
