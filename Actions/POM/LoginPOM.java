package POM;

import org.openqa.selenium.WebDriver;

import Common.BasePage;

public class LoginPOM extends BasePage{
	WebDriver driver;
	public LoginPOM (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToLoginBtn() {
		clickToDynamicElement(driver, LoginUI.LOGIN_BTN, "xpath","ico-login");
		
	}
	public String getErrorMessageAtEmailTxb() {
		
		return getText(driver, LoginUI.ERROR_MESSAGE_EMAIL,"id" );
	}
	public void inputEmail(String text) {
		sendKeysToElement(driver, text, LoginUI.EMAIL, "id");
		
	}
	public void inputPassword(String text) {
		sendKeysToElement(driver, text, LoginUI.PASSWORD, "id");

	}
	public String getErrorMessageAtNotRegisterEmailTxb() {
		
		return getText(driver, LoginUI.ERROR_MESSAGE_LOGIN, "xpath" );
	}
}
