package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		System.out.println("Number of Rows is: "+rows.size());
		
		for(int i=1;i<=rows.size();i++)
		{
			String browser =driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+i+"]//td[1]")).getText();
			if(browser.equals("Chrome"))
			{
				String cupload=driver.findElement(By.xpath("//td[contains(text(),'Chrome')]//following-sibling::*[contains(text(),'%')]")).getText();
				String value=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				if(value.contains(cupload))
				{
					System.out.println("chrome cpu load is matching");
				}
				else
				{
					System.out.println("chrome cpu load is not matching");
				}
				break;
			}
		}
		
		
	}
}
