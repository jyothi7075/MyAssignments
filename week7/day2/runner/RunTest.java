package week7.day2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/week7/day2/feature/leaftapsCreateLead.feature", glue="week7/day2/stepdef")
public class RunTest extends AbstractTestNGCucumberTests{

}
