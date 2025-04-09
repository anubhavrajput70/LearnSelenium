package navigationalCommands;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		//get method internally implementing the get method 
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		//internally it is calling get method only as it we have passes the url object then first it convert to string then 
		//pass it to the get method internally
		URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(url);

		driver.manage().window().maximize();
	}

}
