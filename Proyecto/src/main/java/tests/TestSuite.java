package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Incluir aqui los tests independientes del estado de la DB
@RunWith(Suite.class)
@SuiteClasses({ AltaCategoriaTest.class})
public class TestSuite {}
