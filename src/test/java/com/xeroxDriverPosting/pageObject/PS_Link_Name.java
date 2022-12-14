package com.xeroxDriverPosting.pageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.WaitHelper;


public class PS_Link_Name extends BaseClass{

	WebDriver driver;
	WaitHelper waithelper;

	// PS driver filter applied and checking details value
	@FindBy(xpath="//div[@class='xrx-fw-css-grid-row']//a")
	List<WebElement> link_PSMoreDetails;
	
	@FindBy(xpath="(//div[contains(@class,'xrx-fw-tabbed-content')]//li")
	List<WebElement> PS_Filename_Version_Release_Size_Tag;

	@FindBy(xpath="//h3[normalize-space()='V3 Xerox Global Print Driver PostScript']")
	WebElement Validate_PS_Filter;

	//Constructor, as every page needs a Web driver to find elements
	public PS_Link_Name(WebDriver driver){
		this.driver=driver;
		//PageFactory.initElements(driver, this);	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}
	
	public void ValidatePSFilterResult() {
		String val=Validate_PS_Filter.getText();
		//test=extent.createTest("XeroxDriver PS Link driver Available");
		if(val.contains("V3 Xerox Global Print Driver PostScript"))
		{
			test.pass("Successfully Validated the PS Link driver name = "+val);
		}
		else {
			test.fail("Not Validated the PS Link driver name = "+val);	
		}
	}
}