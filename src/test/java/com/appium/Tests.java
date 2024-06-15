package com.appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import listeners.CommonListners;
@Listeners(CommonListners.class)
public class Tests  extends Base{
	
	//@Test
	public void Test01() {
		
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	}
	
	@Test
	public void viewTextTest() {
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Buttons']")).click();
		String normalBtn = driver.findElement(By.id("io.appium.android.apis:id/button_normal")).getText();
		
		Assert.assertEquals(normalBtn, "Normal");
		
		
	}

}
