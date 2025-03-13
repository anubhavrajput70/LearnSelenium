package testNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//listener class can be implemented through ITestListener
// or listener class can be extended through TestListenerAdapter all the methods are implmented previously
//we can have only one listener class because for all the test we need same post action
public class MyListener implements ITestListener {


	@Override
	public void onStart(ITestContext context) {
		System.out.println("test execution is started");
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("test execution               finished");
	}


}
