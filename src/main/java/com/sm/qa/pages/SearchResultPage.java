package com.sm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.sm.qa.base.TestBase;

public class SearchResultPage extends TestBase {
	
	// Page Factory - (Object Repository)
	
	public SearchResultPage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySearchResultsDisplayed(String searchString) {
		return driver.findElement(By.xpath("//h1[@class='number-of-search-results-and-search-terms']//strong[contains(text(),'"+ searchString +"')]")).isDisplayed();
	}
	
	
	public boolean verifySearchPageTitle (String title) {
		return driver.findElement(By.xpath("//a[@class='title'][contains(text(),'"+ title +"')]")).isDisplayed();
	}
	

}
