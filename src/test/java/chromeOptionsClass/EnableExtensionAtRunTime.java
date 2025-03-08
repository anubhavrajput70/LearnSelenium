package chromeOptionsClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRunTime {
	
public static void main(String args[])
{
	
	//1. Add CRX Extractor/Downloader to Chrome Browser (manually)
	//2. Add SelectorHub plugin to Chrome browser (manually)
	//3. Capture CRX file for SelectorHub extension
	//4. pass CRX file path in automation script in chrome option
	
	ChromeOptions co = new ChromeOptions();
	File file = new File("C:\\Users\\anubh\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
	co.addExtensions(file);
	
	WebDriver driver = new ChromeDriver(co);
	
	driver.get("https://text-compare.com/");

}

}
