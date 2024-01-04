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

//glue code 
public class ValidationTest {

	WebDriver driver;
	LoginPage loginPage;
	public ValidationTest() {
		
	}
	@Given("user is on login page")
	public void hi() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 driver = new
		  ChromeDriver(options);
		driver.get("https://www.saucedemo.com");
		loginPage = new LoginPage(driver);
	}
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

	}
	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.loginButton();

	}

	@Then("user is navigated to the homepage")
	public void user_is_navigated_to_the_homepage() {
		Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());
		driver.quit();
	}
}