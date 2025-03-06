package actionsClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//in selenium 4 now we can open 2 urls in two different tabs
		driver.get("https://demo.nopcommerce.com/");
		
//		//now it will open the new url in the new tab and switch to the new tab
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://orangehrm.com");
		
		//now it will open the new url in the new window and switch to the new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://orangehrm.com");
		driver.manage().window().maximize();

	}

}
