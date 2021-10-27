package com.Framework.Listeners;

import com.Framework.Base.AndroidBase;
import com.Framework.Base.IOSBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

//ITestListener interface which implements Testng listeners

public class Listeners implements ITestListener {

	AndroidBase base = new AndroidBase();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("***** Starting Test: "+ result.getName()+" *****");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("***** Test: "+result.getName()+" has passed *****");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Test: "+result.getName()+" has failed *****");
		try {
			AndroidBase.getScreenshot(result.getName());
			//TODO how to make this non specific to ios or android? right now it only screenshots the android phone
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("***** Test: "+result.getTestName()+" was skipped *****");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
