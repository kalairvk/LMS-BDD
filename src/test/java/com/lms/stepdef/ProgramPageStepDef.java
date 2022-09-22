package com.lms.stepdef;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lms.model.LoginPage;
import com.lms.model.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPageStepDef {
	
	private LoginPage loginpage;
	private ProgramPage programpage;
	private static Logger logger = LogManager.getLogger(ProgramPageStepDef.class);
	

	@Given("User is logged on to LMS website")
	public void user_is_logged_on_to_lms_website() {
		loginpage = new LoginPage();
		loginpage.OpenURL();
		// Write code here that turns the phrase above into concrete actions
	}

	@When("User is on Program page")
	public void user_is_on_program_page() {
		loginpage.Login();
		logger.info("LMSWebsite launched");
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("User should see a heading with text {string} on the page")
	public void user_should_see_a_heading_with_text_on_the_page(String headertxt) {
		programpage = new ProgramPage();
		programpage.getHeader();
		logger.info(headertxt);
		assertEquals(programpage.getHeader(), headertxt);
		// Write code here that turns the phrase above into concrete actions
	}

}
