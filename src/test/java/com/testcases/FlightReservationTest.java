package com.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.flightwebsite.pages.CustomerRegistration;
import com.flightwebsite.pages.FlightConfirmation;
import com.flightwebsite.pages.FlightSearch;
import com.flightwebsite.pages.RegistrationConfirmation;
import com.flightwebsite.pages.SelectFlights;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightReservationTest extends BaseTest{
	
	//public WebDriver driver;
	public String noofPassengers;
	public String expectedprice;
	
	@BeforeTest
	@Parameters({"noofPassengers","expectedprice"})
	public void setPageParameters(String noofPassengers,String expectedprice) {
		this.noofPassengers=noofPassengers;
		this.expectedprice=expectedprice;
		//below is driver setups.
		//WebDriverManager.chromedriver().setup();
		//this.driver=new ChromeDriver();
		//this.driver.manage().window().maximize();
		//this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/*@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}*/
	
	@Test
	public void registrationflow() {
		
		CustomerRegistration cr=new CustomerRegistration(driver);
		cr.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
		Assert.assertTrue(cr.isAT());
		cr.enteruserdetail("Pramesh","Kumar");
		cr.enterusercredentials("pramesh.cs@gmail.com","Parthik123$");
		cr.address("21 MIG","Kanpur","209801");
		cr.register();
	}
	
	@Test(dependsOnMethods="registrationflow")
	public void registrationconfirmationflow() {
		RegistrationConfirmation rc=new RegistrationConfirmation(driver);
		Assert.assertTrue(rc.isAT());
		rc.gotoflightsearch();
		
	}
	@Test(dependsOnMethods="registrationconfirmationflow")
	public void searchingflightsflow() throws InterruptedException {
		FlightSearch fs=new FlightSearch(driver);
		Assert.assertTrue(fs.isAT());
		//fs.selectpassengercount("3");
		fs.selectpassengercount(noofPassengers);
		Thread.sleep(2000);
		fs.searchflight();
	}
	@Test(dependsOnMethods="searchingflightsflow")
	public void selectflightsflow() throws InterruptedException {
		SelectFlights sf=new SelectFlights(driver);
		Assert.assertTrue(sf.isAT());
		sf.selectflights();
		sf.confirmflight();
	}
	
	@Test(dependsOnMethods="selectflightsflow")
	public void finalconfirmationflow() {
		FlightConfirmation fc=new FlightConfirmation(driver);
		Assert.assertTrue(fc.isAT());
		//Assert.assertEquals(fc.getprice(), "$1169 USD");
		Assert.assertEquals(fc.getprice(),expectedprice);
		fc.getprice();
	}
}
