package com.lms.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lms.utils.DriverProvider;

public class ProgramPage {
	
	private WebDriver driver;
	private By headertextBy = By.xpath("//div[contains(text(),'Manage')]");

	public ProgramPage() {
		this.driver = DriverProvider.getdriver();

	}
	
	public String getHeader() {
		return driver.findElement(headertextBy).getText();
	}
	
	
	 

}
