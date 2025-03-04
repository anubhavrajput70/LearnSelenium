package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	static void selectFutureDate(WebDriver driver,String month,String year,String date)
	{
		//select month and year 
		while(true)
		{
			String currMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currMonth.equals(month)&&currYear.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next date
			//	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();// past date
		}
		//select the date
				List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
				for(WebElement dt: dates)
				{
					if(dt.getText().equals(date))
					{
						dt.click();
						break;
					}
				}
	}

	static void selectPastDate(WebDriver driver,String month,String year,String date)
	{
		//select month and year 
		while(true)
		{
			String currMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currMonth.equals(month)&&currYear.equals(year))
			{
				break;
			}
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next date
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();// past date
		}
		//select the date
				List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
				for(WebElement dt: dates)
				{
					if(dt.getText().equals(date))
					{
						dt.click();
						break;
					}
				}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		//switching to the frame
		driver.switchTo().frame(0);

		//method 1 using sendkeys method
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("03/03/2025");

		//method 2 date picker
		String year="2023";
		String month="May";
		String date="1";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//selectFutureDate(driver, month, year,date);
		selectPastDate(driver, month, year, date);




	}

}
