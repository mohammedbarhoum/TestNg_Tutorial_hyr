package ScreenShot;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestLisetener extends BassTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		captureScreenshot(result.getTestContext().getName() +"_"+  result.getMethod().getMethodName()+".jpg");
	}

	
}
