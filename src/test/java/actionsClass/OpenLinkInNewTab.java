package actionsClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		//to open the link in the new tab ctrl+click
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		//switching to register page  
//		Set<String> handles=driver.getWindowHandles();
//		String parent=driver.getWindowHandle();
//		for(String han:handles)
//		{
//			if(han!=parent)
//			{
//				driver.switchTo().window(han);
//			}
//		}
		
		List<String> ids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		
	}

}
