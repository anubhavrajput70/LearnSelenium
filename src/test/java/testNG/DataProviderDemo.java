package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String password) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

	//by passing indices we can run the test with specific index data
	//data provider name should be unique
	@DataProvider(name="dp", indices= {0,3,4})
	Object[][] loginData()
	{
		//better to keep data as object because it can store any type of data
		//prepating the test data and returning it
		//we can create test data also we can fetch it from the excel 
		Object data[][]= {
				{"abc@gmail.com","12345"},
				{"xyz@gmail.com","12345"},
				{"mno@gmail.com","12345"},
				{"pqr@gmail.com","12345"},
				{"stu@gmail.com","12345"},};
		
		return data;
	}
}
