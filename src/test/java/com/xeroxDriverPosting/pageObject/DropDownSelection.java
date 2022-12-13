package com.xeroxDriverPosting.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.xeroxDriverPosting.utilities.WaitHelper;


public class DropDownSelection {


	public WebDriver driver;
	WaitHelper waithelper;

	public DropDownSelection(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);		
	}
	
	@FindBy(name=("platform"))
	WebElement select_platform;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/form/div/div[2]/select")
	WebElement select_language;

	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/form/div/div[3]/select")
	WebElement select_tag;
	

	public static void selectOptionFromDropDown(WebElement locator, String value) {

		Select drp=new Select(locator);

		List<WebElement> alloptions=drp.getOptions();
		for(WebElement option:alloptions) 
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}

		}

	}
}
