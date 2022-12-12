package com.xeroxDriverPosting.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.testCases.BaseClass;

public class SupportPage extends BaseClass {

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
		test=extent.createTest("XeroxDriverModelSearchPage");
		txt_ModelSearch.clear();
		test.createNode("ModelSearchBar_Clear");
		txt_ModelSearch.sendKeys(modelName);
		test.createNode("Serach model " +modelName);
		
	}

	public void BtnSearchClick() 
	{
		btn_ModelSearch.click();
		test.createNode("Click on Model SerchBtn");
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
				test.createNode("Clcik on the Model Seatch Link" +modellinks);
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
			test.createNode("Validate the Model Page " +modelPage);
		}
		else {			
			test.createNode("Validate the Model Page " +modelPage);
			driver.navigate().refresh();
		}
	}
}
