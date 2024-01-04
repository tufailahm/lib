package com.training.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.cms.data.SharedData;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test (groups = "rameshtest")
public class LoginTest {
	
  @Test (priority = 1, groups = "logintestgroup", timeOut = 2000)
  public void setDatabaseConnectionTest	() throws InterruptedException {
	  System.out.println("1. setDatabaseConnectionTest");
	  Thread.sleep(1000);//cpu		//2 seconds
	  // throw AE 
  }
  
	@Test(dataProvider = "loginData" , dataProviderClass = SharedData.class)
	public void TestLogin(String userName, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}
  @Test(priority = 2 , groups = "logintestgroup")
  public void checkForCredentialsTest() {
	  System.out.println("2. checkForCredentialsTest");
	//  int i=1/0;
  }
  @Test(priority = 3, groups = "logintestgroup")
  public void closeDBTest() {
	  System.out.println("3. closeDBTest");
  }
  @Test(priority = 3 , dependsOnGroups = "logintestgroup")
  public void fetchEmployeeData() {
	  System.out.println("3. fetchEmployeeData");
  }
  @Test(priority = 4, groups = {"logintestgroup", "employeetestgroup"} )
  public void deleteEmployeeData() {
	  System.out.println("3. fetchEmployeeData");
  }
  @Test(priority = 5, groups = {"employeetestgroup"} )
  public void updateEmployeeData() {
	  System.out.println("4. updateEmployeeData");
  }
  
  @Test(priority = 6)
  public void notPartOfAnyGroup() {
	  System.out.println("4. notPartOfAnyGroup");
  }
}
