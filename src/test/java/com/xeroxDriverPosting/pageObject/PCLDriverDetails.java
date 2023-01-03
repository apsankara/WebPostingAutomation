package com.xeroxDriverPosting.pageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.xeroxDriverPosting.testCases.BaseClass;
import com.xeroxDriverPosting.utilities.WaitHelper;


public class PCLDriverDetails extends BaseClass{

	WebDriver driver;
	WaitHelper waithelper;
	// PCL path value without clicking the more details link
	@FindBy(xpath="//body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	WebElement Released;
	
	
	@FindBy(xpath="//body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	WebElement Version;
	
	@FindBy(xpath="//body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	WebElement Size;
	
	@FindBy(xpath="//body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]")
	WebElement Filename;
	
	@FindBy(xpath="//body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]")
	WebElement Tag;
	
	@FindBy(className="xrx-fw-terms-conditions__checkbox")
	WebElement CheckAgree;
	
	@FindBy(xpath="//a[normalize-space()='Download']")
	WebElement Download;

	//Constructor, as every page needs a Web driver to find elements
	public PCLDriverDetails(WebDriver driver){
		this.driver=driver;
		//PageFactory.initElements(driver, this);	
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(factory, this);
		waithelper=new WaitHelper(driver);
	}

	public String screenShot() {
		return ((TakesScreenshot)driver) .getScreenshotAs(OutputType.BASE64);
	}
	
	public void moveDown() {
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		exe.executeScript("arguments[0].scrollIntoView(true)", Released);
	}
	
	public void Get_ReleasedDate(String releasedate) throws IOException {
		test=extent.createTest("Xerox PCL Driver Details Validation");
		waithelper.WaitForElement(Released, 20);
		String val=Released.getText();
		if(val.contentEquals(releasedate))
		{
			test.pass("Released date is successful validation " + "Expected=" + releasedate +" Actual=" +val);
		}
		else {
			moveDown();
			test.fail("Released date is not successful validation " + "Expected=" + releasedate +" Actual :" +val,
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			//BaseClass.getScreenShot(driver, val);
		}
	}		
	
	public void Get_Version(String version) throws IOException {
		waithelper.WaitForElement(Version, 20);
		String val=Version.getText();
		if(val.contentEquals(version))
		{
			test.pass("Version is successful validation " + "Expected=" + version +" Actual=" +val);
		}
		else {
			moveDown();
			test.fail("Version is not successful validation " + "Expected=" + version +" Actual :" +val,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			//BaseClass.getScreenShot(driver, val);
		}
	}	
	
	public void Get_Size(String size) throws IOException {
		waithelper.WaitForElement(Size, 20);
		String val=Size.getText();
		if(val.contentEquals(size))
		{
			test.pass("Size is successful validation " + "Expected=" + size +" Actual=" +val);
		}
		else {
			moveDown();
			test.fail("Size is not successful validation " + "Expected=" + size +" Actual :" +val,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());	
			//BaseClass.getScreenShot(driver, val);
		}
	}		
	
	public void Get_Filename(String filename) throws IOException {
		waithelper.WaitForElement(Filename, 20);
		String val=Filename.getText();
		if(val.contentEquals(filename))
		{
			test.pass("Filename is successful validation " + "Expected=" + filename +" Actual=" +val);
		}
		else {
			moveDown();
			test.fail("Filename is not successful validation " + "Expected=" + filename +" Actual :" +val,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());	
			//BaseClass.getScreenShot(driver, val);
		}
	}		
	
	public void Get_Tag(String tag) throws IOException {
		waithelper.WaitForElement(Tag, 20);
		String val=Tag.getText();
		if(val.contentEquals(tag))
		{
			test.pass("Tag is successful validation " + "Expected=" + tag +" Actual=" +val);
		}
		else {
			moveDown();
			test.fail("Tag is not successful validation " + "Expected=" + tag +" Actual :" +val,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			//BaseClass.getScreenShot(driver, val);
		}
	}		
	
	public void Get_Agree() {
		waithelper.WaitForElement(CheckAgree, 20);
		CheckAgree.click();
		test.pass("Clicked the Agree CheckBox");
		
	}		
	
	
	public void Get_Download() throws InterruptedException {
		waithelper.WaitForElement(Download, 20);
		Download.click();
		test.pass("Clicked the Download Button");
}

}