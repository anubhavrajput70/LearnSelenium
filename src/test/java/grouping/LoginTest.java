package grouping;

/*Requirements
 * loginByFacebook - sanity
 * loginByEmail - sanity
 * loginByTwitter - sanity
 * 
 * signupByFacebook - Regression
 * signupByTwitter - Regression
 * signupByEmail - Regression
 * 
 * paymentInRuppees - sanity, Regression, (Functional)
 * paymentInDollar - sanity, Regression, (Functional)
 * */
import org.testng.annotations.Test;

public class LoginTest {

	
	@Test(priority=1, groups="sanity")
	void loginByEmail()
	{
		System.out.println("login by email");
	}
	@Test(priority=2, groups="sanity")
	void loginByFacebook()
	{
		System.out.println("login by facebook");
	}
	@Test(priority=3, groups="sanity")
	void loginByTwitter()
	{
		System.out.println("login by twitter");
	}
}
