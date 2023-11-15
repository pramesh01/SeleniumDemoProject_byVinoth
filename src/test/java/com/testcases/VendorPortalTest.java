package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.vendorportal.pages.Login;
import com.vendorportal.pages.UserDashboard;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VendorPortalTest extends BaseTest {

	//WebDriver driver ;
	public Login lp;
	public UserDashboard ud;
	public String keywordname;
	public int resultrowcount;
	public String username;
	public String password;
	
	@BeforeTest
	@Parameters({"username","password","keywordname","resultrowcount"})
	public void setparavalues(String username,String password,String keywordname,int resultrowcount ) {
		this.username=username;
		this.password=password;
		this.keywordname=keywordname;
		this.resultrowcount=resultrowcount;
		
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
	public void loginTest() {
		lp=new Login(driver);
		lp.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
		Assert.assertTrue(lp.isAT());
		//lp.vendorportallogin("sam","sam");
		lp.vendorportallogin(username,password);
		
	}
	@Test(dependsOnMethods="loginTest")
	public void DashboardTest() {
		ud=new UserDashboard(driver);
		Assert.assertTrue(ud.isAT());
		//ud.searchByText("adam");
		ud.searchByText(keywordname);
		
		//Assert.assertEquals(ud.getSearchResult(),8);
		Assert.assertEquals(ud.getSearchResult(),resultrowcount);
		
	}
	
	@Test(dependsOnMethods="DashboardTest")
	public void logOut() {
		UserDashboard ud=new UserDashboard(driver);
		ud.logout();
		//Login lp=new Login(driver);
		Assert.assertTrue(lp.isAT());
	}
      }
