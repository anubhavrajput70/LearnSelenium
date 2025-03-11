package grouping;

import org.testng.annotations.Test;

public class PaymentTest {
	
	@Test(priority=1, groups={"sanity","regression","functional"})
	void paymentInRuppes()
	{
		System.out.println("payment in ruppess");
	}

	@Test(priority=2, groups={"sanity","regression","functional"})
	void paymentInDollar()
	{
		System.out.println("payment in dollar");
	}
}
