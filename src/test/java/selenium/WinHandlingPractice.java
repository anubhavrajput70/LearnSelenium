package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WinHandlingPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[contains(@id,'search-input')]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[contains(@class,'search-button')]")).click();
		
		List<WebElement> links=driver.findElements(By.xpath("//a[contains(text(),'Selenium') or contains(text(),'More')]"));
		
		System.out.println("number of links is: "+links.size());
		for(WebElement lnk: links)
		{
			lnk.click();
		}
		Set<String> windowID=driver.getWindowHandles();
		List<String> ids=new ArrayList<String>(windowID);
		System.out.println("number of handles :"+ids.size());
		for(String id: ids)
		{
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("Selenium in biology - Wikipedia")||title.equals("Selenium - Search results - Wikipedia")||title.equals("Selenium disulfide - Wikipedia"))
			{
				System.out.println(title);
				driver.close();
			}	
		}
		driver.quit();

	}

}
