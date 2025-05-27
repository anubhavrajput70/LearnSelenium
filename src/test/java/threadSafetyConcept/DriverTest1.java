package threadSafetyConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DriverTest1 {
	
	private static ThreadLocal<WebDriver>tdriver = new ThreadLocal<>();
	
	WebDriver driver;
	
	public void setDriver(WebDriver driver)
	{
		tdriver.set(driver);
	}
	
	public WebDriver getDriver()
	{
		return tdriver.get();
	}
	
	@Test
	void mytest1()
	{
		driver = new ChromeDriver();
		setDriver(driver);
		getDriver().get("https://www.google.com");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}
	
	@Test
	void mytest2()
	{
		driver = new ChromeDriver();
		setDriver(driver);
		getDriver().get("https://www.bing.com");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}
	 
	@AfterClass
	void tearDown()
	{
		tdriver.remove();
	}

}
