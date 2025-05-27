package seleniumTricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Pseudo Elements:
//Pseudo Elements are abstract elements in CSS
// allow you to style specific parts of an element without adding extra html
//Ex:
// ::first-line -> 
// ::selection  -> to select element
// ::before		-> star is before the field
// ::after		-> star is after the field
// ::has		-> has some inbuilt content


public class FindMandatoryFieldsOnPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		List<WebElement> fields= driver.findElements(By.xpath("//div[@class='form-group']//label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(WebElement options: fields)
		{
			String script = "return window.getComputedStyle(arguments[0],'::Before' ).getPropertyValue('content');";
			String content=js.executeScript(script, options).toString();
			System.out.println(content);
			if(content.contains("*"))
			{
				System.out.println("Mandatory field: "+options);
			}
			else
			{
				System.out.println("Not a mandatory field: "+options);
			}
		}

	}

}
