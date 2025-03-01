package checkBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxPractive {
	
	public static void main(String[] args){
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> links=driver.findElements(By.xpath("//input[@type='checkbox']//parent::td"));
		System.out.println(links.size());
		for(WebElement lnk: links)
		{
			lnk.click();
		}
	}

}
