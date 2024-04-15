package com.kalopap.guru99.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kalopap.guru99.Pages.LoginPage;

public class LoginTest {

	LoginPage loginPage;
	
	String urlName;
	String browser;

	@Parameters({"URL","browser"})
	@BeforeTest
	public void loadValues(String url,String browserName) {
		System.out.println("Initializing Global configurations...");
		urlName = url;		
		browser = browserName;
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//3 invalid scenarios with username/pwd combinations
		//1 valid scenario with correct username and pwd combination
		//so we need 4 rows of (2 cols) username/pwd combinations
		Object[][] data = new Object[4][3];
		//username                 //password                 //scenario type
		data[0][0] = "mngr564548"; data[0][1] = "InvalidPwd"; data[0][2] = "Error";
		data[1][0] = "invalidUid"; data[1][1] = "pupEgaj";    data[1][2] = "Error";
		data[2][0] = "invalidUid"; data[2][1] = "InvalidPwd"; data[2][2] = "Error";
		data[3][0] = "mngr564548"; data[3][1] = "pupEgaj";    data[3][2] = "Valid";
		
		return data;
	}
	
	
	@Test(dataProvider = "getData")
	public void verifyLogin(String username, String password, String scenario) {
		
					
		loginPage = new LoginPage(browser,urlName);
		loginPage.enterUsernameAndPwd(username, password);
		loginPage.clickOnSubmitBtn();
		if(scenario == "Error") {
			Assert.assertEquals(loginPage.getAlertMessage(), "User or Password is not valid");
			loginPage.closeAlertWindow();
			loginPage.teardown();
		
		}
	
	}
	
}
