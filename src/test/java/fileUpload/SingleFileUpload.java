package fileUpload;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		// upload single file
//		String filePath="C://Users//anubh//Downloads//Responsible for Automating UI test.txt";
//		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(filePath);
//		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Responsible for Automating UI test.txt"))
//		{
//			System.out.println("successfully uploaded");
//		}
//		else
//		{
//			System.out.println("upload fail ");
//		}
		
		//upload multiple file
		String file1="C://Users//anubh//Downloads//Responsible for Automating UI test.txt";
		String file2="C://Users//anubh//Downloads//Responsible for Automating UI test.txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		int count=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		//checking number of files
		if(count==2)
		{
			System.out.println("all file uploaded");
		}
		else
		{
			System.out.println("all file are not uploaded");
		}
		
		//checking names of file
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Responsible for Automating UI test.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Responsible for Automating UI test.txt"))
			{
				System.out.println("file names matching");
			}
			else
			{
				System.out.println("file names are not matching");
			}
		

	}

}
