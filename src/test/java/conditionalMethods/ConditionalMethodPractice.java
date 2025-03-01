package conditionalMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethodPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement siteTitle=driver.findElement(By.xpath("//h1[@class='title']"));
		if(siteTitle.isDisplayed())
		{
			System.out.println("title displayed");
		}
		else
		{
			System.out.println("title is not displayed");
		}

	}

}
