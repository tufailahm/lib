package com.training.cms;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test (groups = "rameshtest")
public class CalculatorTest {

	Calculator calculator;
	int expected =0;
	int actual=0;
	
	@BeforeTest
	public void setup() {
		System.out.println("setting it up for testing ");
		calculator = new Calculator();
		expected = 20;
	}
	@BeforeMethod
	public void settingUpMethod() {
		System.out.println("setting it up for testing for each ");
		expected = 20;
	}
	
	@AfterTest
	public void doCleanupWork() {
		System.out.println("doCleanupWork called");
		calculator = null;		// eligible for GC
		expected = 0;
		actual=0;
	}
	
	
	@Test(priority = 3, groups="weeklytest", timeOut = 2000)
//	@Parameters({"number1", "number2"})
	public void testAddNumbers1(@Optional("49")Integer n1,@Optional("1")Integer n2) throws InterruptedException {
			System.out.println("3.   testAddNumbers1 called "+n1+n2);
				expected=50;
				Thread.sleep(1000);
			 actual = calculator.addNumbers(n1, n2);
			//assertEquals(actual,expected);
			
	}
	
	@Test(priority = 1)
	@Parameters("number1")
	public void testAddNumbers2(@Optional("22")Integer num1) {
			System.out.println("1.  testAddNumbers2 called :  "+num1);
			expected=10;
			actual = calculator.addNumbers(num1, 0);
			assertEquals(10,expected);
	}
	
	@Test(priority = 2)
	public void testAddNumbers3() {
			System.out.println("2.  testAddNumbers3 called");
			 actual = calculator.addNumbers(12, 8);
			assertEquals(actual,20);
	}
	
	@Test(priority = 3)
	public void testAddNumbers4() {
			System.out.println("4.  testAddNumbers4 called int and string");
			 actual = calculator.addNumbers(12, "8");
			assertEquals(actual,expected);
	}
	
	@Test(expectedExceptions = { NumberFormatException.class })
	public void testAddNumbers5() {
		System.out.println("5.  testAddNumbers4 called int and string");
		 actual = calculator.addNumbers(12, "ddasd");
		assertEquals(actual,expected);
}
	
	
	@Test
	public void testDiv1() {
		System.out.println("1.  testDiv1 called 10 and 5");
		 actual = calculator.div(10, 5);
		 expected=2;
		assertEquals(actual,expected);
}
	@Test(expectedExceptions = {ArithmeticException.class})
	public void testDiv2() {
		System.out.println("2.  testDiv2 called 10 and 0");
		 actual = calculator.div(10, 0);
		 expected=2;
		assertEquals(actual,expected);
}
}
