package com.kalopap.guru99.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import com.kalopap.guru99.Utilities.BaseClass;

public class LoginPage extends BaseClass{
	
	//BaseClass base = new BaseClass();
	public Properties prop;
	String userName; 
	String password;
	String submit;
	String reset;

	public LoginPage() {
		super();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/kalopap/guru99/Locators/Login.properties");
			prop.load(ip);
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		initializeElements();
	}
	
	public void initializeElements() {
		userName = prop.getProperty("unameByName");
		password = prop.getProperty("pwdByName"); 
		submit = prop.getProperty("submitBtnName");
		reset = prop.getProperty("resetBtnName");
	}
	
	public void enterUsernameAndPwd(String uname,String pwd) {
		
		enterText(By.name(userName),uname );
		enterText(By.name(password),pwd );
	}
	
	public void clickOnSubmitBtn() {
		clickOnElement(By.name(submit));
	}
	
}
