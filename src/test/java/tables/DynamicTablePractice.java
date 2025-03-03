package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTablePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		//login steps
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")).click();
		
		List<WebElement> row=driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
		System.out.println("number of rows is: "+row.size());
		
		for(int i=1;i<=row.size();i++)
		{
			String username=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div["+i+"]//div[1]//div[2]//div")).getText();
			String role=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div["+i+"]//div[1]//div[3]//div")).getText();
			System.out.println(username+"\t"+role);
		}
		

	}

}
