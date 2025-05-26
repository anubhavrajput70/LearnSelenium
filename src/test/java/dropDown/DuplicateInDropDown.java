package dropDown;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateInDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		WebElement drpdwn=driver.findElement(By.xpath("//select[@id='colors']"));
		Select sel = new Select(drpdwn);
		
		Set<String> uniqueValues = new HashSet<String>();
		
		boolean flag= true;
		List<WebElement> options = sel.getOptions();
		for(WebElement option:options)
		{
			if(!uniqueValues.add(option.getText()))
			{
				System.out.println("duplicate value: "+option.getText());
				flag=false;
			}
		}
		if(flag)
		{
			System.out.println("no duplicates");
		}

	}

}
