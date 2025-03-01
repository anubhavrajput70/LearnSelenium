package dropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		//login steps
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//clicking on PIMs
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		//clicked on dropdown
		driver.findElement(By.xpath(" (//div[contains(text(),'Select')])[2]")).click();
		
		//select single option
		//driver.findElement(By.xpath("//span[contains(text(),'Automaton Tester')]")).click();
		
		Thread.sleep(5000);
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
		System.out.println("number of options is: "+options.size());
		
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
	}
	

}
