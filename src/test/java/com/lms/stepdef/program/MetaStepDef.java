package com.lms.stepdef.program;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lms.utils.DriverProvider;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class MetaStepDef {
	@AfterStep
	public void endstep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) DriverProvider.getdriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
	}
}
