package com.xeroxDriverPosting.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.ReadConfig;

public class HomePage extends BaseClass
{
public WebDriver driver;
	
	
	ReadConfig readconfig=new ReadConfig();	
	public String baseURL=readconfig.getApplicationURL();
	
	//Constructor, as every page needs a Web driver to find elements
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
	}

	public void homePageURL()
	{
		test=extent.createTest("XeroxSupportPageURL");
		driver.get(baseURL);	
		driver.manage().window().maximize();
		
		if(driver.getTitle().equalsIgnoreCase("Product Support and Drivers – Xerox"))
		{
			test.createNode("XeroxHomePageTitleValidation");			
		}else
		{
			test.createNode("XeroxHomePage Not Accesible so Refereshed To WorkAgain");
			driver.navigate().refresh();									
		}
	}
}
