package com.xeroxDriverPosting.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.xeroxDriverPosting.pageObject.HomePage;
import com.xeroxDriverPosting.pageObject.ModelPage_Validation;
import com.xeroxDriverPosting.pageObject.SupportPage;

public class TC1_Xerox_ModelName_Page_001 extends BaseClass
{

	@Test(priority=0, enabled=true)
	public void homePage() throws IOException
	{		
		HomePage homepage=new HomePage(driver);
		homepage.homePageURL();
		logger.info("www.support.xerox.com loaded");
	}

	@Test(priority=1,dependsOnMethods ="homePage", enabled=true)
	public void supportPageModelSearchLinkClick() throws InterruptedException
	{	
		SupportPage supportpage=new SupportPage(driver);

		supportpage.typeModel();
		logger.info("Model Typed Successfully");

		supportpage.BtnSearchClick();
		logger.info("Model Search Button Clicked Successfully");

		supportpage.ModelSearchLinkClick();
		logger.info("Model SearchLink Clicked Successfully");

	}

	@Test(priority=2,dependsOnMethods="supportPageModelSearchLinkClick", enabled=true)
	public void modelPageValidation() throws InterruptedException  {
		ModelPage_Validation modelPage_validation=new ModelPage_Validation(driver);

		modelPage_validation.ValidateXeroxModelPage();
		logger.info("Xerox_Model Page Validated Successfully");
	}



}
