package com.flightwebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.basepage.BaseTestClass;

public class CustomerRegistration extends BaseTestClass{
	
	//WebDriver driver;
	
	@FindBy(id="firstName")
	WebElement FirstName;
	@FindBy(id="lastName")
	WebElement LastName;
	@FindBy(id="email")
	WebElement Email;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(name="street")
	WebElement Street;
	@FindBy(name="city")
	WebElement City;
	@FindBy(name="zip")
	WebElement ZipCode;
	@FindBy(id="register-btn")
	WebElement RegisterButton;
	
	public CustomerRegistration(WebDriver driver) {
		super(driver);
		
	}
	
	public void goTo(String url) {
		this.driver.get(url);
	}
	
	public void enteruserdetail(String firstname,String lastname) {
		this.FirstName.sendKeys(firstname);
		this.LastName.sendKeys(lastname);
	}
	
	public void enterusercredentials(String email,String password) {
		this.Email.sendKeys(email);
		this.Password.sendKeys(password);
	}
	
	public void address(String street,String city,String zip) {
		this.Street.sendKeys(street);
		this.City.sendKeys(city);
		this.ZipCode.sendKeys(zip);
	}
	
	public void register() {
		this.RegisterButton.click();
		
	}

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.RegisterButton));
		return this.RegisterButton.isDisplayed();
	}

}
