package com.flightwebsite.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.basepage.BaseTestClass;

public class FlightConfirmation extends BaseTestClass{

	public static final Logger LOG=LoggerFactory.getLogger(FlightConfirmation.class);
	
	@FindBy(xpath="//*[@id='flights-confirmation-section']/div/div/div/form/div/div/div[1]/div[2]/p")
	WebElement flightconfirmation;
	
	@FindBy(xpath="//*[@id='flights-confirmation-section']/div/div/div/form/div/div/div[3]/div[2]/p")
	WebElement price;
	
	public FlightConfirmation(WebDriver driver) {
		super(driver);	
	}
	
	public String getprice() {
		String confirmation=this.flightconfirmation.getText();
		String price=this.price.getText();
		LOG.info("Flight confirmation# :{}",confirmation);
		LOG.info("price is :{}",price);
		return this.price.getText();
	}

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.price));
		return this.price.isDisplayed();
	}
   
	
	
}
