package driverwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import driverwrapper.constants.DriverType;
import driverwrapper.constants.FacebookAddress;
import driverwrapper.constants.xpaths.FriendsPage;
import driverwrapper.constants.xpaths.LoginPageXpaths;
import driverwrapper.constants.xpaths.MainPage;
import driverwrapper.waitfactory.WaitFactory;
import threading.FacebookPerson;

public class DriverWrapper {

	private WebDriver driver; 
	private WaitFactory waitFactory;
	private static Set<Cookie> cookies = null;
	private final int FACEBOOK_LINK_LENGTH_WITH_SLASH = 25;
	
	public DriverWrapper(DriverType chrome) {
		if(System.getProperty("webdriver.chrome.driver") == null){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		}
		driver = new ChromeDriver(getChromeOptions());
		if(cookies != null){
			setCookies(driver, cookies);
		}
		waitFactory = new WaitFactory(driver);
		
	}

	private ChromeOptions getChromeOptions(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		return options;
	}
	
	private void setCookies(WebDriver driver, Set<Cookie> cookies){
		if (cookies != null) {
			driver.get(FacebookAddress.FACEBOOK_ADDRESS);
			for (Cookie cookie : cookies) {
				driver.manage().addCookie(cookie);
			}
			driver.navigate().refresh();
		}
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
	}
	
	public void goToFriendsPage(){
		WebElement element = waitFactory.getClickableElement(MainPage.USER_PROFILE_LINK);
		String profilePageAddress = element.getAttribute("href");
		String friendsPage = profilePageAddress + "/friends"; 
		driver.get(friendsPage);
		waitFactory.waitForElementToBeVisible(FriendsPage.ALL_NAMES_LINKS);
	}

	public Set<Cookie> getCookies() {
		cookies = driver.manage().getCookies();
		return cookies;
	}
	
	public boolean isCookiePresent(){
		if(this.cookies == null){
			return false;
		}
		return true;
	}

	public List<FacebookPerson> getAllFriendsIds() {
		scrollUntilAllFriendsAreLoaded();		
		return getLoadedFriendsIds();
	}
	
	private void scrollUntilAllFriendsAreLoaded(){		
		WebElement loadingGif = waitFactory.getPresentElement(FriendsPage.LOADING_FRIENDS_GIF_BY);
		while(loadingGif != null){
			Actions scrollToLoad = new Actions(driver);
			scrollToLoad.moveToElement(loadingGif);
			scrollToLoad.perform();

			try {
				Thread.sleep(600);
				loadingGif = waitFactory.getPresentElement(FriendsPage.LOADING_FRIENDS_GIF_BY);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public List<FacebookPerson> getLoadedFriendsIds(){
		List<WebElement> friendsNamesElements = driver.findElements(FriendsPage.ALL_NAMES_LINKS);
		List<FacebookPerson> friends = new ArrayList<>();
		for (WebElement friendNameElement : friendsNamesElements) {
			System.out.println(friendNameElement.getText());
			String linkToFriend = friendNameElement.getAttribute("href");
			String friendFacebookId = linkToFriend.substring(FACEBOOK_LINK_LENGTH_WITH_SLASH,
					linkToFriend.indexOf("?"));
			if(friendFacebookId.equals("profile.php")){
				friendFacebookId = linkToFriend.substring(FACEBOOK_LINK_LENGTH_WITH_SLASH, 
					linkToFriend.indexOf("&"));
			}
			friends.add(new FacebookPerson(friendFacebookId));
			
		}
		return friends;	
	}
}

