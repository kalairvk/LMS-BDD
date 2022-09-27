package com.lms.stepdef.homereg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lms.model.home.Home;
import com.lms.model.home.Registration;
import com.lms.utils.DriverProvider;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepdefinition {
	private WebDriver driver = DriverProvider.getdriver();
	private com.lms.model.program.LoginPage loginpage = new com.lms.model.program.LoginPage();
	private Home hp = new Home();
	private Registration rfp = new Registration();
	
	

	@Given("User is on LMS website")
	public void user_is_on_lms_website() {

		loginpage.OpenURL();
		loginpage.Login();
	}

	@When("User lands on Registration page")
	public void user_lands_on_registration_page() {

		boolean Login_button = driver.findElement(By.id("login")).isDisplayed();
		Assert.assertTrue(Login_button);// validating with presence of login button

		// String title=driver.getTitle();//with title of the page
		// Assert.assertEquals(title,"login");

	}

	@Then("User sees the Registration Form heading on the form as {string}")
	public void user_sees_the_registration_form_heading_on_the_form_as(String heading) {

		Assert.assertEquals(rfp.verifyHeading(), heading);
	}

	@Then("User sees a button with text Login on the form")
	public void user_sees_a_button_with_text_login_on_the_form() {
		rfp.verifySignUpbutton();
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		rfp.Login_button_click();

	}

	@Then("User lands on Log in page")
	public void user_lands_on_log_in_page() {
		boolean Login_button = driver.findElement(By.id("login")).isDisplayed();
		Assert.assertTrue(Login_button);// validating with presence of login button

		// String title=driver.getTitle();//with title of the page
		// Assert.assertEquals(title,"login");
		driver.navigate().back();
	}

	@Then("User sees a button with text Sign Up on the form")
	public void user_sees_a_button_with_text_sign_up_on_the_form() {
		rfp.verifySignUpbutton();
	}

	@When("User clicks on Sign Up button after entering {string} {string} {string} {string} {string} {string} {string} {string}  {string} {string} {string} {string}")
	public void user_clicks_on_sign_up_button_after_entering(String FirstName, String LastName, String HouseNumber,
			String streetName, String city, String state, String zip, String birthDate, String phno, String username,
			String password, String email) {
		rfp.setFirstName(FirstName);
		rfp.setLastName(LastName);
		rfp.setHouseNumber(HouseNumber);
		rfp.setStreetName(streetName);
		rfp.setCity(city);
		rfp.setState(state);
		rfp.setZip(zip);
		rfp.setBirthDate(birthDate);
		rfp.setPhoneNumber(phno);
		rfp.setUserName(username);
		rfp.setPassword(password);
		rfp.setEmail(email);
		rfp.SignUpButton();

	}

	@Then("User Registraion should get error message as {string}")
	public void user_registraion_should_get_error_message_as(String err_msg) {
		String actual_err_msg = driver.findElement(By.xpath("")).getText();
		Assert.assertEquals(actual_err_msg, err_msg);
		System.out.println("Error Message:" + actual_err_msg);
	}

}
