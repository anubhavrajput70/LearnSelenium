package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAndDADPractice {
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		field1.clear();
		field1.sendKeys("anubhav");

		Actions act = new Actions(driver);
		act.doubleClick(button).perform();

		if(field2.getAttribute("value").equals("anubhav"))
		{
			System.out.println("copied");
		}else
		{
			System.out.println("not copied");
		}

		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination=driver.findElement(By.xpath("//div[@id='droppable']"));

		act.dragAndDrop(source, destination).perform();

		boolean flag=driver.findElement(By.xpath("//p[normalize-space()='Dropped!']")).isDisplayed();

		if(flag)
		{
			System.out.println("displayed");
		}
		else
		{
			System.out.println("not displayed");
		}
	}
}
