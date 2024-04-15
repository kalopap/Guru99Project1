package com.kalopap.guru99.Tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.kalopap.guru99.Pages.ManagerHomePage;

public class ManagerHomeTest {

	ManagerHomePage mgrHomePage;
	String validManagerId = "mngr564548";
	 
	
	@Test
	public void verifyManagerId() {
		mgrHomePage = new ManagerHomePage();
		String actualTitle = mgrHomePage.getTitle();
		Assert.assertTrue(actualTitle.equals("Guru99 Bank Manager HomePage"), "The title is not matching");
		
		//get managerId
		String[] fullText = mgrHomePage.getManagerId().split(":");
		String mgrId = fullText[1];
		String remaining = mgrId.substring(5,mgrId.length());
		System.out.println(mgrId.substring(1, 5));
		System.out.println(remaining);
		Assert.assertTrue(mgrId.substring(1, 5).equals("mngr"));
		Assert.assertTrue(remaining.matches("[0-9]+"));
		mgrHomePage.takeScreenshot("verifyManagerId");
		mgrHomePage.teardown();
	}
	
	
	public void endTest() {
		mgrHomePage.teardown();
	}
}
