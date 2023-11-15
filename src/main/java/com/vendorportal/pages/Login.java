package com.vendorportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.basepage.BaseTestClass;

public class Login extends BaseTestClass{
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbutton;
	
	public Login(WebDriver driver) {
		super(driver);
	  }

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loginbutton));
		return this.loginbutton.isDisplayed() ;
	}
	
	public void goTo(String url) {
		this.driver.get(url);
	}
	
	public void vendorportallogin(String UserName,String Password) {
		this.username.sendKeys(UserName);
		this.password.sendKeys(Password);
		this.loginbutton.click();
	}

}
