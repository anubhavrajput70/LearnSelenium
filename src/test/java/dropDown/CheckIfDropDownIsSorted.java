package dropDown;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckIfDropDownIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
		
		ArrayList<String> original = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		
		List<WebElement> options = dropdown.getOptions();
		
		for(WebElement option:options)
		{
			original.add(option.getText());
			temp.add(option.getText());
		}
		Collections.sort(temp);
		if(!original.equals(temp))
		{
			System.out.println("list was not sorted");
			System.out.println(original);
			System.out.println(temp);
		}
		else
		{
			System.out.println("list was sorted");
		}
	}

}
