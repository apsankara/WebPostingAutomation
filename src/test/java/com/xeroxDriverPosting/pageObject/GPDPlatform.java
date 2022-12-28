package com.xeroxDriverPosting.pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.WaitHelper;


public class GPDPlatform extends BaseClass {
	public WebDriver driver;
	com.xeroxDriverPosting.utilities.WaitHelper waithelper;
	
	//platform drop down verification
	public static By OS=By.name("platform");
	
	@FindBy(xpath=("//select[@name='platform']"))
	WebElement select_platform;
	
	public GPDPlatform (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);		
	}
	
	public void clickPlatform() {
		select_platform.click();
	}	
	
	
	public void selectPlatform(String platform) {
		Select os=new Select(select_platform);
		os.selectByVisibleText(platform);
		test.pass("Selected OS is "+platform);
	}
	
}
