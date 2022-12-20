package com.xeroxDriverPosting.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.xeroxDriverPosting.utilities.ReadConfig;

//https://www.youtube.com/watch?v=M4Ye3SKT46g
public class BaseClass {

	ReadConfig readconfig=new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;

	//extend HtML Report
	public ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void reportSetup() {
		htmlReporter=new ExtentSparkReporter("Reports/MyResult.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Xerox Driver Posting");
		htmlReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname","Localhost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name","Sankar");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@AfterMethod
	public void reportTearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "TEST CASE FAILED is " +result.getName());//to add the name in the extent report
			test.log(Status.FAIL, "TEST CASE FAILED is " +result.getThrowable());

			String screenshotpath=BaseClass.getScreenShot(driver, result.getName());

			test.addScreenCaptureFromPath(screenshotpath);//adding screenshot path
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "TEST CASE SKIPPED is " +result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "TEST PASSED is " +result.getName());
		}			

	}	

	//Method for taking the screenshots and storing into the file location
	//https://www.youtube.com/watch?v=tovz1q5Unxs&t=6s
	public static String getScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		String dateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);

		String destination=System.getProperty("user.dir")+ "/screenshots/" + screenshotName + dateName +".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;

	}

	@BeforeClass
	public void browserSetup()
	{
		//log object creation and log4j property link and usage
		logger=Logger.getLogger("DriverPosting");
		PropertyConfigurator.configure("Log4j.properties");

		//System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
		//driver=new ChromeDriver();
		test=extent.createTest("LaunchingBrowser");
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
		test=extent.createTest("ClosingBrowser");
		driver.quit();
		extent.flush();
	}

}
