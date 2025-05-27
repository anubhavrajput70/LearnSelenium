package seleniumTricks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelTestUsingDataProvider {

	@Test(dataProvider = "loginData")
	public void loginTest(String email,String password) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[contains(@class,'login-button')]")).click();
		
		boolean loginStatus;
		try {
			loginStatus = driver.findElement(By.xpath("a[contains(text(),'Log Out')]")).isDisplayed();
			Assert.assertTrue(loginStatus);
		} catch (Exception e) {
			// TODO: handle exception
			loginStatus=false;
			Assert.assertTrue(loginStatus);
		}
		finally {
			driver.quit();
		}
		
		

	}
	
//	@DataProvider(parallel = true,indices = {0,1}) to run specific index from the data provider
	@DataProvider(parallel = true)
	public String[][] loginData()
	{
		String[][] data= {{"john.done123@gmail.com","test@123"},
		{"john.done123@gmail.com","test@321"},
		{"john.done321@gmail.com","test@123"},
		{"john.done12@gmail.com","test@12"}};
		return data;
	}

}
