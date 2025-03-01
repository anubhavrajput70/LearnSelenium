package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("welcome");
		
		WebElement link=driver.findElement(By.xpath("//a[contains(text(),'a9t9')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", link);
		System.out.println("logo display status: "+driver.findElement(By.xpath("(//img[@class='responsive-img'])[1]")).isDisplayed());
	}

}
