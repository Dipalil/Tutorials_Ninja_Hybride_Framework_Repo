package com.tutorialsninja.qa.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;

public class LogOutTest {
	
	//LoginPage loginPage;

	
	
	

	
	
	
	 @Test(priority=1)
	  public void verifyLoggingOutBySelectingLogOutOption() {
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Login")).click();
		 driver.findElement(By.id("input-email")).sendKeys("dipalilohar9370@gmail.com");
		 driver.findElement(By.id("input-password")).sendKeys("123456");
	     driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	     
	    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	     driver.findElement(By.xpath("//span[text()='My Account']")).click();
	     
	     driver.findElement(By.linkText("Logout")).click();
	     driver.findElement(By.linkText("Continue")).click();
	     driver.quit();
	     
		
		  
	  }
	 @Test(priority=2)
	 
	  public void verifyLoggingOutBySelectingLogoutOptionFromRightColumnOption() {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Login")).click();
		 driver.findElement(By.id("input-email")).sendKeys("dipalilohar9370@gmail.com");
		 driver.findElement(By.id("input-password")).sendKeys("123456");
	     driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	     
	    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		 
		   driver.findElement(By.linkText("Logout")).click();
		   driver.findElement(By.linkText("Continue")).click();
		   driver.quit();
		   
	  }

}
