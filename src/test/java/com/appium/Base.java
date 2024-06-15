package com.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstant;





public class Base {
	
	public static AndroidDriver driver;
	
	
	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
	
	public static Logger logger = LogManager.getLogger(Base.class.getName());

	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		
		//create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setNativeWebScreenshot(true);
		options.setDeviceName("SreeMobile");
		options.setApp("C:\\JavaPrograms\\appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		//create object for AndroidDriver
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		
		//Locators : xpath , id , className, accessibilityId , androidUIautomator
		
		
	}
	
	@BeforeMethod
	public static void setup(Method name) {
		try {
			Base.test = extent.createTest(name.getName());
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}

	}
	
	@BeforeTest
	public static void setDriver() {
		spark = new ExtentSparkReporter(new File(FileConstant.REPORT_PATH));
		extent.attachReporter(spark);

	}
	
	
	
	public static  AndroidDriver getDriver() {
		return driver;
		
			
	}
	
	
		
	
	
	@AfterTest
	public static void removeDriver() {

		extent.flush();
	}

	

	

}
