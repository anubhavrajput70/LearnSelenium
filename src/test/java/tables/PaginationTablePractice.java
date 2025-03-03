package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTablePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id='pagination']//li"));
		System.out.println("number of pages is: "+list.size());
		
		List<WebElement> row=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
		System.out.println("number of rows is: "+row.size());
		
		for(int j=1;j<=list.size();j++)
		{
		if(j>1)
		driver.findElement(By.xpath("//ul[@id='pagination']//li//a[contains(text(),'"+j+"')]")).click();
		Thread.sleep(3000);
		for(int i=1;i<=row.size();i++)
		{
			String sn=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[1]")).getText();
			String name=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[2]")).getText();
			String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[3]")).getText();
			WebElement checkbox=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[4]//input"));
			checkbox.click();
			System.out.println(sn+"\t"+name+"\t"+price);
			
		}
		}
	

	}

}
