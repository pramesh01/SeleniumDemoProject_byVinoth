package com.flightwebsite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.basepage.BaseTestClass;

public class FlightSearch extends BaseTestClass{
	
	@FindBy(id="passengers")
	WebElement selectPassenger;
	
	@FindBy(id="search-flights")
	WebElement searchFlightsButton;
	
	public FlightSearch(WebDriver driver) {
		super(driver);
	}
	
	public void selectpassengercount(String noofpassenger) {
		Select s=new Select(this.selectPassenger);
		s.selectByValue(noofpassenger);
	}
	
	public void searchflight() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.searchFlightsButton));
		JavascriptExecutor executor = (JavascriptExecutor) this.driver;
	     executor.executeScript("arguments[0].click();", this.driver.findElement(By.id("search-flights")));
		//this.searchFlightsButton.click();
	}

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightsButton));
		return this.searchFlightsButton.isDisplayed();
	}

}
