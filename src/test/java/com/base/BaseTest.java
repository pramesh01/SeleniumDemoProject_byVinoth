package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public WebDriver driver;
	
	@BeforeTest
	public void getDriver() {
		
		//below is driver setups.
		WebDriverManager.chromedriver().setup();
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
		//this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   }
	
	 @AfterTest
	 public void quitDriver() {
		this.driver.quit();
	 }
}