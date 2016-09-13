package facebooksteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import driverwrapper.DriverWrapper;
import driverwrapper.constants.DriverType;

public class DriverSteps {

	private static DriverWrapper driver = new DriverWrapper(DriverType.CHROME);
	private static String facebookUser = null;
	private static String facebookPassword = null;

	
	public String getFacebookUser() {
		return facebookUser;
	}

	public static void setFacebookUser(String facebookUser) {
		DriverSteps.facebookUser = facebookUser;
	}

	public static void closeDriver() {
		driver.close();
	}
	
	public String getFacebookPassword() {
		return facebookPassword;
	}
	
	public static void setFacebookPassword(String facebookPassword) {
		DriverSteps.facebookPassword = facebookPassword;
	}

	@Given("^I go to \"(.*)\" address$")
	public void I_go_to_facebook_com_page(String page) throws Throwable {
		driver.get(page);
	}
	
	@Given("^I log in$")
	public void I_log_in(){
		driver.facebookLogin(facebookUser, facebookPassword);
	}
	
	@Then("^Print me current facebook passes$")
	public void print_me_current_facebook_passes(){
		System.out.println(facebookUser);
		System.out.println(facebookPassword);
	}

	
}
