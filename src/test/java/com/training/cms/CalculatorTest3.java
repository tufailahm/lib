package com.training.cms;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.cms.data.SharedData;

public class CalculatorTest3 {

	Calculator calculator;
	int expected = 0;
	int actual = 0;

	@BeforeTest
	public void setup() {
		System.out.println("setting it up for testing ");
		calculator = new Calculator();
		expected = 20;
	}

	@Test(dataProvider = "testData")
	public void testAddNumbers(Integer n1,Integer n2) {
		System.out.println("2.  testAddNumbers3 called  :  "+n1+"      "+n2);
		actual = calculator.addNumbers(n1, n2);
		assertEquals(actual, expected);
		Reporter.log("Test addnumbers passed successfully ############");
	}

	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username,String password) {
		System.out.println("loginTest called  :  "+username+"      "+password);
	}
	
	@DataProvider
	public String[][] loginTestData() {
		String[][] data = new String[][] {
			{ "ramesh","r2amesh123"},
			{ "ramesh","ra2mesh12323"},
			{ "ramesh","ram2esh1323"},
			{ "2ramesh","ram2esh12123"},
			{ "1ramesh","ram22esh1123"},
		};
		
		return data;
	}
	
	
	
	@DataProvider
	public Object[][] testData() {
		Object[][] data = new Object[5][2];
		data[0][0] = 10;
		data[0][1] = 10;
		data[1][0] = 1;
		data[1][1] = 19;	
		return data;
	}
	
	//List testing
	
	@Test(dataProvider = "nameTestData" , 
			dataProviderClass = SharedData.class)
	public void nameTest(String names) {		//Dataprovider without indices
			System.out.println("nameTestData called  :  " + names);
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
