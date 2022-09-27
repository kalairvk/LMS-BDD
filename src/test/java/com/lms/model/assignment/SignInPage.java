package com.lms.model.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class SignInPage {
	private WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@data-placeholder='User']") WebElement username;
	@FindBy(how=How.XPATH, using="//input[@data-placeholder='Password']") WebElement password;
	@FindBy(how=How.XPATH, using="//span[@class='mat-button-wrapper']") WebElement loginButton;
	

	
	public void enterUsername(String uname) {
		username.clear();
		username.sendKeys(uname);
	}
	
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void successMsg() {
		
	}
	
	
}
