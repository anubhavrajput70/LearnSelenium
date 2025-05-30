package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DpendencyMethods {

	@Test(priority=1)
	void openApp()
	{
		Assert.assertTrue(true);
	}
	
	//if open app failed then login will skipped
	@Test(priority=2,dependsOnMethods="openApp")
	void login()
	{
		Assert.assertTrue(false);
	}
	@Test(priority=3,dependsOnMethods="login")
	void search()
	{
		Assert.assertTrue(true);
	}
	@Test(priority=4,dependsOnMethods={"login","search"})
	void advsearch()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=5,dependsOnMethods="login")
	void logout()
	{
		Assert.assertTrue(true);
	}
	
	
	
	
}
