package fileUpload;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadWithoutSendKeys {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.foundit.in/upload?");

		driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();

		WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", upload);

		// 1) Copy the file path to the clipboard
		String filePath = "C:\\Users\\anubh\\Downloads\\ANUBHAVRAJPUT.txt";
		StringSelection filePathSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

		// 2) Simulate Ctrl+V and Enter using Robot
		Robot robot = new Robot();
		Thread.sleep(2000); // Wait for the file dialog to appear

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement submitbtn = driver.findElement(By.xpath("//input[@id='pop_upload']"));
		js.executeScript("arguments[0].click();", submitbtn);
	}
	
}
