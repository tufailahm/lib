package com.training.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	public AmazonTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void amazonTest1() {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 ChromeDriver  driver = new ChromeDriver(options);

		driver.get("http://www.amazon.in");
	//	driver.manage().window().maximize();
		//twotabsearchtextbox id of the test textbox - right click and select the id for textbox and search button 
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("latestmobiles");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}
}
