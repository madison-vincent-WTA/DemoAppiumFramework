import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements Testng listeners

// Not being used for the moment
public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Starting Test "+ result.getTestName()+"");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(""+result.getTestName()+" has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//screenshot code
		//response if API is failed

		System.out.println(""+result.getTestName()+" has failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(""+result.getTestName()+" was skipped");
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
