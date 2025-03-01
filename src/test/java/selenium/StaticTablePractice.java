package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticTablePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//selecting departure city
		WebElement fromCity=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select from=new Select(fromCity);
		from.selectByIndex(2);
		
		//selecting destination city
		WebElement toCity=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select to=new Select(toCity);
		to.selectByIndex(2);
		
		//clicking on the find flight
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		//finding the number of rows
		List<WebElement> row=driver.findElements(By.xpath("//table[@class='table']//tr"));
		System.out.println("number of rows is: "+row.size());
		
		//creating the array with the size of rows and setting all the prices in the array
		double[] arr=new double[row.size()-1];
		for(int i=1;i<row.size();i++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
			price=price.replace("$", "");
			arr[i-1]=Double.parseDouble(price);
		}
		
		//sorting and printing the lowest price
		Arrays.sort(arr);
		double lowPrice=arr[0];
		System.out.println("lowest price: "+lowPrice);
		
		//clicking on the lowest flight
		for(int i=1;i<row.size();i++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
			price=price.replace("$", "");
			if(lowPrice==Double.parseDouble(price))
			{
				String flightName=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[3]")).getText();
				System.out.println("selecting "+flightName+" flight");
				driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[1]//input")).click();
				break;
			}
		}
		
		//filling all the details and submit
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Anubahv");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("123 Main street");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Bijnor");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("UP");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("246731");
		WebElement cardType=driver.findElement(By.xpath("//select[@id='cardType']"));
		Select card=new Select(cardType);
		card.selectByIndex(1);
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1234 3245 2345 2345");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("11");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2017");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Anubhav Rajput");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		Boolean status=driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]")).isDisplayed();
		if(status)
			System.out.println("thank you for booking");
		else
			System.out.println("error");

	}

}
