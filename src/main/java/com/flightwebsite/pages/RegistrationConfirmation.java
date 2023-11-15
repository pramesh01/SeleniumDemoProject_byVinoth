package com.flightwebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.basepage.BaseTestClass;

public class RegistrationConfirmation extends BaseTestClass {
	///WebDriver driver;
	
	@FindBy(id="go-to-flights-search")
	WebElement gotolightsearchbutton;
	
	public RegistrationConfirmation(WebDriver driver){
		super(driver);
	}
	
	public void gotoflightsearch() {
		this.gotolightsearchbutton.click();
	}

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.gotolightsearchbutton));
		return this.gotolightsearchbutton.isDisplayed();
	}

}
