package windowAlerts;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// normal url
		// driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");

		// we are using url injection method for bypassing the authenticated popup
		// modified url it will skip the signin window
		driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).isDisplayed());

	}

}
