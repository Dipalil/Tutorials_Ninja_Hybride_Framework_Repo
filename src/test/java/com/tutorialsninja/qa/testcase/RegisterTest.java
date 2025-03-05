package com.tutorialsninja.qa.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	public RegisterTest() {
		super();
	}
	 public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		 registerPage	= homePage.selectRegisterOption();

	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyRegisteringAccountWithMandatoryFields() {
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword("12345");
		registerPage.enterPasswordConfim("12345");
		//registerPage.enterPassword(prop.getProperty("validPassword"));
		//registerPage.enterPasswordConfim(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicy();
		 accountSuccessPage = registerPage.clickOnCountinueButton();
				

		Assert.assertEquals(accountSuccessPage.retriverAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreadHeading"),"Account Success Page is Not displayed ");
		
		
		
	}
	@Test(priority=2)
	public void VerifyRegisteringAccountByProvidingAllFields() {
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword("12345");
		registerPage.enterPasswordConfim("12345");
		//registerPage.enterPassword(prop.getProperty("validPassword"));
		//registerPage.enterPasswordConfim(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnCountinueButton();
	

		Assert.assertEquals(accountSuccessPage.retriverAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreadHeading"),"Account Success Page is Not displayed ");

	}
	@Test(priority=3)
	public void VerifyRegisteringAccountWithExistingEmailAddress() {
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress("dipalilohar9370@gmail.com");
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword("12345");
		registerPage.enterPasswordConfim("12345");
		//registerPage.enterPassword(prop.getProperty("validPassword"));
		//registerPage.enterPasswordConfim(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnCountinueButton();

		
		
		Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message is not displayed");
	
		
		
	}
	
	@Test(priority=4)    
	 
	 public void VerifyRegisteringAccountWithoutFillingAnyDetails() {
		
		registerPage.clickOnCountinueButton();
		
	    Assert.assertTrue(registerPage.retrieveprivacyPolicyWarningWarning().contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy policy message is not displayed");
	    
	    Assert.assertEquals(registerPage.retrievrfirstNameWarning(), dataProp.getProperty("firstNameWarning"),"First name Warning message is not displayed");
	    
	    Assert.assertEquals(registerPage.retrievelastNameWarning(), dataProp.getProperty("lastNameWarning"),"Last name warning message is not displayed");
	    
	    Assert.assertEquals( registerPage.retrieveemailAddressWarning(), dataProp.getProperty("emailWarning"),"Email warning Message is displayed");
	    
	    Assert.assertEquals(registerPage.retrievetelephoneWarning(), dataProp.getProperty("telephoneWarning"),"Telephone Warning message is displayed");
	    
	    Assert.assertEquals(registerPage.retrievepasswordWarning(), dataProp.getProperty("passwordWarning"),"Password warning message is displayed");
	    		
	   }
	
	

}
