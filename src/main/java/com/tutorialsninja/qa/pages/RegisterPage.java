package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	 private WebElement firstNameField;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	private WebElement telephoneField;

	@FindBy(xpath="//input[@id=\"input-password\"]")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id=\"input-confirm\"]")
	private WebElement PasswordConfimfield;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name=\"newsletter\"][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,' alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningWarning;
	
	@FindBy(xpath="//input[@id=\"input-firstname\"]/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id=\"input-email\"]/following-sibling::div")
	private WebElement emailAddressWarning;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id=\"input-password\"]/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String retrieveprivacyPolicyWarningWarning() {
		String privacyPolicyWarningWarningText = privacyPolicyWarningWarning.getText();
		return privacyPolicyWarningWarningText;
	}
	
	public String retrievrfirstNameWarning() {
		String firstNameWarningText =firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrievelastNameWarning() {
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveemailAddressWarning() {
		String emailAddressWarningText = emailAddressWarning.getText();
		return emailAddressWarningText;
	}
	
	public String retrievetelephoneWarning() {
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrievepasswordWarning() {
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailAddress) {
		emailAddressField.sendKeys(emailAddress);
	}
	
	public void enterTelephoneNumber(String telephoneNumber) {
		telephoneField.sendKeys(telephoneNumber);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys( passwordText);
	}
	
	public void enterPasswordConfim(String confimText) {
		PasswordConfimfield.sendKeys(confimText);
	}
	
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnCountinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsletterOption() {
		yesNewsletterOption.click();
	}
	
	public String retrieveDuplicateEmailAddressWarning() {
		String duplicateEmailAddressWarningText = duplicateEmailAddressWarning.getText();
		return duplicateEmailAddressWarningText;
	}
}
