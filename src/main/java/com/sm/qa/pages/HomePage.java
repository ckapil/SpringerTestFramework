package com.sm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	// Page Factory - (Object Repository)
	
	@FindBy(xpath = "//a[@id='register-link']")
	WebElement logIn;
	
	@FindBy(xpath = "//input[@id='query']")
	WebElement searchBox;
	
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchButton;
	
	public HomePage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage searchString(String text) {
		CharSequence keysToSend = text.subSequence(0, text.length());
		searchBox.sendKeys(keysToSend);
		searchButton.click();
		return new SearchResultPage();
	}
	
	public String getHeading() {
		return driver.findElement(By.xpath("//div[@id='intro']//h2")).getText();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public DisciplinePage selectDiscipline(String discipline) {
		// navigate to discipline specific results
		driver.findElement(By.xpath("//div[@id='Discipline']//a[contains(text(),'"+ discipline +"')]")).click();
		return new DisciplinePage();
	}
	
	// Click on login link
	public void clickLogIn() {
		logIn.click();
	}

	public LoginPage signIn() {
		// Go to login page
		this.clickLogIn();
		return new LoginPage();
	}
}
