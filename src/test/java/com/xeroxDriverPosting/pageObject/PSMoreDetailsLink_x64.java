package com.xeroxDriverPosting.pageObject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.utilities.WaitHelper;


public class PSMoreDetailsLink_x64 {

	WebDriver driver;
	WaitHelper waithelper;

	// PS path value with clicking the more details link
	@FindBy(xpath="//div[@class='xrx-fw-css-grid-row']//a")
	List<WebElement> link_PSMoreDetails_x64;
	
	@FindBy(xpath="(//li[contains(@class,'xrx-fw-downloads-panel__stat')])")
	List<WebElement> PSx64bitfilename;

	@FindBy(xpath="//h1[normalize-space()='V3 Xerox Global Print Driver PostScript']")
	WebElement Validate_PSMoreDestails_x64;

	//Constructor, as every page needs a Web driver to find elements
	public PSMoreDetailsLink_x64(WebDriver driver){
		this.driver=driver;
		//PageFactory.initElements(driver, this);	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);

	}

	public void ClickPSMoreDetailsLink(String name)
	{	
		try {
			List<WebElement> PSx64bitfilename=driver.findElements(By.xpath("//div[@class='xrx-fw-css-grid-row']//li"));
			//System.out.println("No of Links Found for PdlSearchlinks: " +PSx64bitfilename.size());
			
			List<WebElement>link_PSMoreDetails_x64=driver.findElements(By.xpath("//div[@class='xrx-fw-css-grid-row']//a"));	
			//System.out.println(link_PSMoreDetails_x64.size());
					waithelper.WaitForElement(link_PSMoreDetails_x64, 50);	
					for (WebElement filename:PSx64bitfilename) 						
					{			//System.out.println(filename.getText());		
						if(filename.getText().contains(name))				
								{						
							for(WebElement Pslinks :link_PSMoreDetails_x64) 
							{					//System.out.println(Pslinks.getAccessibleName());	
								if((Pslinks.getAccessibleName().contains("More details: V3 Xerox Global Print Driver PostScript")))
								 {	
									JavascriptExecutor jse=(JavascriptExecutor)driver;
									jse.executeScript("arguments[0].click()", Pslinks);
									//Pslinks.click();
									break;
								 }
							}break;
								}
					}				
			}catch(StaleElementReferenceException ex){				
			}
	}

	public void ValidatePSMoreDetails() {
		String val=Validate_PSMoreDestails_x64.getText();
		if(val.contentEquals("V3 Xerox Global Print Driver PostScript"))
		{
			System.out.println("PS More details name is successful " + "Expected=V3 Xerox Global Print Driver PostScript "+"Actual=" +val);
		}
		else {
			System.out.println("PS More details name is not successful " +"Expected=V3 Xerox Global Print Driver PostScript "+"Actual=" +val);	
		}
	}
}