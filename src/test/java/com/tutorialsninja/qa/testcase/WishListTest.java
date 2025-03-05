package com.tutorialsninja.qa.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class WishListTest extends Base {
	LoginTest logintest = new LoginTest();
	
	 @Test(priority=1)
	 public void verifyAddingAProductToWishListPageFromProductDisplayPage(){
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
		 
		 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		 driver.findElement(By.xpath("//button[@data-original-title=\"Add to Wish List\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 driver.quit();
		 
		 
		 
		 
	 }
	 
	 @Test(priority=2)
	 public void verifyAddingAProductToWishListPageFromTheProductThatIsDisplayedInTheRelatesProductSectionOfProductDisplayPage() {
		 
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
		 
		 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("macBook");
		 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		 driver.findElement(By.linkText("MacBook")).click();
		 driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 driver.quit();
	
	 }
	 /*
	 @Test(priority=3)
	 public void verifyAddingAProductToWishListPageFromTheProductThatIsDisplayedInTheFeaturedSectionOfHomePage() {
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
	    
	    driver.findElement(By.xpath("//i[@class=\"fa fa-home\"]")).click();
	    driver.findElement(By.xpath("//button[@aria-describedby=\"tooltip130294\"]")).click();
	
	    
	   Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 driver.quit();
	    
		 
	 } */
	 
	 @Test(priority=4)
	 public void verifyAddingTheProductToWishListFromTheProductDisplayedIntheCategoryOrSubCategoryPage() {
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
	    driver.findElement(By.linkText("Desktops")).click();
	    driver.findElement(By.linkText("Show AllDesktops")).click();
		driver.findElement(By.linkText("-Mac (1)")).click(); 
		driver.findElement(By.xpath("//button[@data-original-title=\"Add to Wish List\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 driver.quit();
	    
		 
	 }
	 
		 
	 

}
