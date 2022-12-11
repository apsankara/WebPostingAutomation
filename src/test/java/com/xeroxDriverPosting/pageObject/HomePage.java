package com.xeroxDriverPosting.pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage 
{
public WebDriver driver;
	
	//Constructor, as every page needs a Web driver to find elements
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
	}

	public void homePageURL(String baseURL)
	{
		driver.get(baseURL);
		
		if(driver.getTitle().equalsIgnoreCase("Product Support and Drivers – Xerox"))
		{
			System.out.println("Page Title=Product Support and Drivers – Xerox");
			Assert.assertTrue(true);
		}else
		{
			driver.navigate().refresh();
			Assert.assertTrue(false);
			System.out.println("Home URL Page not Accesible due somthing wrong, so clicked on Referesh to work");
		}
	}
}
