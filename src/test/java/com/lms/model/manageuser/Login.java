package com.lms.model.manageuser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.lms.utils.DriverProvider;

public class Login {

	WebDriver driver;

	public Login() {
		this.driver = DriverProvider.getdriver();
		PageFactory.initElements(driver, this);
	}

	// By user_name = By.xpath("//input[@data-placeholder='User']");
	By user_name = By.id("username");
	By pass_word = By.id("password");
	// By pass_word = By.xpath("//input[@data-placeholder='Password']");
	By login = By.xpath("//button[@type='submit']");

	public void setuser(String Username) {
		driver.findElement(user_name).sendKeys(Username);
	}

	public void setpassword(String Password) {
		driver.findElement(pass_word).sendKeys(Password);
	}

	public void clickloginbtn() {
		driver.findElement(login).click();
	}
}
