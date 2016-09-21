package driverwrapper.waitfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverwrapper.constants.SeleniumTimeouts;

public class WaitFactory {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitFactory(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, SeleniumTimeouts.DEFAULT_TIMEOUT);
	}
	
	public WebElement getPresentElement(By elementLocator){
		return wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
	}
	
	public WebElement getPresentElement(By elementLocator, int timeout){
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
	}
	
	public WebElement getClickableElement(By elementLocator){
		return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}

	public WebElement waitForElementToBeVisible(By elementLocator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		
	}
	
}
