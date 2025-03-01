package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		String SearchText="java";
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(SearchText);
		List<WebElement> suggestions=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println("total number of suggestion is: "+suggestions.size());
		for(int i=0;i<suggestions.size();i++)
		{
			System.out.println(suggestions.get(i).getText());
			if(suggestions.get(i).equals(SearchText))
			{
				suggestions.get(i).click();
			}
		}
	}
	
}
