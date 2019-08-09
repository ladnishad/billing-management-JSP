package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import selenium.functions.SeleniumFunctionsBase;

public class SeleniumTestBase extends SeleniumFunctionsBase{
	
	protected static String baseUrl;
	
	public SeleniumTestBase () {
		
	}
	
	public static void setDriver() {
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    setBaseUrl("http://localhost:8080/BillsManagementJSP/Homepage.jsp");
		driver.get(getBaseUrl());
	}

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl1) {
		baseUrl = baseUrl1;
	}
}
