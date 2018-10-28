package com.sm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sm.qa.base.TestBase;
import com.sm.qa.pages.DisciplinePage;
import com.sm.qa.pages.HomePage;
import com.sm.qa.pages.LoginPage;
import com.sm.qa.pages.SearchResultPage;
import com.sm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	DisciplinePage discPage;
	SearchResultPage searchPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyTitleTest() {
		String pageHeading = homePage.getHeading();
		System.out.println(pageHeading);
		Assert.assertEquals(pageHeading, "Providing researchers with access to millions of scientific documents from journals, books, series, protocols and reference works.");
	}
	
	@DataProvider
	public Object[][] getSearchTestData() {
		Object data[][] = TestUtil.getTestData("SearchTestData");
		return data;
	}
	
	@Test (dataProvider = "getSearchTestData")
	public void verifySearchFunctinalityTest (String searchString) {
		System.out.println("Verifying Search Functionality - ");
		searchPage = homePage.searchString(searchString);
		Assert.assertEquals(searchPage.verifySearchPageTitle(searchString), true);
		Assert.assertEquals(searchPage.verifySearchResultsDisplayed(searchString), true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
