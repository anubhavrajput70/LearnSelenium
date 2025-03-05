package actionsClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		//switch to frame
		driver.switchTo().frame("iframeResult");

		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));	
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));	
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		field1.clear();
		field1.sendKeys("welcome");

		//double click action on the button
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();

		System.out.println(field2.getText());
		//VALIDATION FIELD2 SHOULD contains ''welcome

		if(field2.getAttribute("value").equals("welcome"))
		{
			System.out.println("text copied");
		}
		else
		{
			System.out.println("text not copied ");
		}
	}

}
