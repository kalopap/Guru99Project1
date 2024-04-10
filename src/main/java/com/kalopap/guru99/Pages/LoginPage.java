package com.kalopap.guru99.Pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.kalopap.guru99.Utilities.BaseClass;
import com.kalopap.guru99.Utilities.Common;

public class LoginPage extends BaseClass{
		
	public Properties prop;
	Common data = new Common();
	
	String userName; 
	String password;
	String submit;
	String reset;

	public LoginPage(String browserName,String url) {
		launchBrowser(browserName, url);
		prop = data.loadValuesFromPropertiesFile("Locators/Login.properties");
		initializeWebElements();
	}
	
	public void initializeWebElements() {
		userName = prop.getProperty("unameByName");
		password = prop.getProperty("pwdByName"); 
		submit = prop.getProperty("submitBtnName");
		reset = prop.getProperty("resetBtnName");
		System.out.println("Login page web elements loaded...");
	}
	
	public void enterUsernameAndPwd(String uname,String pwd) {
		
		enterText(By.name(userName),uname );
		enterText(By.name(password),pwd );
	}
	
	public void clickOnSubmitBtn() {
		clickOnElement(By.name(submit));
	}
	
	public void just() {
		data.readDataFromExcel("Resources/TestData.xlsx", "Login", "Password");
	}


}
