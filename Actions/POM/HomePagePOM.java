package POM;

import org.openqa.selenium.WebDriver;

import Common.BasePage;

public class HomePagePOM extends BasePage {
	WebDriver driver;
	public HomePagePOM (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToLoginLink() {
		clickToElement(driver, HomePageUI.DYNAMIC_HEADER_LINK, "class");
		
	}
	
	
}
