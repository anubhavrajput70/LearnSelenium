package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dummy-tickets.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(.,'Both')]")).click();
		
//		driver.findElement(By.xpath("(//form[@id='both_oneway']//div[@class='route_1 row p-0 pt-3']//input)[1]")).sendKeys("bal");
//		driver.findElement(By.xpath("//p[normalize-space()='Batman Airport,']")).click();
//		driver.findElement(By.xpath("(//form[@id='both_oneway']//div[@class='route_1 row p-0 pt-3']//input)[2]")).sendKeys("bal");
//		driver.findElement(By.xpath("(//div[@class='suggestion-block']//p)[8]")).click();
//		
		WebElement link=driver.findElement(By.xpath("(//form[@id='both_oneway']//div[@class='col-sm-12 p-0']//input)[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", link);
		
	}

}
