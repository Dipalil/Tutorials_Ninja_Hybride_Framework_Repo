package com.tutorialsninja.qa.testcase;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	 LoginPage loginPage;
	
	public LoginTest() {
		super();
	}
	
   public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		
         
		 driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		 HomePage homePage = new HomePage(driver);
		 homePage.clickOnMyAccount();
		  loginPage = homePage.selectLoginOption();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1 ,dataProvider = "validCredentialsSupplier")
	public void VerifyLoginWithValidCredentials(String email,String password) {
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		Assert.assertTrue(loginPage.clickOnLoginButton().getDisplayStatusOfEditYourAccountInformationOption());
		
		
		
		}
	
	@DataProvider(name="validCredentialsSupplier")
	
	public Object[][] supplyTestData(){
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
	   @Test(priority=2)
	   public void VerifyLoginWithInvalidCredentials() {
			loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
            loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
            loginPage.clickOnLoginButton();
			
			Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning message is not displayed");
	   
	   }
	   
	   @Test(priority=3)
	   
	    public void VerifyLoginWithInvalidEmailAndValidPassword() {
			loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
            loginPage.enterPassword("12345");
            loginPage.clickOnLoginButton();
			Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning message is not displayed");

		   
		   
	    	
	    }
	   @Test(priority=4)
	   
	   public void VerifyLoginWithValidEmailAndInvalidPassword() {
		   loginPage.enterEmailAddress(prop.getProperty("validEmail"));
           loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		   loginPage.clickOnLoginButton();
		   Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains( dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning message is not displayed");

		   
	   }
	   
	   @Test(priority=5)
	   
	   public void VerifyLoginWithoutProvidingcredentials() {
           loginPage.clickOnLoginButton();	
           Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning message is not displayed");

	   }
	   
	   
	   
	   
	   
	   
	 
	   
	   
	   

}
