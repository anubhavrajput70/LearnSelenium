package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//find total number of rows in the table 
		int row=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		
		//int row=driver.findElements(By.tagName("tr")).size(); //single table in the web page
		System.out.println("total number of rows: "+row);
		
		//find total number of columns in the tables
		int col=driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size();
		System.out.println("total number of columns: "+col);
		
		//read data from specific rows and tables (ex: 5th row and 1st column)
		String element=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Book name: "+element);
		
		//read data from all the rows and col
		/*for(int r=2;r<=row;r++) {
			for(int c=1;c<=col;c++)
			{
				String s=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(s+"\t");
			}
			System.out.println();
		}
		*/
		
		//print book name if autor name is mukesh
		
		/*for(int i=2;i<row;i++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			if(author.equals("Mukesh"))
			{
				String book=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();

				System.out.println(book+"\t"+author);
			}
		}*/
		
		//find total prices of the book
		int sum=0;
		for(int i=2;i<row;i++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			sum=sum+Integer.parseInt(price);
		}
		System.out.println("total prices of the book: "+sum);

	}

}
