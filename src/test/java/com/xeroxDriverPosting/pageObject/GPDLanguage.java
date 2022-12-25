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


public class GPDLanguage extends BaseClass {

	WebDriver driver;
	WaitHelper waithelper;
	//language drop down verification
		public static By Language=By.xpath("/html/body/div[4]/div/div[2]/div/div/form/div/div[2]/select");	
	
		@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/form/div/div[2]/select")
		WebElement select_language;

		public GPDLanguage (WebDriver driver){
			this.driver=driver;	
			AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
			PageFactory.initElements(factory, this);
			waithelper=new WaitHelper(driver);
		}
				
		public void SelectLanguage(String language) {
			//test=extent.createTest("GPD Language Selection");
			Select language1=new Select(select_language);
			language1.selectByVisibleText(language);
		}

}
