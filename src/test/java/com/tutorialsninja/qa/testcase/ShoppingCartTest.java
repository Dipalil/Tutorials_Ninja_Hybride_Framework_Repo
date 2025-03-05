package com.tutorialsninja.qa.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest {
	@Test(priority=1)
	public void verifyNavigatingToShoppingCartPageFromTheSuccessMessage() {
 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("imac");
		 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		 driver.findElement(By.xpath("//img[@class=\"img-responsive\"]")).click();
		 driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 driver.findElement(By.linkText("Shopping Cart")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).isDisplayed());
		
		 
		 driver.quit();
		
	}
	
	@Test(priority=2)
	public void verifyNavigatingToShoppingCartPageFromSiteMapFooterPage() {
 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("imac");
		 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		 driver.findElement(By.xpath("//img[@class=\"img-responsive\"]")).click();
		 driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
		 driver.findElement(By.partialLinkText("Site M")).click();
		 driver.findElement(By.partialLinkText("Shopping Cart")).click(); 
		
		 driver.quit();
	}
	
	@Test(priority=3)
	public void verifyTheCartButtonWhenThereAreNoProductsAddedToTheShoppingCart() {
 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.get("https://tutorialsninja.com/demo/");
		 driver.findElement(By.partialLinkText("Shopping Cart")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[p='Your shopping cart is empty!']")).isDisplayed());
		 driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]")).click();
		 driver.quit();
		
	}

}
