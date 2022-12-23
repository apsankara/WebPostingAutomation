package com.xeroxDriverPosting.pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.ReadConfig;
import com.xeroxDriverPosting.utilities.WaitHelper;

public class HomePage extends BaseClass
{

	public WebDriver driver;
	WaitHelper waithelper;

	ReadConfig readconfig=new ReadConfig();	
	public String baseURL=readconfig.getApplicationURL();

	//Constructor, as every page needs a Web driver to find elements
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}

	public void homePageURL() throws IOException
	{
		//test=extent.createTest("XeroxSupportPageURL");
		driver.get(baseURL);	
		driver.manage().window().maximize();

		if(driver.getTitle().equalsIgnoreCase("Product Support and Drivers – Xerox"))
		{
			
		}else
		{
			getScreenShot(driver,"HomepageValidation");			
			driver.navigate().refresh();									
		}
	}
}
