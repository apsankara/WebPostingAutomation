package com.xeroxDriverPosting.testCases;

import org.testng.annotations.Test;

import com.xeroxDriverPosting.pageObject.HomePage;
import com.xeroxDriverPosting.pageObject.SupportPage;

public class TC_SupportPage_001 extends BaseClass
{

	@Test(priority=0, enabled=true)
	public void homePage()
	{
		HomePage homepage=new HomePage(driver);
		homepage.homePageURL("https://www.support.xerox.com/");
		logger.info("www.support.xerox.com loaded");
	}

	@Test(priority=1, dependsOnMethods = "homePage",enabled=true)
	public void supportPageModelSearchLinkClick()
	{
		SupportPage supportpage=new SupportPage(driver);
		
		supportpage.typeModel("Xerox Global Print Driver");
		logger.info("Model Typed Successfully");
		
		supportpage.BtnSearchClick();
		logger.info("Model Search Button Clicked Successfully");
		
		supportpage.ModelSearchLinkClick("Xerox Global Print Driver");
		logger.info("Model SearchLink Clicked Successfully");
		
		supportpage.ValidateModelPage("Xerox Global Print Driver");
		logger.info("Model Page Validated Successfully");
	}
}
