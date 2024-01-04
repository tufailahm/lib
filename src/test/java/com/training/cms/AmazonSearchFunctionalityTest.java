package com.training.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchFunctionalityTest {

	WebDriver driver;
	public AmazonSearchFunctionalityTest() {
		// TODO Auto-generated constructor stub
	}
	@Given("user is on amazon home page")
	public void user_is_on_amazon_home_page() {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		  driver = new ChromeDriver(options);
		  driver.get("http://www.amazon.in");
	}

	@When("user enters product name in serach box")
	public void user_enters_product_name_in_serach_box() {
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("latestmobiles");
	}

	@When("user click on search button")
	public void user_click_on_search_button() {
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}

	@Then("user is navigated to the results page")
	public void user_is_navigated_to_the_results_page() {
		Assert.assertTrue(driver.findElement(By.id("a-autoid-1-announce")).isDisplayed());
		driver.quit();
	}
}
