package com.sm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//input[@id='login-box-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='login-box-pw']")
	WebElement password;

	@FindBy(xpath = "//button[@title='Log in']")
	WebElement loginButton;

	public LoginPage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Set user name
	public void setUserName(String strUserName) {
		email.sendKeys(strUserName);
	}

	// Set password
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	// Click on login button
	public void clickLogin() {
		loginButton.click();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public HomePage loginToSpringer(String strUserName, String strPasword) {
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();

		return new HomePage();
	}

}
