package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	
	@Test
	void test()
	{
		
		//Assert.assertEquals("abc","abc"); //pass
		//Assert.assertEquals(123,123); //pass
		//Assert.assertEquals("abc",123); //fail
		//Assert.assertEquals("123",123); //fail
		
		//Assert.assertNotEquals("abc","abc"); //fail
		
		//Assert.assertNotEquals(123,234); //pass
		
		//Assert.assertTrue(true);// pass
		//Assert.assertTrue(false);// fail
		//Assert.assertTrue(1==2);// fail	
		//Assert.assertTrue(1==1);// pass
		
		//Assert.assertFalse(1==2);// pass
		//Assert.assertFalse(1==1); //fail
		
		//just fail the method
		Assert.fail();
		
		
	}

}
