package dropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement drpcountry=driver.findElement(By.xpath("//select[@id='country']"));
		Select sel=new Select(drpcountry);
		sel.selectByVisibleText("France"); 
		
		//to get all the option from the dropdown
		List<WebElement> options= sel.getOptions();
		System.out.println("number of options in the dropdown: "+options.size());
		
		//printing the options of the list
//		for(int i=0;i<options.size();i++)
//		{
//			System.out.println(options.get(i).getText());
//		}
		
		for(WebElement opt: options)
		{
			System.out.println(opt.getText());
		}
	}

}
