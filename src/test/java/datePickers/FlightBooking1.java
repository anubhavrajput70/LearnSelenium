package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking1 {
	
	static void dateSelector(WebDriver driver,String date,String month,String year)
	{
		WebElement selectYear=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selyear=new Select(selectYear);
		selyear.selectByValue(year);
		
		WebElement selectMonth=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selMonth=new Select(selectMonth);
		selMonth.selectByVisibleText(month);
		
		List<WebElement> dateList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement da:dateList)
		{
			if(da.getText().equals(date))
			{
				da.click();
				break;
			}
		}
	}

	static void dropDownSelector(WebDriver driver,String value)
	{
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		for(WebElement li:list)
		{
			if(li.getText().equals(value)) {
				li.click();
				break;
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		//clcking on radio button
		driver.findElement(By.xpath("//input[@id='product_3186']")).click();
		
		//filling firstname and lastname
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Anubhav");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Rajput");
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		dateSelector(driver, "19", "Aug", "1999");
		
		driver.findElement(By.xpath("//input[@id='sex_1']")).click();
		
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Bangalore");
		
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		
		dateSelector(driver, "19", "Feb", "2026");
		
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("demo@gamil.com");
		
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		dropDownSelector(driver, "India");
		
		
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Avenue Street");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Hudson");
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
		dropDownSelector(driver, "Goa");
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("234522");
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		
	}

}
