package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM')]")).click();
		
		Set<String> windowIds=driver.getWindowHandles();
		
	//approach 2
		
		for(String winid: windowIds)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(driver.getCurrentUrl());
			if(title.equals("OrangeHRM"))
			{
				driver.close();
			}
		
		}
		
		
	}

}
