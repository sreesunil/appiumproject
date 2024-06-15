package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public static AndroidDriver driver;
	
	public void launchApp() throws MalformedURLException {
		
		/*
		 * //create capabilities UiAutomator2Options options = new
		 * UiAutomator2Options(); options.setNativeWebScreenshot(true);
		 * options.setDeviceName("SreeMobile"); options.setApp(
		 * "C:\\JavaPrograms\\appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		 * 
		 * //create object for AndroidDriver
		 * 
		 * driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		 */
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=ApiDemos-debug.apk");  // The filename of the mobile app
		caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "12.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-ammuedamana-4b59e");
		sauceOptions.setCapability("accessKey", "b9db3039-35a7-4e27-9ff5-cbf7a371ffe5");
		sauceOptions.setCapability("build", "appium-build-PBL3M");
		sauceOptions.setCapability("name", "<your test name>");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);
		
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		 driver = new AndroidDriver(url, caps);
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();;
	}

}
