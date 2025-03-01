package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		//get(url) - open the url in the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//getTitle() -  returns the title of the web page
		System.out.println(driver.getTitle());
		
		//getCurrentUrl() - return the url of the web page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource() - return source code of page
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle() - returns the ID of the single web browser window
		System.out.println(driver.getWindowHandle());
		
		//getWindowHandles() - returns the IDs of the multiple browser window
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowIDs=driver.getWindowHandles();
		System.out.println(windowIDs);
		
		driver.close();
	}

}
