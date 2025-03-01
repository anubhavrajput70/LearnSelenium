package checkBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		//1. select specific check box
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2. select all the check boxes
		
//		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//		
//		for(WebElement cb: checkbox)
//		{
//			cb.click();
//		}
//		
		//3. select last 3 checkboxes
//		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//		for(int i=4;i<checkbox.size();i++)
//		{
//			checkbox.get(i).click();
//		}
		
		//4. select first 3 checkboxes
//		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//		for(int i=0;i<3;i++)
//		{
//			checkbox.get(i).click();
//		}
		
		//5. unselect checkboxes which are selected
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for(int i=0;i<checkbox.size();i++)
		{
			if(i%2!=0)
			checkbox.get(i).click();
		}
		for(int i=0;i<checkbox.size();i++)
		{
			if(!checkbox.get(i).isSelected())
				checkbox.get(i).click();
			else
				checkbox.get(i).click();
		}
	}
	

}
