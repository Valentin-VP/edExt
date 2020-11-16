package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Incluir aqui los Tests que deben ejecutarse en Primer Lugar por dependencia del estado de la DB
@SuiteClasses({AltaCursoTest.class, ListarAceptadosTest.class})
@RunWith(Suite.class)
public class LevelOneSuite {}
