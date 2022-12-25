package com.xeroxDriverPosting.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xeroxDriverPosting.pageObject.ApplyFilters;
import com.xeroxDriverPosting.pageObject.GPDLanguage;
import com.xeroxDriverPosting.pageObject.GPDPlatform;
import com.xeroxDriverPosting.pageObject.GPDTag;
import com.xeroxDriverPosting.pageObject.HomePage;
import com.xeroxDriverPosting.pageObject.ModelPage_Validation;
import com.xeroxDriverPosting.pageObject.PS_x64_Filter;
import com.xeroxDriverPosting.pageObject.SupportPage;
import com.xeroxDriverPosting.utilities.ReadConfig;
import com.xeroxDriverPosting.utilities.XLUtils;


public class TC1_GPDModel_PS_x64_Validation extends BaseClass
{
	ReadConfig readconfig=new ReadConfig();
	
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
	public void modelPageValidation() throws InterruptedException  
	{
		ModelPage_Validation modelPage_validation=new ModelPage_Validation(driver);

		String modelName=readconfig.getModelName();		
		if(modelName.contains("Xerox Global"))
		{
			modelPage_validation.ValidateXeroxModelPage();
			logger.info("Xerox_GPDModel Page Validated Successfully");
		}
		else if(modelName.contains("Xerox"))
		{
			modelPage_validation.ValidateXeroxModelPage();
			logger.info("Xerox_Model Page Validated Successfully");
		}
		else if(modelName.contains("AltaLink"))
		{
			modelPage_validation.ValidateAltaLinkModelPage();
			logger.info("Xerox_AltaLink Model Page Validated Successfully");

		} 
		else if(modelName.contains("VersaLink"))
		{
			modelPage_validation.ValidateVersaLinkModelPage();
			logger.info("Xerox_VersaLink Model Page Validated Successfully");
		}
	}
	
	@Test(priority=3,dataProvider="PlatformData")
	public void OS_Language_Tag_Selection(String SelectOS) throws IOException
	{
		
		GPDPlatform platform=new GPDPlatform(driver);
		//platform.clickPlatform();
		test=extent.createTest("OS_Language_Tag_Selection");
		platform.selectPlatform(SelectOS);
		test.pass("Successfully captured the OS from Excel :" +SelectOS);
		String dropdown=platform.gettext();
		test.pass("Successfully captured the OS form WebPage :" +dropdown);
		test.pass("Comparison is Successfull");
		logger.info("Selected OS is "+SelectOS);
		
		GPDLanguage language=new GPDLanguage(driver);
		String configLanguage=readconfig.getLanguage();
		language.SelectLanguage(configLanguage);
		test.pass("Selected Language is "+configLanguage);
		logger.info("Selected Language is "+configLanguage);
		
		GPDTag tag=new GPDTag(driver);
		String configTag=readconfig.getTag();
		tag.SelectTag(configTag);
		test.pass("Selected Tag is "+configTag);
		logger.info("Selected Tag is "+configTag);
		
		ApplyFilters filter=new ApplyFilters(driver);
		filter.ApplyFilter();
		test.pass("Successfully Applied Filter Button");
		logger.info("Successfully Applied Filter Button");
		
		PS_x64_Filter ps_x64=new PS_x64_Filter(driver);
		test=extent.createTest("ValidatePSFilterResult");
		ps_x64.ValidatePSFilterResult();
		test.pass("Successfully Validated the PS_x64_Link driver");
		logger.info("Successfully Validated the PS_x64_Link driver");
		
	}
	
	@DataProvider(name="PlatformData")
	public String[][] platformData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/xeroxDriverPosting/testData/TestData.xlsx";
		int rowcount=XLUtils.getRowCount(path, "Platform_x64");
		int colcount=XLUtils.getCellCount(path, "Platform_x64", 1);
		
		String platformData[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				
				platformData[i-1][j]=XLUtils.getCellData(path, "Platform_x64", i, j);//values start from 1 0
				
			}
		}
		return platformData;
	}
	
	
}
