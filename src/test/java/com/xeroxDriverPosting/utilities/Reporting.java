
package com.xeroxDriverPosting.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter 
{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest logger;


	@Override
	public void onStart(ITestContext testContext) 
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") +"/Reports/" +repName);//specify the location

			try {
				htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extent-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Xerox Driver Posting");
		htmlReporter.config().setTheme(Theme.DARK);

		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);

		extentReport.setSystemInfo("Hostname","Localhost");
		extentReport.setSystemInfo("OS", "Windows10");
		extentReport.setSystemInfo("Tester Name","Sankar");
		extentReport.setSystemInfo("Browser", "Chrome");

	}

	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		logger=extentReport.createTest(tr.getName());//create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//pass log information
	}

	@Override
	public void onTestFailure(ITestResult tr)
	{
		logger=extentReport.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//send the fail information
				
		String screenShotPath=System.getProperty("user.dir") +"/Screenshots/"+tr.getName()+".png";	
		File file=new File(screenShotPath);
		
		if(file.exists()) 
		{
			try
			{
				logger.fail("Screenshot is Below: " +logger.addScreenCaptureFromPath(screenShotPath));
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}			
		}		
	}

	@Override
	public void onTestSkipped(ITestResult tr)
	{
		logger=extentReport.createTest(tr.getName());//create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));//pass log information
	}

	@Override
	public void onFinish(ITestContext testContext) 
	{
		extentReport.flush();
	}
}