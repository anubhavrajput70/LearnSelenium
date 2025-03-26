package pomUsingPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//constructor to initiate the driver
//locator
//action method
public class LoginPage {

	WebDriver driver;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// this will try to initiate all the elements using the driver which we passed
		PageFactory.initElements(driver, this);
	}

	// locators

	// @FindBy(xpath = "//input[@placeholder='Username']") WebElement text_userName;
	// another way to declare webelements
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	WebElement text_userName;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement text_password;
	@FindBy(xpath = "(//button[normalize-space()='Login'])[1]")
	WebElement login_btn;

	// Actions
	public void setUserName(String userName) {
		text_userName.sendKeys(userName);
	}

	public void setPassword(String password) {
		text_password.sendKeys(password);
	}

	public void clickLogin() {
		login_btn.click();
	}
}
