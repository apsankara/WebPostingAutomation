package com.xeroxDriverPosting.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void WaitForElement(WebElement element, long TimeOutInSecond) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(TimeOutInSecond));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void WaitForElement(List<WebElement> element, long timeOutInSecond) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOutInSecond));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
}
