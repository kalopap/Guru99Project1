package com.kalopap.guru99.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kalopap.guru99.Pages.LoginPage;

public class LoginTest {

	LoginPage loginPage;
	
	String urlName;
	String browser;

	//@Parameters({"URL","browser"})
	//@BeforeTest
	public void loadValues(String url,String browserName) {
		System.out.println("Initializing Global configurations...");
		urlName = url;		
		browser = browserName;
		
	}
	
	//@BeforeTest
	public void login(String username, String password) {
		loginPage = new LoginPage(browser,urlName);
		loginPage.enterUsernameAndPwd(username, password);
		loginPage.clickOnSubmitBtn();
	}
	
	@Test
	public void justTest() {
		loginPage = new LoginPage("Firefox","https://www.google.com/");
		loginPage.just();
		
	}
	//@Test
	public void verifyLoginWithInvalidCred() {
		
		login("some", "text");
		Assert.assertEquals(loginPage.getAlertMessage(), "User or Password is not valid");
		loginPage.closeAlertWindow();
		loginPage.teardown();
		
	}
	
	//@Test
	public void verifyLoginWithValidCred() {
		
		login("mngr564548", "pupEgaj");				 
	
	}
	
	//@AfterTest
	public void endTest() {
		loginPage.teardown();
	}
}
