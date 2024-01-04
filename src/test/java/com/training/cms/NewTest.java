package com.training.cms;

import java.util.Date;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.cms.data.ExcelSharedData;
import com.training.cms.data.SharedData;

@Test(groups = "rameshtest")
public class NewTest {
	
	
	  String username,password; 
  @Test(priority = 2,
		  dataProvider = "getCredentialsFromExcel", 
		  dataProviderClass = ExcelSharedData.class)
  @Parameters({"username","password"})
  public void testingLoginCredentials(@Optional("richard")String un,@Optional("richard123")String pass) {
	  this.username = un;
	  this.password = pass;
	  System.out.println("2.  testingLoginCredentials called with : "+un+ "  and  "+pass);
	  Reporter.log("Testing login credentials with :"+un+ " at date/time :"+new Date());
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @Test(priority = 1, dependsOnMethods = "testingLoginCredentials", alwaysRun = true, ignoreMissingDependencies = true )		//test dependencies with priority
  public void testingHomePageLoad() {
	  System.out.println("1. testingHomePageLoad : "+username+ "  and  "+password);
  }
  
	@Test(dataProvider = "nameTestData" , 
			dataProviderClass = SharedData.class)
	public void nameTest(String names) {		//Dataprovider without indices
			System.out.println("nameTestData called  :  " + names);
	
	}
}
/*
Hands on : Create 4 tests  and group them as critical

create 5th test which depends on this group "critical" 
Requirement :

1) If any test(s) fails in critical group the 5th test should not get executed
2) 1st test should always run no matter what scenario is
3) 3rd test depends on 2nd test
4) missing dependencies of 3rd test should not impact the execution/testing of 3rd test.

Time : 15 minutes
*/
