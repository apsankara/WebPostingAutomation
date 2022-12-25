package com.xeroxDriverPosting.pageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.utilities.WaitHelper;


public class PS_x64_Filter {

	WebDriver driver;
	WaitHelper waithelper;

	// PS driver filter applied and checking details value
	@FindBy(xpath="//div[@class='xrx-fw-css-grid-row']//a")
	List<WebElement> link_PSMoreDetails_x64;
	
	@FindBy(xpath="(//div[contains(@class,'xrx-fw-tabbed-content')]//li")
	List<WebElement> PS_x64_Filename_Version_Release_Size_Tag;

	@FindBy(xpath="//h3[normalize-space()='V3 Xerox Global Print Driver PostScript']")
	WebElement Validate_PS_x64_Filter;

	//Constructor, as every page needs a Web driver to find elements
	public PS_x64_Filter(WebDriver driver){
		this.driver=driver;
		//PageFactory.initElements(driver, this);	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}
	
	public void ValidatePSFilterResult() {
		String val=Validate_PS_x64_Filter.getText();
		if(val.contentEquals("V3 Xerox Global Print Driver PostScript"))
		{
			System.out.println("PS More details name is successful " + "Expected=V3 Xerox Global Print Driver PostScript "+"Actual=" +val);
		}
		else {
			System.out.println("PS More details name is not successful " +"Expected=V3 Xerox Global Print Driver PostScript "+"Actual=" +val);	
		}
	}
}