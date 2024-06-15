package com.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import listeners.CommonListners;


@Listeners(CommonListners.class)
public class Swipe extends Base {
	
	@Test
	public void swipeTest() {
		
		
		driver = Base.getDriver();
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		String firstvalue =firstImage.getAttribute("focusable");
		
		Assert.assertEquals("true", firstvalue);
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)firstImage).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
		
		
	}

}
