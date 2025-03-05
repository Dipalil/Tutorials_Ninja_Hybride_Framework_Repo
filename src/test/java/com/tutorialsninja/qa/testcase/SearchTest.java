package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest  extends Base{
	SearchPage searchPage;
	public SearchTest() {
		super();
	}
	
	 public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		 driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
		
	
	@Test(priority=1)
	public void VerifySearchWithValidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
		searchPage= homePage.clickOnSearchButton();
		Assert.assertTrue(searchPage.displayStatusOfHPvalidProduct(),"Valid product HP is not displayed in the search result");
		
			
			
		
	}
	@Test(priority=2)
	
	public void VerifySearchInvalidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
		searchPage = homePage.clickOnSearchButton();
   		Assert.assertEquals(searchPage.retrievenoProductMessageText(), "abcd","No Product in the Search Result is not Displayed");
		
	}
	@Test(priority=3 ,dependsOnMethods= {"VerifySearchInvalidProduct","VerifySearchWithValidProduct"})
	
	public void VerifySearchWithoutProvidingAnyProduct() {
		HomePage homePage = new HomePage(driver);
		searchPage=homePage.clickOnSearchButton();
		Assert.assertEquals(searchPage.retrievenoProductMessageText(), dataProp.getProperty("NoProductTextInSearchResult"),"No Product in the Search Result is not Displayed");
		

		
	}
				

		
	

}
