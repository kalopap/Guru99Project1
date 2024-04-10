package com.kalopap.guru99.Pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.kalopap.guru99.Utilities.BaseClass;
import com.kalopap.guru99.Utilities.Common;

public class ManagerHomePage extends BaseClass {
	
	public Properties prop;
	String mgrId;
	Common data = new Common();

	public ManagerHomePage() {
		prop = data.loadValuesFromPropertiesFile("Locators/ManagerHome.properties");
		mgrId = prop.getProperty("managerId");
	}
	
	public String getManagerId() {
		
		return getValue(By.cssSelector(mgrId)).getText();
	}
	
}
