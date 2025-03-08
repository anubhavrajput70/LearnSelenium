package chromeOptionsClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true); //accept ssl certificate
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
	}

}
