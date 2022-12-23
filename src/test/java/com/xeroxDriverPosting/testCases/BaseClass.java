package com.xeroxDriverPosting.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.xeroxDriverPosting.utilities.ReadConfig;

//https://www.youtube.com/watch?v=M4Ye3SKT46g
public class BaseClass {

	ReadConfig readconfig=new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;

	//Method for taking the screenshots and storing into the file location
	//https://www.youtube.com/watch?v=tovz1q5Unxs&t=6s
	public static void getScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+ "/Screenshots/" +screenshotName +".png");
		//File finalDestination=new File(destination);
		FileUtils.copyFile(source, destination);

	}

	@BeforeClass
	public void browserSetup()
	{
		//log object creation and log4j property link and usage
		logger=Logger.getLogger("DriverPosting");
		PropertyConfigurator.configure("Log4j.properties");
		String name=readconfig.getBrowserName();		
		if(name.equals("chrome"))
		{
			//System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//Chrome_108.0.5359.71//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			//System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(name.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver.driver", readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		} 
		else if(name.equals("msedge"))
		{
			System.setProperty("webdriver.msedgedriver.driver",readconfig.getMicroSoftEdgePath());
			driver=new EdgeDriver();
		}
	}

	@AfterClass
	public void browserTearDown() {	
		driver.quit();	
	}

}
