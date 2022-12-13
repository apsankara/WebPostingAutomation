package com.xeroxDriverPosting.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.utilities.WaitHelper;


public class ApplyFilters {

	WebDriver driver;
	com.xeroxDriverPosting.utilities.WaitHelper waithelper;
	
	public static By applyfilters=By.xpath("/html/body/div[4]/div/div[2]/div/div/form/div/div[4]/button");
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/form/div/div[4]/button")
	WebElement apply_filters;
	
	public ApplyFilters (WebDriver driver){
		this.driver=driver;	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}
	
	public void ApplyFilter() {
		apply_filters.click();
		
	}
	
}
