package chromeOptionsClass;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//we need to do this before creating the driver and pass it to the driver constructor
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless=new"); //setting for headless mode of execution
		
		WebDriver driver = new ChromeDriver(co);
//		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new FirefoxDriver();
//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println("no. of links on site is: "+link.size());
		List<WebElement> image=driver.findElements(By.tagName("img"));
		System.out.println("no. of images on site is: "+image.size());
		driver.findElement(By.linkText("Laptops")).click();
		
		String title = driver.getTitle();
		
		if(title.equals("STORE"))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		driver.close();
	}

}
