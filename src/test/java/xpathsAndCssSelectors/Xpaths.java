package xpathsAndCssSelectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//x path with single attribute
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("mobile");
		
		//x path with multiple attribute
		//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("Mobile");
		
		//x path with and or operator
		//driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("Mobile");
		//driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("Mobile");
		
		//x path with inner text - text()
		//driver.findElement(By.xpath("//a[text()='Desktops']")).sendKeys(args).sendKeys("mobile");
		
		// xpath path with contains() method
		//driver.findElement(By.xpath("//input[conatins(@placeholder,'sea')]"));
		
		//xpath with starts-with
		//driver.findElement(By.xpath("//input[starts-with(@placeholder,'sea')]"));
	}

}
