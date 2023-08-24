package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}
	public static By getByLocator (String locator, String locatorType) {
		By by = null;
//		if (locator.startsWith("id=") || locator.startsWith("Id=") || locator.startsWith("ID=")) {
//			by = By.id(locator.substring(3));
//		}else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
//			by = By.className(locator.substring(6));
//		}else if (locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
//			by = By.name(locator.substring(5));
//		}else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
//			by = By.cssSelector(locator.substring(4));
//		}else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
//			by = By.xpath(locator.substring(6));
//		}else {
//			throw new RuntimeException("Locator type invalid");
//		}
		
		if (locatorType.equals("id")) {
			by = By.id(locator);
		}else if (locatorType.equals("class")) {
			by = By.className(locator);
		}else if (locatorType.equals("name")) {
			by = By.name(locator);
		}else if (locatorType.equals("css")) {
			by = By.cssSelector(locator);
		}else if (locatorType.equals("xpath")) {
			by = By.xpath(locator);
		}else {
			throw new RuntimeException("Locator type invalid");
		}
		
		return by;
	}
	public String getDynamicXpath(String locatorType, String...dynamicValue) {
		locatorType = String.format(locatorType, (Object[])dynamicValue);
		return locatorType;
	}
	
	public WebElement getElement (WebDriver driver, String locator, String locatorType) {
		return driver.findElement(getByLocator(locator, locatorType));
	}
	public void clickToElement (WebDriver driver, String locator, String locatorType) {
		getElement(driver, locator, locatorType).click();
	}
	public void clickToDynamicElement (WebDriver driver, String xpathLocator, String locatorType, String ... dynamicValue) {
		getElement(driver, getDynamicXpath(locatorType, dynamicValue), locatorType).click();
	}
	public void sendKeysToElement (WebDriver driver, String text,String locator, String locatorType) {
		getElement(driver, locator, locatorType).sendKeys(text);
	}
	public String getText (WebDriver driver,String locator, String locatorType) {
		return getElement(driver, locator, locatorType).getText();
	}
}
