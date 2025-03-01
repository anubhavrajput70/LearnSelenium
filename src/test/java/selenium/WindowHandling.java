package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM')]")).click();
		
		Set<String> windowIds=driver.getWindowHandles();
		
		
//		//approach 1
//		List<String> windowList=new ArrayList<String>(windowIds);
//		String parentid=windowList.get(0);
//		String childid=windowList.get(1);
//		
//		System.out.println("current window handle: "+driver.getTitle());
//		
//		//switch to child window
//		driver.switchTo().window(childid);
//		System.out.println("current window handle: "+driver.getTitle());
//		
//		//switch to parent window
//		driver.switchTo().window(parentid);
//		System.out.println("current window handle: "+driver.getTitle());
		
		
		//approach 2
		
		for(String winid: windowIds)
		{
			String title=driver.switchTo().window(winid).getTitle();
			if(title.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
			
		}
		
		driver.quit();
		
		
		
		//driver.quit();

	}

}
