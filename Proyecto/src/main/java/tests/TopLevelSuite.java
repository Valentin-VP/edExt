package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Modificar solo si se definen nuevos niveles de suites. Siempre ejecutar esta Suite en JUnit
@SuiteClasses({LevelZeroSuite.class, LevelOneSuite.class, TestSuite.class})
@RunWith(Suite.class)
public class TopLevelSuite {}


