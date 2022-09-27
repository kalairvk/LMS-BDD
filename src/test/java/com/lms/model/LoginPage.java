package com.lms.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lms.utils.ConfigProperties;
import com.lms.utils.DriverProvider;

public class LoginPage {

	private WebDriver driver;
	private By submitloginBy = By.id("login");

	public LoginPage() {
		this.driver = DriverProvider.getdriver();

	}

	public void OpenURL() {
		driver.get(ConfigProperties.getProperty("app.url"));
	}
	
	public void Login() {
		driver.findElement(By.id("username")).sendKeys(ConfigProperties.getProperty("user"));
		driver.findElement(By.id("password")).sendKeys(ConfigProperties.getProperty("pwd"));
		driver.findElement(submitloginBy).click();
	}

}
