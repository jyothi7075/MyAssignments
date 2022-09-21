package marathon.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/marathon/feature/servicenow.feature", glue="marathon/stepsdef")
public class RunTest extends AbstractTestNGCucumberTests {

}
