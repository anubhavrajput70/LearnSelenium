package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*1. Login -- @BeforeMethod
 * 2. Search -- @Test
 * 3. Logout -- @AfterMethod
 * 4. Login --
 * 5. Advanced Search -- @Test
 * 6. Logout*/

public class BeforeAndAfterMethod {

	@BeforeMethod
	void login()
	{
		System.out.println("login");
	}


	@AfterMethod
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
