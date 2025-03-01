package windowAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		
		//normal alert with ok button
//		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
//		Alert myalert= driver.switchTo().alert();
//		System.out.println(myalert.getText());
//		myalert.accept();
//		
		
		//confirmation alert ok and cancel
//		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
//		driver.switchTo().alert().accept(); //close button using ok button
//		driver.switchTo().alert().dismiss();// close button using cancel button
//		
		//prompt alert which is having input box
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		Alert myalert=driver.switchTo().alert();
		myalert.sendKeys("selenium");
		myalert.accept();
		

	}

}
