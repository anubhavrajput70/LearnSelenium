package windowAlerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertUsingJSExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.alert.function{}");
		} catch (Exception e) {
		
		}

	}

}
