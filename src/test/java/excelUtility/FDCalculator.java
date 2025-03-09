package excelUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		
		//excel file path
		String filePath = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		//number of rows in the excel file
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		//for loop starting from 1 beause we don't need the header part
		for(int i=1;i<=rows;i++)
		{
			//1. read data from excel
			String principle = ExcelUtils.getCellData(filePath,"Sheet1", i, 0);
			String roi = ExcelUtils.getCellData(filePath,"Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filePath,"Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filePath,"Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath,"Sheet1", i, 4);
			String exp_mvalue = ExcelUtils.getCellData(filePath,"Sheet1", i, 5);
			
			//2. pass the data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			WebElement drpdwn = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select sel = new Select(drpdwn);
			sel.selectByVisibleText(period2);
			WebElement drpdwn1 = driver.findElement(By.xpath("//select[@id='frequency']"));
			Select sel1 = new Select(drpdwn1);
			sel1.selectByVisibleText(freq);
			//clicking on calculate button
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]")).click();
			
			//validation
			String act_value = driver.findElement(By.xpath("//div[@class='PR20 PT5']//span[2]//strong")).getText();
			
			//comparing and converting the String value to the double to compare the numbers
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_value))
			{
				System.out.println("Test passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			//clicking on clear button
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]")).click();
		}
		driver.quit();
	}

}
