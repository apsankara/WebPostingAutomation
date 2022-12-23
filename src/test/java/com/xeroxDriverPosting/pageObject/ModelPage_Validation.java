package com.xeroxDriverPosting.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.ReadConfig;
import com.xeroxDriverPosting.utilities.WaitHelper;

public class ModelPage_Validation extends BaseClass {

	public WebDriver driver;
	WaitHelper waithelper;

	//Constructor, as every page needs a Web driver to find elements
	public ModelPage_Validation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}

	////h2[contains(text(),'Xerox Global Print Driver')]
	@FindBy(xpath="//h2[contains(text(),'Xerox')]")
	WebElement validate_XeroxModelSearchLink;

	@FindBy(xpath="//h2[contains(text(),'VersaLink')]")
	WebElement validate_VersaLinkModelSearchLink;

	@FindBy(xpath="//h2[contains(text(),'AltaLink')]")
	WebElement validate_AltaLinkModelSearchLink;
	
	ReadConfig config=new ReadConfig();
	String modelname=config.getModelName();

	public void ValidateXeroxModelPage() throws InterruptedException 
	{
		//test=extent.createTest("XeroxDriverModelPageValidation");

		waithelper.WaitForElement(validate_XeroxModelSearchLink, 50);
		String xeroxmodeltext=validate_XeroxModelSearchLink.getText();
		//System.out.println(gpdmodeltext);

		if(xeroxmodeltext.contains(modelname))
		{
			//test.createNode("Validation Success in the GPD Model Page " +xeroxmodeltext);	

		}	else {
			//test.createNode("Validation Fail/Not in the GPD Model Page " +xeroxmodeltext);	
		}
	}

	public void ValidateVersaLinkModelPage() throws InterruptedException 
	{
		//test=extent.createTest("XeroxDriverModelPageValidation");
		waithelper.WaitForElement(validate_VersaLinkModelSearchLink, 50);
		String versalinkmodeltext=validate_VersaLinkModelSearchLink.getText();
		//System.out.println(versalinkmodeltext);

		if(versalinkmodeltext.contains("VersaLink"))
		{
			//test.createNode("Validation Success in the VersaLink Model Page " +versalinkmodeltext);	

		}	else {
			//test.createNode("Validation Fail/Not in the VersaLink Model Page " +versalinkmodeltext);	
		}
	}

	public void ValidateAltaLinkModelPage() throws InterruptedException 
	{
		//test=extent.createTest("XeroxDriverModelPageValidation");
		waithelper.WaitForElement(validate_AltaLinkModelSearchLink, 50);
		String altalinkmodeltext=validate_AltaLinkModelSearchLink.getText();
		//System.out.println(altalinkmodeltext);

		if(altalinkmodeltext.contains("AltaLink"))
		{
			//test.createNode("Validation Success in the AltaLink Model Page " +altalinkmodeltext);	

		}	else {
			//test.createNode("Validation Fail/Not in the AltaLink Model Page " +altalinkmodeltext);	
		}
	}	
}	
