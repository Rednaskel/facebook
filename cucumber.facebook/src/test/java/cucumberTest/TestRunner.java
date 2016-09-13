package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"stepdefinition"}
		)

public class TestRunner {
	public TestRunner(){
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		System.out.println("kpa");
	}
}