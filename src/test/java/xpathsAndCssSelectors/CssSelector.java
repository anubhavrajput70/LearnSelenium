package xpathsAndCssSelectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag id   tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");//id unique
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");
		
		//tag class tag.class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mobile"); 
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Mobile"); 
		
		//tag attribute
		//driver.findElement(By.cssSelector("input[placeholder='Search Store']")).sendKeys("mobile");
		//driver.findElement(By.cssSelector("[placeholder='Search Store']")).sendKeys("mobile");
		
		//tag class attribute
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("mobile");
		//driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("mobile");
	}

}
