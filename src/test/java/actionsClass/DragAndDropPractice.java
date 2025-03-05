package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();

		WebElement source1=driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement destination1=driver.findElement(By.xpath("//ol[@id='bank']"));
		WebElement source2=driver.findElement(By.xpath("(//a[contains(text(),'5000')])[2]"));
		WebElement destination2=driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(source1, destination1).perform();
		act.dragAndDrop(source2, destination2).perform();

		WebElement source3=driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement destination3=driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
		WebElement source4=driver.findElement(By.xpath("(//a[contains(text(),'5000')])[2]"));
		WebElement destination4=driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		act.dragAndDrop(source3, destination3).perform();
		act.dragAndDrop(source4, destination4).perform();

		boolean flag=driver.findElement(By.xpath("//a[normalize-space()='Perfect!']")).isDisplayed();

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
