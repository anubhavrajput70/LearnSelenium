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

public class CountBookInInfiniteScrollingPage {
	
	public static void main(String Args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.booksbykilo.in/new-books");
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int prevCount=0;
		int currCount=0;
		while(true)
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='divItemCard']"));
			currCount=books.size();
			if(currCount==prevCount)
			{
				break;
			}
			prevCount=currCount;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//we can also scroll by Action class
			act.sendKeys(Keys.END).perform();
			Thread.sleep(2000);
		}
		
		System.out.println("total books on the page is: "+currCount);
		driver.quit();
		
	}

}
