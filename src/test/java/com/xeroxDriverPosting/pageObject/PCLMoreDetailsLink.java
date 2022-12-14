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

import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.WaitHelper;

public class PCLMoreDetailsLink extends BaseClass {

	WebDriver driver;
	WaitHelper waithelper;

		// PS path value with clicking the more details link
		// PS path value with clicking the more details link
		@FindBy(xpath="//a[normalize-space()='More details...']")
		WebElement link_PCLMoreDetails;	
		
		//Driver details driver name,version,etc
		@FindBy(xpath="//div[@class='xrx-fw-css-grid-row']//li")
		List<WebElement> PCLDriverDetails;
		
	@FindBy(xpath="//h1[normalize-space()='V3 Xerox Global Print Driver PCL6']")
	WebElement Validate_PCLMoreDestails;
	//h1[contains(text(),'V3 Xerox Global Print Driver PostScript')]
	
	//Constructor, as every page needs a Web driver to find elements
	public PCLMoreDetailsLink(WebDriver driver){
	this.driver=driver;
		//PageFactory.initElements(driver, this);	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}

	public void PCLMoreDetailsClick() {
		link_PCLMoreDetails.click();
	}
	
	
	public void ClickPSMoreDetailsLink(String name) {
		try {
			test=extent.createTest("ValidatePCLDriverDetails");
			List<WebElement> PCLbitfilename=driver.findElements(By.xpath("//div[@class='xrx-fw-css-grid-row']//li"));
			//System.out.println("No of Links Found for PdlSearchlinks: " +PSx64bitfilename.size());
			
			List<WebElement>link_PCLMoreDetails=driver.findElements(By.xpath("//div[@class='xrx-fw-css-grid-row']//a"));	
			//System.out.println("No of Links Found for PdlSearchlinks: " +link_PSMoreDetails_x64.size());
			
					waithelper.WaitForElement(link_PCLMoreDetails, 50);	
					for (WebElement filename:PCLbitfilename) 						
					{						System.out.println(filename.getText());									
							for(WebElement Pslinks :link_PCLMoreDetails) 
							{					System.out.println(Pslinks.getText());	
								if((filename.getText().contains(name))&&(Pslinks.getAccessibleName().contains("More details: V3 Xerox Global Print Driver PCL6")) )
								 {	
									JavascriptExecutor jse=(JavascriptExecutor)driver;
									jse.executeScript("arguments[0].click()", Pslinks);
									//Pslinks.click();
									test.pass("Successfully Clicked on the " +name);
									break;
								 }
							}
								
					}				
			}
		catch(StaleElementReferenceException ex)
		{
			test.fail("Not Clicked on the " +name);	
			}
	}
	
	public void ValidatePCLMoreDetails(String name) {
		String val=Validate_PCLMoreDestails.getText();
		if(val.contentEquals(name))
		{
			test.pass("Successfully Validated the PS Page " +val);
		}
		else {
			test.fail("Not Validated the PS Page "  +val);	
		}
	}
}