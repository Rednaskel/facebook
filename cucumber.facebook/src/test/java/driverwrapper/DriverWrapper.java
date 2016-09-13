package driverwrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverwrapper.constants.DriverType;
import driverwrapper.constants.SeleniumTimeouts;
import driverwrapper.constants.xpaths.LoginPageXpaths;
import driverwrapper.waitfactory.WaitFactory;

public class DriverWrapper {

	private WebDriver driver; 
	private WaitFactory waitFactory;
	
	public DriverWrapper(DriverType chrome) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver(options);
		waitFactory = new WaitFactory(driver);
		
	}

	public void close() {
		driver.close();
		driver.quit();
	}

	public void get(String page) {
		driver.get(page);
	}

	public void facebookLogin(String facebookUser, String facebookPassword) {
		waitFactory.getClickableElement(LoginPageXpaths.loginUsername).sendKeys(facebookUser);
		waitFactory.getClickableElement(LoginPageXpaths.loginPassword).sendKeys(facebookPassword);
		waitFactory.getClickableElement(LoginPageXpaths.loginButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
