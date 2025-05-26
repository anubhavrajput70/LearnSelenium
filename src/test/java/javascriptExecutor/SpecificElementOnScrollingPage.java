package javascriptExecutor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpecificElementOnScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.booksbykilo.in/new-books");
		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean flag = true;
		while(flag)
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='divItemCard']//h3"));
			for(WebElement book: books)
			{
				if(book.getText().equals("How to Code"))
				{
					System.out.println("book found");
					flag=false;
					break;
				}
			}
			
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
		}

	}

}
