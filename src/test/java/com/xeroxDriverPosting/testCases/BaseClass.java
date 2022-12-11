package com.xeroxDriverPosting.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//Chrome_108.0.5359.71//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//log object creation and log4j property link and usage
		logger=Logger.getLogger("DriverPosting");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
