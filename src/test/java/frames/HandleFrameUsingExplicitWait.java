package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleFrameUsingExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome1");
		
		driver.switchTo().defaultContent();
	}

}
