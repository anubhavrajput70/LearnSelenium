package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		//Min slider element 
		WebElement min_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		//printing current location
		System.out.println("location of minimum slider"+min_slider.getLocation()); //(59,249) = (x,y)
		act.dragAndDropBy(min_slider, 100, 249).perform();
		System.out.println("location of minimum slider"+min_slider.getLocation()); //(158,249) = (x,y)
		
		WebElement max_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		System.out.println("location of maximum slider"+max_slider.getLocation()); //(510,249) = (x,y)
		act.dragAndDropBy(max_slider, -100, 249).perform();
		System.out.println("location of maximum slider"+max_slider.getLocation()); //(410,249) = (x,y)
		
	}

}
