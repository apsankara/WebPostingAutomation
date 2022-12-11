package com.xeroxDriverPosting.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.xeroxDriverPosting.utilities.ReadConfig;
//https://www.youtube.com/watch?v=M4Ye3SKT46g
public class BaseClass {

	ReadConfig readconfig=new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//log object creation and log4j property link and usage
		logger=Logger.getLogger("DriverPosting");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		//System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//Chrome_108.0.5359.71//chromedriver.exe");
		System.setProperty("Webdriver.chrome.driver",readconfig.getChromePath() );
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver.driver", readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		} 
		else if(br.equals("msedge"))
		{
			System.setProperty("webdriver.msedgedriver.driver",readconfig.getMicroSoftEdgePath());
			driver=new EdgeDriver();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
