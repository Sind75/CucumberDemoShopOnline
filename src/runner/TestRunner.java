package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"E:\\HCL\\java\\mavenLink\\feature\\register.feature",
		"E:\\HCL\\java\\mavenLink\\feature\\login.feature",
		"E:\\HCL\\java\\mavenLink\\feature\\addToCart.feature"}, glue = "stepDefinitions")
public class TestRunner {

}
