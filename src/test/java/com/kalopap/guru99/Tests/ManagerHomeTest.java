package com.kalopap.guru99.Tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.kalopap.guru99.Pages.ManagerHomePage;

public class ManagerHomeTest {

	ManagerHomePage mgrHomePage;
	
	@Test
	public void verifyManagerId() {
		mgrHomePage = new ManagerHomePage();
		String actualTitle = mgrHomePage.getTitle();
		Assert.assertTrue(actualTitle.equals("Guru99 Bank Manager HomePage"), "The title is not matching");
		Assert.assertTrue(mgrHomePage.getManagerId().contains("mngr564548"),"ManagerId is not matching");
		mgrHomePage.teardown();
	}
	
	
	public void endTest() {
		mgrHomePage.teardown();
	}
}
