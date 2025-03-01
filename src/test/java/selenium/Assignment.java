package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println("no. of links on site is: "+link.size());
		List<WebElement> image=driver.findElements(By.tagName("img"));
		System.out.println("no. of images on site is: "+image.size());
		driver.findElement(By.linkText("Laptops")).click();

	}

}
