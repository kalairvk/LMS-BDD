package com.lms.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.lms.utils.DriverProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, // reporting purpose
		monochrome = true, // console output
		// tags = {@tag1,@tag2,@tag3,@tag4}, //tags from feature file
		publish = true, features = { "src/test/resources/features" }, // location of feature files
		glue = "com.lms.stepdef") // location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	@AfterSuite
	public void shutdown() {
		DriverProvider.quit();
	}

}
