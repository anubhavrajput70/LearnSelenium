package javascriptExecutor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//if you got elementInterceptedException then use javascriptExecutor
		
		//passing the text into the inputbox - alternative for sendKeys()
		WebElement inputBox=driver.findElement(By.xpath("//input[@id='name']"));
		
		//child class object we are storing into parent class variable
		//if you create the driver object directly of the ChromeDriver class then you don't even
		//need to type case because it is not pointing to parent class
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//JavascriptExecutor js = driver;
		js.executeScript("arguments[0].setAttribute('value','John')", inputBox);
		
		//clicking on element - alternative of click()
		WebElement rdbutton=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", rdbutton);		

	}

}
