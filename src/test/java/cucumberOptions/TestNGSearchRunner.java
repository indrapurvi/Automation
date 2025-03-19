package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/searchProduct.feature",glue="stepDefinitions",plugin= {"pretty"})
public class TestNGSearchRunner extends AbstractTestNGCucumberTests{

}
