package com.sm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.sm.qa.base.TestBase;

public class DisciplinePage extends TestBase{
	// Page Factory - (Object Repository)
	
	public DisciplinePage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisciplineDisplayed(String disciplineName) {
		return driver.findElement(By.xpath("//p[@class='facet-constraint-message']//a[contains(text(),'"+ disciplineName +"')]")).isDisplayed();
	}
	
}
