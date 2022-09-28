package com.lms.model.program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lms.utils.ConfigProperties;
import com.lms.utils.DriverProvider;

public class LoginPage {

	private WebDriver driver;
	private By submitloginBy = By.id("login");
	private By homepageHeaderBy = By.xpath("//mat-toolbar[@color='primary']/span[1]");

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

	

	public void setfields(String fieldname, String value) {
		driver.findElement(By.id(fieldname)).clear();
		driver.findElement(By.id(fieldname)).sendKeys(value);
	}

	public void clickloginbtn() {
		driver.findElement(submitloginBy).click();
    }
	
	public String getErrorMsgForInvalidCredentials() {
		return driver.findElement(By.id("errormessage")).getText().trim();
		
	}
	
	public String getHomepageHeader() {
		return driver.findElement(homepageHeaderBy).getText().trim();
	}

}
	
