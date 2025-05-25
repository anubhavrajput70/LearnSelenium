package screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();

//		//capture full page screenshot
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir")+"\\screenShot\\fullpage.png");
//		//copy source file to target file
//		sourceFile.renameTo(targetFile);

		// capture screenshot of specific area of the page
//		WebElement box=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//		File sourceFile = box.getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir")+"\\screenShot\\fullpage1.png");
//		//copy source file to target file
//		sourceFile.renameTo(targetFile);

		// capture screenshot of webElement
		WebElement box = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourceFile = box.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\screenShot\\fullpage2.png");
		// copy source file to target file
		sourceFile.renameTo(targetFile);

	}

}
