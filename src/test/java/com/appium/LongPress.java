package com.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableBiMap;

import io.appium.java_client.AppiumBy;
import listeners.CommonListners;
@Listeners(CommonListners.class)
public class LongPress extends Base{
	
	@Test
	public void longPressTest() {
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		test.log(Status.INFO, "clicked ov view");
		WebElement longele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture" , ImmutableBiMap.of
				("elementId",((RemoteWebElement)longele).getId(),"duration" , 3000));
		
		WebElement smenu = driver.findElement(By.id("android:id/title"));
	
		String peopleText = smenu.getText();
		
		Assert.assertEquals(peopleText, "Sample menu");
		
		boolean display = smenu.isDisplayed();
		Assert.assertTrue(display);
		
		
		
	}

}
