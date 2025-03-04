package datePickers;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	//user defined method for converting month from String to Month object
	static Month convertMonth(String month)
	{
		HashMap<String,Month> monthMap=new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth=monthMap.get(month);
		if(vmonth==null)
			System.out.println("Invalid month.....");
		
		return vmonth;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mui.com/x/react-date-pickers/date-picker/");
		driver.manage().window().maximize();
		
		String exYear="2012";
		String exMonth="July";
		String exdate="23";
		
		driver.findElement(By.xpath("//div[@id='demo-:r3:']//button[@aria-label='Choose date']")).click();
		WebElement link=driver.findElement(By.xpath("//div[@class='MuiPickersLayout-root css-jaa451']//button[contains(@aria-label,'calendar')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", link);
		
		List<WebElement> yearList=driver.findElements(By.xpath("//div[@role='radiogroup']//div//button"));		
		System.out.println("List contains "+yearList.size()+" years");
		for(WebElement year: yearList)
		{
			if(year.getText().equals(exYear))
			{
				year.click();
				break;
			}
		}
		
		while(true)
		{
		//select month
		String disMonth=driver.findElement(By.xpath("//div[contains(text(),'"+exYear+"')]")).getText();
		disMonth=disMonth.replace(" "+exYear, "");
		System.out.println(disMonth);
		
		//convert required month and display month into month objects
		Month expectedMonth=convertMonth(exMonth);
		Month displayMonth=convertMonth(disMonth);
		
		//compare
		int result=expectedMonth.compareTo(displayMonth);
		//0 month are equal
		//>0 future month
		//< 0 past
		
		if(result<0)
		{
			System.out.println("clicking pre");
			//pastmonth clicking previous button
			driver.findElement(By.xpath("//div[@class='MuiPickersLayout-root css-jaa451']//button[@title='Previous month']")).click();
		}
		else if(result>0)
		{
			System.out.println("clicking next");
			//future month  clicking next month
			driver.findElement(By.xpath("//div[@class='MuiPickersLayout-root css-jaa451']//button[@title='Next month']")).click();
		}else
		{
			break;
		}
		}
		
		
	}
}
