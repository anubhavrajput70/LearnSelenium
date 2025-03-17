package testNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtilityListner implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent;//populate common info of the report
	public ExtentTest test;// creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context )
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");//specify the location of the report
		sparkReporter.config().setDocumentTitle("Automation Report");//title of report
		sparkReporter.config().setReportName("Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Anubhav");
		extent.setSystemInfo("os", "Windows 10");
		extent.setSystemInfo("Browser Name", "Chrome");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());// create a new entry in the report
		test.log(Status.PASS, "Test case Passed is: "+result.getName());//update the test p/f/s
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());// create a new entry in the report
		test.log(Status.FAIL, "Test case Failed is: "+result.getName());//update the test p/f/s
		test.log(Status.FAIL, "Test case Failed cause is: "+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());// create a new entry in the report
		test.log(Status.SKIP, "Test case Skipped is: "+result.getName());//update the test p/f/s
	}
	
	public void onFinish(ITestContext context)
	{
		//all the things will be updated in the report
		extent.flush();
	}
}
