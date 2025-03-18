package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//constructor to initiate the driver
//locator
//action method
public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	
	By userName_loc=By.xpath("//input[@placeholder='Username']");
	By password_loc=By.xpath("//input[@placeholder='Password']");
	By login_btn_loc=By.xpath("(//button[normalize-space()='Login'])[1]");
	
	//Actions
	public void setUserName(String userName)
	{
		driver.findElement(userName_loc).sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(password_loc).sendKeys(password);
	}

	public void clickLogin()
	{
		driver.findElement(login_btn_loc).click();
	}



}
