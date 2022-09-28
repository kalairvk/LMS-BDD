package com.lms.stepdef.manageuser;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lms.model.program.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefinition {

	private LoginPage loginpage = new LoginPage();
	private static Logger logger = LogManager.getLogger(LoginStepdefinition.class);

	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
		loginpage.OpenURL();
		logger.info("Website launched for login");
	}

	@When("User clicks on Login button with entering invalid {string} and {string}")
	public void user_clicks_on_login_button_with_entering_invalid_and(String username, String password) {
		loginpage.setfields("username", username);
		loginpage.setfields("password", password);
		loginpage.clickloginbtn();
	}

	@Then("User should receive the message {string}")
	public void user_should_receive_the_message(String errorMsg) {
		assertEquals(loginpage.getErrorMsgForInvalidCredentials(), errorMsg);
	}

	@When("User clicks on Login button with entering valid {string} and {string}")
	public void user_clicks_on_login_button_with_entering_valid_and(String username, String password) {
	      loginpage.setfields("username", username);
	      loginpage.setfields("password", password);
	      loginpage.clickloginbtn();
	}

	@Then("User should see the LMS Home page.")
	public void user_should_see_the_lms_home_page() {
		assertEquals(loginpage.getHomepageHeader(), "LMS - Learning Management System");
	}



}
