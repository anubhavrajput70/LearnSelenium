package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Task 1
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='country-list']"));
		Select sel=new Select(dropdown);
		List<WebElement> options=sel.getOptions();
		System.out.println("number of option is: "+options.size());
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		sel.selectByIndex(2);
		
		//Task 2
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//login steps
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//clicking on PIMs
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Select')])[1]")).click();
		Thread.sleep(5000);
		List<WebElement> link=driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
		System.out.println("total number of option is: "+link.size());
		for(WebElement lnk: link)
		{
			System.out.println(lnk.getText());
		}
		driver.findElement(By.xpath("//span[contains(text(),'Part-Time Contract')]")).click();
		
		//Task 3
		driver.get("https://www.bjs.com/");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("fridge");
		List<WebElement> suggestion=driver.findElements(By.xpath("//div[@class='list list-group']//a"));
		System.out.println("total number of suggested elements are: "+suggestion.size());
		for(WebElement sug:suggestion)
		{
			System.out.println(sug.getText());
		}
	}

}
