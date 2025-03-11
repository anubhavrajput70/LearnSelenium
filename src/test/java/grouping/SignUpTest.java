package grouping;

import org.testng.annotations.Test;

public class SignUpTest {
	
	@Test(priority=1, groups="regression")
	void signUpByEmail()
	{
		System.out.println("sign up email");
	}

	@Test(priority=2, groups="regression")
	void signUpByFacebook()
	{
		System.out.println("sign up facebook");
	}
	
	@Test(priority=3, groups="regression")
	void signUpBytwitter()
	{
		System.out.println("sign up twitter");
	}
}
