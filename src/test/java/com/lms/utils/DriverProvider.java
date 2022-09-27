package com.lms.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
	
	private static WebDriver driver;
	
	public static WebDriver getdriver() {
		if(driver == null) {
			switch(ConfigProperties.getBrowser()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
				driver = new FirefoxDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver");
				driver = new EdgeDriver();
				break;
			}
			
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

