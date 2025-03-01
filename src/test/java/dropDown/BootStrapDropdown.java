package dropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		//1. select single option
		//driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//2. capture all the option and find the size
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("number of options is: "+options.size());
		
		//3.printing option from dropdown
//		for(int i=0;i<options.size();i++)
//		{
//			System.out.println(options.get(i).getText());
//		}
		
		//4. select multiple options
		for(WebElement op: options)
		{		
				String opt=op.getText();
				if(opt.equals("Java")||opt.equals("Python")||opt.equals("MySQL"))
				{
					op.click();
				}
		}
		
	}

}
