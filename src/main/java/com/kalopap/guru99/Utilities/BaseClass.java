package com.kalopap.guru99.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/* This class will contain all the reusable components */

public class BaseClass {
	
	public static WebDriver driver;	
	
	
	public BaseClass() {
		System.out.println("Initializing base constructor...");
		
	}
	
	public void launchBrowser(String browserName,String url) {
		
		if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		driver.manage().window().maximize();
		driver.get(url); 
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
	
	public WebElement getValue(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);
	}
	

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
