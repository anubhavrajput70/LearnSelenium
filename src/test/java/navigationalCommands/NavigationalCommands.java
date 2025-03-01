package navigationalCommands;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		  
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");\
		
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		URL url=new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(url);  
		
		driver.manage().window().maximize();
	}

}
