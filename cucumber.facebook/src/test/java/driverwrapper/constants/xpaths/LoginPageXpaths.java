package driverwrapper.constants.xpaths;

import org.openqa.selenium.By;

public class LoginPageXpaths {

	public static final By loginUsername = By.xpath("//input[@name='email']");
	public static final By loginPassword = By.xpath("//input[@name='pass']");
	public static final By loginButton = By.xpath("//label[@id='loginbutton']/input");
}
