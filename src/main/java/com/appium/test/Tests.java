package com.appium.test;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.appium.pages;

public class Tests extends BaseTest{
	
	
	@BeforeClass
	public void launch() throws MalformedURLException {
		
		launchApp();
		
		
	}
	
	@Test
	public void testCase01() {
		
		pages page = new pages(driver);
		page.clickPreference(driver);
	}
	
	//@Test
	public void testCase02() {
		
		pages page = new pages(driver);
		page.viewText(driver);
		
	}
	
	
	//@Test
	public void testCase03() {
		
		pages page = new pages(driver);
		page.swipeTest(driver);
	}

}
