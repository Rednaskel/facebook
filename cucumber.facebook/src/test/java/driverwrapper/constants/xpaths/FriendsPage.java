package driverwrapper.constants.xpaths;

import org.openqa.selenium.By;

public class FriendsPage {

	public static final By ALL_NAMES_LINKS = By
			.xpath("//ul[@data-pnref='friends']//a[@data-hovercard and text()]");
	public static final By LOADING_FRIENDS_GIF_BY = By
			.xpath("//ul/following-sibling::img");
	
	public static final String EXTENDED_FRIEDNS_LIST_XPATH = 
			"//ul[contains(@class,'expandedList')][%d]//a[text() and @data-hovercard]";
	
	//ul[contains(@class,'expandedList')][1]//a[text() and @data-hovercard]
}
