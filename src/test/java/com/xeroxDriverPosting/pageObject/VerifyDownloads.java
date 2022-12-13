package com.xeroxDriverPosting.pageObject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.xeroxDriverPosting.utilities.WaitHelper;


public class VerifyDownloads {
	public WebDriver driver;
	WaitHelper waithelper;
	
	//Constructor, as every page needs a Web driver to find elements
		public VerifyDownloads(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
			AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,30);
			PageFactory.initElements(factory, this);
			waithelper=new WaitHelper(driver);
		}
	
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
	
	public void isFileNameCheck(String downloadpath, String filename, String elename) throws IOException {
		try {
		File file=new File(downloadpath);
		File[] totalfiles=file.listFiles();
		
		for(File list:totalfiles) {
			if(list.getName().contains(filename)) {				
				break;
			}
		}
		}
		catch(Exception ex) {			
			throw ex;
			
		}
	}
	
	
	
	public void DownlodWaitTime(String path) 
	{ 
		File file = new File(path);
	  FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(900)).
	  pollingEvery(Duration.ofMillis(30000)); wait.until( x -> file.exists());
	  }
	 
		

    }
    
    



	
