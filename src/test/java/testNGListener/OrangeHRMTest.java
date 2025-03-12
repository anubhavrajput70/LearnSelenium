package testNGListener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//without having xml file we can trigger the listener class with the help of the @listener annotations
//but preferable is xml file because we need to add this annotation in the all the classes
@Listeners(testNGListener.MyListener.class)
public class OrangeHRMTest {
	//for all the classes there is only one listener
	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void testLogo() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test(priority=2)
	public void testappUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=3,dependsOnMethods="testappUrl")
	public void testHomePageTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
