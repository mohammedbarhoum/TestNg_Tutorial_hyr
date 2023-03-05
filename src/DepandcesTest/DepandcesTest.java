package DepandcesTest;

import org.testng.annotations.Test;

public class DepandcesTest {
	static String trachingNumber = null;

	@Test(priority = 1)
	public void Createshipment() {
    //	System.out.println(5/0);
		System.out.println("Createshipment");
		trachingNumber = "ABC12YH";
		
	}

	@Test(priority = 2,dependsOnMethods = {"Createshipment"})
	public void Trackshipment() throws Exception

	{
		if (trachingNumber != null) {
			System.out.println("Createshipment");

		} else {

			throw new Exception("invaild tracking number");
		}
	}

	@Test(priority = 3,dependsOnMethods = {"Createshipment","Trackshipment"})
	public void Cancelshipment() throws Exception {

		if (trachingNumber != null)
			System.out.println("Cancelshipment");

		else

			throw new Exception("invaild tracking number");

	}
}
