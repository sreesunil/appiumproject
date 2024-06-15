package com.appium;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends Base{
	
	@Test
	public void dragAndDrop() {
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		
		Point sourceElementCenter = getCenter(source);
		System.out.println(sourceElementCenter);
		Point targerElementCenter = getCenter(target);
		System.out.println(targerElementCenter);
		int x1 = 300;
		int y1 = 650;
		
		int x2 =621;
		int y2 = 650;
		//pointerinput class is to create a sequence of action
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1)
		
		//move finger to the starting point
		
		.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),x1,y1))
		.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger1, Duration.ofMillis(500)))
		.addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),x2,y2))
		.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(sequence));
		
		
		
	}
	
	
	public static Point getCenter(WebElement element) {
		
		Point location = element.getLocation();
		Dimension size = element.getSize();
		
		Point center = new Point(location.x+size.width/2, location.y+size.height/2);
		return center;
		
		
	}
	
	
	
	
	
	
	

}
