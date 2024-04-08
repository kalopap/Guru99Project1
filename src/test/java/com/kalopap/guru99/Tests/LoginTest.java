package com.kalopap.guru99.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kalopap.guru99.Pages.LoginPage;

public class LoginTest {

	LoginPage loginPage;

	@Test
	public void verifyLoginWithInvalidCred() {
		
		loginPage = new LoginPage();
		loginPage.enterUsernameAndPwd("some", "text");
		loginPage.clickOnSubmitBtn();
		Assert.assertEquals(loginPage.getAlertMessage(), "User or Password is not valid");
		loginPage.closeAlertWindow();
		loginPage.teardown();
	}
	
	@Test
	public void verifyLoginWithValidCred() {
		
		loginPage = new LoginPage();
		loginPage.enterUsernameAndPwd("mngr564548", "pupEgaj");
		loginPage.clickOnSubmitBtn();
		String actualTitle = loginPage.getTitle();
		Assert.assertTrue(actualTitle.equals("Guru99 Bank Manager HomePage"), "The title is not matching");
		loginPage.teardown();

		
	}
}
