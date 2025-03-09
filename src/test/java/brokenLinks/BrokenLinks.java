package brokenLinks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	//broken link is a link which does not have any resource in the server
  /*1. link should have href attribute and corresponding value
	2. hit the url on the server then check the status code
	3. if status code >=400 broken link
		if status code < 400 not a broken link */
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("total number of link: "+links.size());
		
		int brokenLinkCount=0;
		//captureing the href attribute value
		for(WebElement linkElement: links)
		{
			String hrefValue=linkElement.getAttribute("href");
			if(hrefValue==null ||  hrefValue.isEmpty())
			{
				System.out.println("href attribute is null or empty");
				continue;
			} 
			try {
				//htting url to the server
				URL linkUrl = new URL(hrefValue);// converted href value from string to url format
				HttpURLConnection con=(HttpURLConnection) linkUrl.openConnection();//open connection to the server`
				con.connect();//connect to server and sent request to the server
				
				if(con.getResponseCode()>=400)
				{
					brokenLinkCount++;
					System.out.println(hrefValue+"======> broken link");
				}
				else
				{
					System.out.println(hrefValue+"======> not a broken link");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(brokenLinkCount);
		
		

	}

}
