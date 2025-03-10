package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*1. Login -- @BeforeClass
 * 2. Search -- @Test
 * 3. Advanced Search -- @Test
 * 4. Logout  -- @AfterClass*/

public class BeforeAndAfterClass {
	
	@BeforeClass
	void login()
	{
		System.out.println("login");
	}

	@AfterClass
	void logout()
	{
		System.out.println("logout");
	}

	@Test(priority=1)
	void search()
	{
		System.out.println("Search");
	}

	@Test(priority=2)
	void advancedSearch()
	{
		System.out.println("advancedSearch");
	}

}
