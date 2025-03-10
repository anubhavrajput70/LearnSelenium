package excel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelPracticeCitiFD {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		String xlPath = System.getProperty("user.dir")+"\\testdata\\citiFD.xlsx";
		int rowCount = ExcelUtils.getRowCount(xlPath,"Sheet1" );

		System.out.println(rowCount);

		for(int i=1;i<=rowCount;i++)
		{
			String initAmount = ExcelUtils.getCellData(xlPath, "Sheet1", i, 0);
			String length = ExcelUtils.getCellData(xlPath, "Sheet1", i, 1);
			String interestRate = ExcelUtils.getCellData(xlPath, "Sheet1", i, 2);
			String compounding = ExcelUtils.getCellData(xlPath, "Sheet1", i, 3);
			String total = ExcelUtils.getCellData(xlPath, "Sheet1", i, 4);

			WebElement amount = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			amount.clear();
			amount.sendKeys(initAmount);
			WebElement month = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			month.clear();
			month.sendKeys(length);
			WebElement interest = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			interest.clear();
			interest.sendKeys(interestRate);


			WebElement comp = driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", comp);

			List<WebElement> list = driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));
			for(WebElement li: list)
			{
				if(li.getText().equals(compounding))
				{
					li.click();
					break;
				}
			}
			WebElement submitBtn = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click()", submitBtn);

			WebElement compValue = driver.findElement(By.xpath("//span[@id='displayTotalValue']"));
			System.out.println("comp value: "+compValue.getText());
			System.out.println("total: "+total);
			if(compValue.getText().equals(total))
			{
				System.out.println("test passed");
				ExcelUtils.setCellData(xlPath, "Sheet1", i, 5, "Passed");
				ExcelUtils.fillGreenColor(xlPath, "Sheet1", i, 5);
			}
			else
			{
				System.out.println("test failed");
				ExcelUtils.setCellData(xlPath, "Sheet1", i, 5, "Failed");
				ExcelUtils.fillRedColor(xlPath, "Sheet1", i, 5);
			}
		}
		driver.quit();

	}

}
