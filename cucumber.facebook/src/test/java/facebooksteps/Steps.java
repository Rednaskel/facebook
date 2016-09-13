package facebooksteps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;


public class Steps {

	private static WebDriver driver = null;
	

	
	public Steps() {
		if(driver == null){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver(options);
		}
	}
	
	@Given("^I am logged in$")
	public void getFacebookLogin(){
		System.out.println("bumbuasdkalkdoaWWWWWWWWWWWWWw GGGGGGGGGG");
	}
	
	@Given("^I go to \"(.*)\" address$")
	public void I_go_to_facebook_com_page(String page) throws Throwable {
		driver.get(page);
	}

	@Given("^I log in$")
	public void I_log_in() throws Throwable {
		
	}

	public static void closeDriver() {
		if(driver != null){
		driver.close();
		driver.quit();
		}
		
	}
	
}
