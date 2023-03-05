package Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({IListenersTest.class})
public class TestClass1 {
	@Test
	public void testMethod1() {
      System.out.println("Im inside testmethod1 ");
	}

	@Test
	public void testMethod2() {

		 System.out.println("Im inside testmethod2 ");
		 Assert.assertTrue(false);
	}

	@Test(timeOut = 1000)
	public void testMethod3() throws Exception {
		Thread.sleep(2000);

		 System.out.println("Im inside testmethod3 ");
	}

	@Test(dependsOnMethods = "testMethod3")
	public void testMethod4() {

		 System.out.println("Im inside testmethod4 ");
	}
}
