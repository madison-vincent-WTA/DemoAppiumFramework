package com.Framework.Listeners;

import com.Framework.AndroidBase;
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
			base.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***** Test: "+result.getTestName()+" was skipped *****");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
