package com.sm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sm.qa.base.TestBase;
import com.sm.qa.pages.HomePage;
import com.sm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.loginToSpringer(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getPageTitle(),"Home - Springer");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
