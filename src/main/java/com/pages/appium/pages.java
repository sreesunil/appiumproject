package com.pages.appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class pages {
	
	AndroidDriver driver;
	
	public pages(AndroidDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Preference\"]")
	public WebElement preferences;
	
	
	@AndroidFindBy(xpath= "//android.widget.TextView[@content-desc=\"Views\"]")
	public WebElement view;
	
	@AndroidFindBy(accessibility = "Gallery")
	public WebElement galley;
	
	
	
	
	public void clickPreference(AndroidDriver driver) {
		
		preferences.click();
	}
	
	
	public void viewText(AndroidDriver driver) {
		
		view.click();
		
		
	}
	
	public void swipeTest(AndroidDriver driver) {
		
		view.click();
		galley.click();
	}
	

}
