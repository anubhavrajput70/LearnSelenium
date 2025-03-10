package testNG;

import org.testng.annotations.Test;

/*
 1. open app
 2. login 
 3. log out*/

public class FirstTestCase {
	@Test(priority=1)
	void openApp()
	{
		System.out.println("opening app");
	}
	
	@Test(priority=2)
	void login()
	{
		System.out.println("login to application");
	}
	
	@Test(priority=3)
	void logout()
	{
		System.out.println("logout from application");
	}
}
