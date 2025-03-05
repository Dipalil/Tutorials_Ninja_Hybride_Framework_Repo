package com.tutorialsninja.qa.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest {
	@Test(priority=1)
	public void verifyAddingTheProductToCartFromProductDisplayPage() {
         WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		 driver.findElement(By.xpath("//img[@class=\"img-responsive\"]")).click();
		 driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 
		 
		 driver.quit();
	}
	
	@Test(priority=2)
	public void verifyAddingTheProductToCartFromWishListPage() {
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
		 driver.findElement(By.linkText("Wish List (4)")).click();
		 driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 
		 driver.quit();
	}
	/*
	@Test(priority=3)
	public void verifyAddingTheProductToCartFromSearchResultPage() {
 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
         driver.findElement(By.xpath("//button[@onclick=\"cart.add('40', '1');\"]")).click();
         Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
         driver.findElement(By.xpath("//button[@class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
         driver.findElement(By.partialLinkText("View C")).click();
         Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).isDisplayed());
         
         driver.quit();
		
	}*/

}
