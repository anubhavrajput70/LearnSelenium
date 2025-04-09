package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinksPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless=new");

		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		List<WebElement> list = driver.findElements(By.xpath("//div[@id='broken-links']//a"));

		for (WebElement li : list) {
			String href = li.getDomAttribute("href");
			System.out.println(href);
			if (href == null || href.equals("")) {
				System.out.println("link not found");
			} else {
				try {
					URL url = new URL(href);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.connect();
					if (con.getResponseCode() >= 400) {
						System.out.println("brokenlink");
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}

	}

}
