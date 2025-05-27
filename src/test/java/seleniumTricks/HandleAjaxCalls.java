package seleniumTricks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//AJAX Call:
//----------------
//An AJAX call is a web development technique that allows a website to pdate a part of its content without reloading the entire page
//AJAX Stands for Asynchronous JavaScript and XML, and its a collection of technologies that make web application more responsive to use interation 
// without loading the entire page we just try to load a portion or part of the web page
public class HandleAjaxCalls {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='loadContent']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loaded =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']//h2")));
		System.out.println(loaded.getText());
		

	}

}
