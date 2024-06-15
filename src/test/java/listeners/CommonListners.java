package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appium.Base;

import utils.CommonUtils;



public class CommonListners extends Base implements ITestListener{
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Base.test.pass(result.getName() + " Test Passed");
		

}
	@Override
	public void onTestFailure(ITestResult result) {
		Base.test.fail(result.getName() + " Test Failed");
		
		try {
			Base.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(Base.getDriver()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


}
