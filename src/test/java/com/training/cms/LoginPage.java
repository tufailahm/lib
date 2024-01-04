package com.training.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//POM in cucumber - Page Object Model - Reusability 
public class LoginPage {

	private WebDriver driver;
	private By txt_username = By.id("user-name");
	private By txt_password = By.id("password");
	private  By btn_login = By.id("login-button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	public void loginButton() {
		driver.findElement(btn_login).click();
	}
}
