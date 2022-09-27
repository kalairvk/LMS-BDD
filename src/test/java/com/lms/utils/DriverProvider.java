package com.lms.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
	
	private static WebDriver driver;
	
	public static WebDriver getdriver() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		return driver;
	}

	public static void quit() {
		driver.quit();

	}
	
}

