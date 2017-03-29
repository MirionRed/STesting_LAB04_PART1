package my.edu.utar;
import org.junit.runner.RunWith;

import org.junit.runners.Suite;

import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)

@SuiteClasses(value = {
DemoSetupTest.class,
MyFirstClassTest.class
})
public class DemoTestSuite {

}


