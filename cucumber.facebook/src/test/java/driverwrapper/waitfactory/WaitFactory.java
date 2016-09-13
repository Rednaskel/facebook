package driverwrapper.waitfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverwrapper.constants.SeleniumTimeouts;

public class WaitFactory {

	private WebDriver driver;
	
	public WaitFactory(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getClickableElement(By xpath){
		return new WebDriverWait(driver, SeleniumTimeouts.DEFAULT_TIMEOUT)
		.until(ExpectedConditions.elementToBeClickable(xpath));
	}
	
}
