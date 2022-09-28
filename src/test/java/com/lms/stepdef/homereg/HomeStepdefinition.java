package com.lms.stepdef.homereg;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lms.model.home.Home;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepdefinition {
		public WebDriver driver;
		private com.lms.model.program.LoginPage loginpage = new com.lms.model.program.LoginPage();
		public Home hp = new Home();
		
		
		@Given("User opens LMS website")
		public void user_opens_lms_website() throws InterruptedException
		{
			loginpage.OpenURL();
			loginpage.Login();
		}
		@When("User is on Home page")
		public void user_is_on_home_page() throws InterruptedException {
			
			 Assert.assertTrue(hp.Verify_LMS_Heading());
		}
		@Then("User verifies that title of the page is {string}")
		public void user_verifies_that_title_of_the_page_is(String Pagetitle) throws InterruptedException {
		 
			Thread.sleep(1000);
			String title=hp.verifyHomePageTitle();
			Assert.assertTrue(title.contains("LMS"));
			System.out.println("Title of the Home Page is:"+title);
		}
		
			
		@Then("User should see LMS-Learing Management System heading")
		public void user_should_see_lms_learing_management_system_heading()
		{
		   hp.Verify_LMS_Heading();
		}
		
		@Then("User should see Program button on menu bar")
		public void user_should_see_program_button_on_menu_bar()
		{
			Assert.assertTrue(hp.VerifyProgram());
		}
		
		@Then("User should see Batch button on the menu bar")
		public void user_should_see_batch_button_on_the_menu_bar()
		{
			Assert.assertTrue(hp.VerifyBatch());
		}
		@Then("User should see User button on the menu bar")
		public void user_should_see_user_button_on_the_menu_bar()
		{
			Assert.assertTrue(hp.VerifyUser());
		}
		@Then("User should see Assignment button on the menu bar")
		public void user_should_see_assignment_button_on_the_menu_bar()
		{
			Assert.assertTrue(hp.VerifyAssignment());
		}
		@Then("User should see Attendance button on the menu bar")
		public void user_should_see_attendance_button_on_the_menu_bar()
		{
			Assert.assertTrue(hp.VerifyAttendance());
		}
		@Then("User should see Logout button on the menu bar")
		public void user_should_see_logout_button_on_the_menu_bar()
		{
			Assert.assertTrue(hp.VerifyLogout());
		}		

}
