package com.kalopap.guru99.Tests;

import org.testng.annotations.Test;

import com.kalopap.guru99.Pages.LoginPage;

public class LoginTest {

	LoginPage loginPage = new LoginPage();

	
	public void verifyLoginWithInvalidCred() {
		
		loginPage.enterUsernameAndPwd("some", "text");
		loginPage.clickOnSubmitBtn();
	}
	
	@Test
	public void verifyLoginWithValidCred() {
		
		loginPage.enterUsernameAndPwd("mngr564548", "pupEgaj");
		loginPage.clickOnSubmitBtn();
	}
}
