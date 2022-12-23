package com.xeroxDriverPosting.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.ReadConfig;
import com.xeroxDriverPosting.utilities.WaitHelper;

public class SupportPage extends BaseClass {

	public WebDriver driver;
	WaitHelper waithelper;
	//Constructor, as every page needs a Web driver to find elements
	public SupportPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}

	@FindBy(xpath="//*[@id=\"searchbox\"]/div[3]/div[2]/div/div[1]/input")
	WebElement txt_ModelSearch;

	@FindBy(className="coveo-search-button-svg")
	WebElement btn_ModelSearch;

	@FindBy(xpath="//a[contains(text(),'Drivers & Downloads - Xerox Global Print Driver')]")
	WebElement model_SearchLink;

	@FindBy(xpath="//div[@class='coveo-result-list-container coveo-list-layout-container']//a")
	List<WebElement> ModelSearchlinks;

	////h2[contains(text(),'Xerox Global Print Driver')]
	@FindBy(xpath="//h2[contains(text(),'Xerox Global Print Driver')")
	WebElement validate_GPDModelSearchLink;

	@FindBy(xpath="//h2[contains(text(),'VersaLink')]")
	WebElement validate_VersaLinkModelSearchLink;

	@FindBy(xpath="//h2[contains(text(),'AltaLink')]")
	WebElement validate_AltaLinkModelSearchLink;

	ReadConfig config=new ReadConfig();
	String modelname=config.getModelName();
	String modellinkname=config.clickModelNameLink();

	public void typeModel() 
	{
		

		waithelper.WaitForElement(txt_ModelSearch, 50);
		txt_ModelSearch.clear();		
		txt_ModelSearch.sendKeys(modelname);
		
	}

	public void BtnSearchClick() 
	{
		waithelper.WaitForElement(btn_ModelSearch, 50);
		btn_ModelSearch.click();
		
	}

	public void ModelSearchLinkClick() 
	{
		try 
		{
			waithelper.WaitForElement(ModelSearchlinks, 50);
			for(WebElement modellinks :ModelSearchlinks) 
			{
				//System.out.println(modellinks.getText());
				//Drivers & Downloads - Xerox Global Print Driver
				//String xeroxmodellinkname=modellinks.getText();				
				if(modellinks.getText().contains(modellinkname))
				{					
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click()", modellinks);					
					break;
				}		
			}
		}catch(Exception ex) 
		{

		}
	}
}
