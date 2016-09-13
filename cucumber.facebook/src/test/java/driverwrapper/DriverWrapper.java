package driverwrapper;

import java.util.Set;

import javax.lang.model.element.Element;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import driverwrapper.constants.DriverType;
import driverwrapper.constants.FacebookAddress;
import driverwrapper.constants.xpaths.LoginPageXpaths;
import driverwrapper.constants.xpaths.MainPage;
import driverwrapper.waitfactory.WaitFactory;

public class DriverWrapper {

	private WebDriver driver; 
	private WaitFactory waitFactory;
	private static Set<Cookie> cookies = null;
	
	public DriverWrapper(DriverType chrome) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver(options);
		if (cookies != null) {
			driver.get(FacebookAddress.FACEBOOK_ADDRESS);
			for (Cookie cookie : cookies) {
				driver.manage().addCookie(cookie);
			}
		}
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
	
	public void goToFriendsPage(){
		WebElement element = waitFactory.getClickableElement(MainPage.USER_PROFILE_LINK);
		String profilePageAddress = element.getAttribute("href");
		String friendsPage = profilePageAddress + "friends?source_ref=pb_friends_tl";
		driver.get(friendsPage);
	}

	public Set<Cookie> getCookies() {
		cookies = driver.manage().getCookies();
		return cookies;
	}

}
