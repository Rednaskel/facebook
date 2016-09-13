package cucumberTest;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import facebooksteps.DriverSteps;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature",
		glue = "facebooksteps"
		)
public class RunThatFacebook {

	@AfterClass
	public static void tearDown(){
		DriverSteps.closeDriver();
	}
	
}
