package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Steps {

	public static WebDriver driver;
	
	public Login_Steps() {
		if(driver==null){
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
@Given("^User is on Home Page$")
public void User_is_on_Home_Page() throws Throwable {
    
    //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //Launch the Online Store Website

    driver.get("http://www.store.demoqa.com");
}

@When("^User Navigate to LogIn Page$")
public void User_Navigate_to_LogIn_Page() throws Throwable {
    driver.findElement(By.xpath(".//*[@id='account']/a")).click();
}

//@When("^User enters \"Rednaskel\" and \"BumBumAraAra\"$")
@When("^User enters \"(.*)\" and \"(.*)\"$")
public void User_enters_UserName_and_Password(String username, String password) throws Throwable {
	driver.findElement(By.id("log")).sendKeys(username); 

    driver.findElement(By.id("pwd")).sendKeys(password);
    driver.findElement(By.id("login")).click();
}

@Then("^Message displayed Login Successfully$")
public void Message_displayed_Login_Successfully() throws Throwable {
    
    // Print a Log In message to the screen

    System.out.println("Login Successfully");
}

@When("^User LogOut from the Application$")
public void User_LogOut_from_the_Application() throws Throwable {
	new WebDriverWait(driver, 10).until(ExpectedConditions
			.elementToBeClickable(By.xpath(".//*[@id='account_logout']/a"))).click();
//	driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	 
     // Print a Log In message to the screen

     System.out.println("LogOut Successfully");

     // Close the driver

     driver.quit();
}

@Then("^Message displayed LogOut Successfully$")
public void Message_displayed_LogOut_Successfully() throws Throwable {
    driver.quit();
}

}
