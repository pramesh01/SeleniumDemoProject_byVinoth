package com.flightwebsite.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.basepage.BaseTestClass;

public class SelectFlights extends BaseTestClass{
	
	@FindBy(name="departure-flight")
	List<WebElement> alldepartureoptions;
	
	@FindBy(name="arrival-flight")
	List<WebElement> allarrivaloptions;
	

	@FindBy(id="confirm-flights")
	WebElement confirmFlights;
	
	public SelectFlights(WebDriver driver) {
		super(driver);
	}
	
	public void selectflights() {
		int random=ThreadLocalRandom.current().nextInt(0,alldepartureoptions.size());
		this.alldepartureoptions.get(random).click();
		this.allarrivaloptions.get(random).click();
		
	}
     public void confirmflight() {
    	 this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmFlights));
    	 JavascriptExecutor executor = (JavascriptExecutor)driver;
    	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	     executor.executeScript("arguments[0].click();", this.driver.findElement(By.id("confirm-flights")));
    	 //this.confirmFlights.click();
       }

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlights));
		return this.confirmFlights.isDisplayed();
	}
}
