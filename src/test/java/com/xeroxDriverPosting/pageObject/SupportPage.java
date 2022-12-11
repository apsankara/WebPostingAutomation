package com.xeroxDriverPosting.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SupportPage {

	public WebDriver driver;
	
	//Constructor, as every page needs a Web driver to find elements
	public SupportPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/div[3]/div[2]/div/div[1]/input")
	WebElement txt_ModelSearch;

	@FindBy(className="coveo-search-button-svg")
	WebElement btn_ModelSearch;

	@FindBy(xpath="//a[contains(text(),'Drivers & Downloads - Xerox Global Print Driver')]")
	WebElement model_SearchLink;
	
	@FindBy(xpath="//div[@class='coveo-result-list-container coveo-list-layout-container']//a")
	List<WebElement> ModelSearchlinks;
	
	@FindBy(xpath="//h2[contains(text(),'Xerox Global Print Driver')]")
	WebElement validate_modelSearchLink;

	public void typeModel(String modelName) 
	{
		txt_ModelSearch.clear();
		txt_ModelSearch.sendKeys(modelName);
	}

	public void BtnSearchClick() 
	{
		btn_ModelSearch.click();
	}

	public void ModelSearchLinkClick(String modelLinkName) 
	{
		try 
		{
		for(WebElement modellinks :ModelSearchlinks) 
		{
			//System.out.println(modellinks.getText());
			
			if(modellinks.getText().contains(modelLinkName))
			{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", modellinks);		
				break;
			}
		}
		}catch(Exception ex) {
			
		}
	}

	public void ValidateModelPage(String modelPage) 
	{
		String modelText=validate_modelSearchLink.getText();
		
		if(modelText.contains(modelPage))
		{
			System.out.println("Model Page Success " + "Expected=" +modelPage +" Actual=" +modelText);
		}
		else {
			System.out.println("Model Page not Success " + "Expected=" +modelPage +" Actual=" +modelPage);
			driver.navigate().refresh();
		}
	}
}
