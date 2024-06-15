package com.appium;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import listeners.CommonListners;
@Listeners(CommonListners.class)
public class Scroll extends Base{
	
	@Test
	public void scrollTest() {
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// scroll until view an element
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\"WebView\"))")).click();
		
		
	}

}
