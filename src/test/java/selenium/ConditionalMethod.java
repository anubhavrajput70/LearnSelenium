package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//isDisplayed
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println("Display status of logo: "+logo.isDisplayed());
		
		//isEnabled
		Boolean usernameStatus=driver.findElement(By.xpath("//input[@name='username']")).isEnabled();
		System.out.println("username is enabled ?: "+usernameStatus);
		
		//isSelected
		WebElement maleRd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		System.out.println(maleRd.isSelected());

	}

}
