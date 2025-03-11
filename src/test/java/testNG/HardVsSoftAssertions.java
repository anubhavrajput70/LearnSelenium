package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	@Test
	void test_HardAssertions()
	{
		System.out.println("testin");
		System.out.println("testin");

		//if hard assertions fails then all the statements will not be executed so last statement should be assertion
		//methods are static so we can access directly
		Assert.assertEquals(123, 23);

		System.out.println("testin");
		System.out.println("testin");
	}

	@Test
	void test_SoftAsserions()
	{
		System.out.println("testin");
		System.out.println("testin");

		//in SoftAssert class methods are not static so we need to create object first of class
		//if assertion fails then it will continue to execute the statements test case also fails
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(123, 12);

		System.out.println("testin");
		System.out.println("testin");

		//in case of softAssert this method is mandatory
		sa.assertAll();
	}

}
