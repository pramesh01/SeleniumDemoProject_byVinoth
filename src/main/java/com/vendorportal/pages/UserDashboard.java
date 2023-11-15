package com.vendorportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.basepage.BaseTestClass;
import com.flightwebsite.pages.FlightConfirmation;

public class UserDashboard extends BaseTestClass{

	public static final Logger LOG=LoggerFactory.getLogger(UserDashboard.class);
	
	@FindBy(id="monthly-earning")
	WebElement monthlyearningelement;
	
	@FindBy(id="annual-earning")
	WebElement annualyearningelement;
	
	@FindBy(id="profit-margin")
	WebElement profitmarginelement;
	
	@FindBy(id="available-inventory")
	WebElement availableinventoryelement;
	
	@FindBy(css="#dataTable_filter input")
	WebElement searchboxelement;
	
	@FindBy(css="#dataTable_info")
	WebElement textmessageelement;
	
	@FindBy(xpath="//*[@id='userDropdown']/img")
	WebElement profilepicelement;
	
	@FindBy(xpath="//*[@id='content']/nav/ul/li[4]/div/a[4]")
	WebElement profilepiclogoutelement;
	
	
	@FindBy(css="#logoutModal a")
	WebElement logoutbuttoninpopupbox;
	
	
	public UserDashboard(WebDriver driver) {
		super(driver);
		
	  }

	@Override
	public boolean isAT() {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchboxelement));
		return this.searchboxelement.isDisplayed();
	  }
	
	public String getMonthlyEarning() {
		return this.monthlyearningelement.getText();
	}
	
	public String getAnnualEarning() {
		return this.annualyearningelement.getText();
	}
	
	public String getProfitMargin() {
		return this.profitmarginelement.getText();
	}
	
	public String getAvailableInventory() {
		return this.availableinventoryelement.getText();
	}
	
	public void searchByText(String keywords) {
		this.searchboxelement.sendKeys(keywords);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getSearchResult() {
	String resultText=this.textmessageelement.getText();
	String [] arr=resultText.split(" ");
	int count=Integer.parseInt(arr[5]);
	LOG.info("Result count : {}",count);
	return count;
		
	}
	public void logout() {
		this.profilepicelement.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.profilepiclogoutelement));
		this.profilepiclogoutelement.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.logoutbuttoninpopupbox));
		this.logoutbuttoninpopupbox.click();
	 }
	

}
