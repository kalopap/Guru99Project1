package com.kalopap.guru99.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/* This class will contain all the reusable components */

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		System.out.println("Initializing Base class...");
		//constructor to load default configurations
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/kalopap/guru99/Resources/Config.properties");
			prop.load(ip);
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		this.initialize();
		
	}
	
	
	public void initialize() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		System.out.println("Configuration settings Loaded...");
	}
	
	public void enterText(By by, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(text);
	}
	
	public void clickOnElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
		
	}
	
	public void closeAlertWindow() {
		driver.switchTo().alert().accept();
	}


	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
