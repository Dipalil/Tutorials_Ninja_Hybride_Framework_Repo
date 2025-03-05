package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
   private	WebElement passwordField;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
    private	WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasseordNotMatchingwarning;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
     
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String PasswordText) {
		passwordField.sendKeys(PasswordText);
	}
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String retriveEmailPasswordNotMatchingWarningMessageText() {
		
		String warningText = emailPasseordNotMatchingwarning.getText();
		return warningText;
		
	}
	
	
}
