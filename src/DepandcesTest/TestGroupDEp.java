package DepandcesTest;

import org.testng.annotations.Test;

public class TestGroupDEp {
	@Test(groups = "Smoke")
	public void test1() {
		System.out.println("Smoke");
	}

	@Test(groups = "Smoke")
	public void test2() {
		System.out.println("Smoke");
	}

	@Test(groups = "Smoke")
	public void test3() {
		//System.out.println("Smoke");
	System.out.println(5 / 0);
	}

	@Test(groups = "Sanity")
	public void test4() {
		System.out.println("Sanity");
	}

	@Test(groups = "regression")
	public void test5() {
		System.out.println("regression");
	}

//	@Test(dependsOnGroups = { "Smoke", "Sanity" })
//	public void test0() {
//		System.out.println("main test");
//	}

}
