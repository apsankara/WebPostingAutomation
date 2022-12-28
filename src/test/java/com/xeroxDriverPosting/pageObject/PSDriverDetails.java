package com.xeroxDriverPosting.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.xeroxDriverPosting.utilities.WaitHelper;


public class PSDriverDetails {

	WebDriver driver;
	WaitHelper waithelper;
	// PS path value without clicking the more details link
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/div/ul/li[1]")
	WebElement Released;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/div/ul/li[2]")
	WebElement Version;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/div/ul/li[3]")
	WebElement Size;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/div/ul/li[4]")
	WebElement Filename;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div/div/ul/li[5]")
	WebElement Tag;
	
	@FindBy(className="xrx-fw-terms-conditions__checkbox")
	WebElement CheckAgree;
	
	@FindBy(xpath="//a[normalize-space()='Download']")
	WebElement Download;

	//Constructor, as every page needs a Web driver to find elements
	public PSDriverDetails(WebDriver driver){
		this.driver=driver;
		//PageFactory.initElements(driver, this);	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}

	public void Get_ReleasedDate(String releasedate) {
		waithelper.WaitForElement(Released, 20);
		String val=Released.getText();
		if(val.contentEquals(releasedate))
		{
			System.out.println("Released date is successful validation " + "Expected=" + releasedate +" Actual=" +val);
		}
		else {
			System.out.println("Released date is not successful validation " + "Expected=" + releasedate +" Actual :" +val);	
		}
	}		
	
	public void Get_Version(String version) {
		waithelper.WaitForElement(Version, 20);
		String val=Version.getText();
		if(val.contentEquals(version))
		{
			System.out.println("Released date is successful validation " + "Expected=" + version +" Actual=" +val);
		}
		else {
			System.out.println("Released date is not successful validation " + "Expected=" + version +" Actual :" +val);	
		}
	}	
	
	public void Get_Size(String size) {
		waithelper.WaitForElement(Size, 20);
		String val=Size.getText();
		if(val.contentEquals(size))
		{
			System.out.println("Released date is successful validation " + "Expected=" + size +" Actual=" +val);
		}
		else {
			System.out.println("Released date is not successful validation " + "Expected=" + size +" Actual :" +val);	
		}
	}		
	
	public void Get_Filename(String filename) {
		waithelper.WaitForElement(Filename, 20);
		String val=Filename.getText();
		if(val.contentEquals(filename))
		{
			System.out.println("Released date is successful validation " + "Expected=" + filename +" Actual=" +val);
		}
		else {
			System.out.println("Released date is not successful validation " + "Expected=" + filename +" Actual :" +val);	
		}
	}		
	
	public void Get_Tag(String tag) {
		waithelper.WaitForElement(Tag, 20);
		String val=Tag.getText();
		if(val.contentEquals(tag))
		{
			System.out.println("Released date is successful validation " + "Expected=" + tag +" Actual=" +val);
		}
		else {
			System.out.println("Released date is not successful validation " + "Expected=" + tag +" Actual :" +val);	
		}
	}		
	
	public void Get_Agree() {
		waithelper.WaitForElement(CheckAgree, 20);
		CheckAgree.click();
		
	}		
	
	
	public void Get_Download() throws InterruptedException {
		waithelper.WaitForElement(Download, 20);
		Download.click();			
}

}