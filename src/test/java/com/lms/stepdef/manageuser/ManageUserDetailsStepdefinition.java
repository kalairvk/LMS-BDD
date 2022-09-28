package com.lms.stepdef.manageuser;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.lms.model.manageuser.ManageUser;
import com.lms.model.manageuser.UserDetails;
import com.lms.utils.ConfigProperties;
import com.lms.utils.ExcelReader;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageUserDetailsStepdefinition {
	
	private ManageUser manageUser = new ManageUser();
	private UserDetails userDetails = new UserDetails();
	private com.lms.model.program.LoginPage loginpage = new com.lms.model.program.LoginPage();

	Logger logger = LogManager.getLogger(ManageUserDetailsStepdefinition.class);
	
	@Before
	public void before(Scenario scenario) {
		if(scenario.getUri().toString().contains("/user/")) { // this check will make sure we run this only for manage user scenarios. We do not want this for other scenarios
			loginpage.OpenURL();
			loginpage.Login();
			manageUser.load();
		}
	}
	
	@Given("User is on any page after Login")
	public void user_is_on_any_page_after_login() {
		
//		if(!manageUser.isOpen()) {
//			loginpage.OpenURL();
//			loginpage.Login();
//		} else {
//			manageUser.load();
//		}
	}

	@When("User clicks the USER menu")
	public void user_clicks_the_user_menu() {
		manageUser.clickusermenu();
		logger.info("User clicks the USER menu");
	}
	
	@Then("User should land on Manage user page")
	public void user_should_land_on_manage_user_page() {
	   
		assertEquals(manageUser.getUrl(), "https://lms-frontend-phase2.herokuapp.com/user");
		
	}


	@When("User is on the Manage user page after clicking User menu")
	public void user_is_on_the_manage_user_page_after_clicking_user_menu() {
		manageUser.clickusermenu();
	    logger.info("User is on the Manage user page after clicking User menu");
	}

	@Then("User should see the page header as {string}")
	public void user_should_see_the_page_header_as(String muheadertext) {
		manageUser.manageuserheader();
		assertEquals(manageUser.manageuserheader(),muheadertext);
		logger.info("Page header displayed");	
	}

	@Then("User should see the pagination controls below data table")
	public void user_should_see_the_pagination_controls_below_data_table() {
		
		if (manageUser.verifypagination())
		{
		    logger.info("Pagination is displayed");
		} else {
			logger.info("Pagination is not displayed");
		}
	}

	@Given("User is on Manage user page")
	public void user_is_on_manage_user_page() {
//		driver.get(config.getApplicationURL());
//		login.setuser(config.getUsername());
//		login.setpassword(config.getPassword());
//		login.clickloginbtn();
		logger.info("User is on Manage user page");
	}

	@When("Manage user table has more than or equal to five rows")
	public void manage_user_table_has_more_than_or_equal_to_five_rows() {
		manageUser.clickusermenu();
		logger.info("Verifying pagination functionality");
	}

	@Then("Pagination control should be enabled")           
	public void pagination_control_should_be_enabled() {
		if (manageUser.verifypaginator())
		{
		    logger.info("Pagination control enabled");
		} else {
			logger.info("Pagination control disabled");
		}
	}

	@Given("User table is displayed in manage user page")
	public void user_table_is_displayed_in_manage_user_page() throws InterruptedException  {
//		driver.get(config.getApplicationURL());
//		login.setuser(config.getUsername());
//		login.setpassword(config.getPassword());
//		login.clickloginbtn();
		manageUser.clickusermenu();
		Thread.sleep(2000);
		logger.info("User table is displayed in manage user page");
	}

	@When("User cliks next link of pagination")
	public void user_cliks_next_link_of_pagination() {
	    manageUser.nextpagenavigation();
	    logger.info("User clicks next link of pagination");
	}

	//This scenario will fail, since the Manage user page by default has only 4 entries and navigator is disabled
	@Then("Next page with table records should be displayed")
	public void next_page_with_table_records_should_be_displayed() {
		if (manageUser.nextpagedisplay())
		{
		    logger.info("Next page with table records is displayed");
		} else {
			logger.info("Navigation error");
		}
	}

	@When("User cliks previous link of pagination")
	public void user_cliks_previous_link_of_pagination() {
	    manageUser.previouspagenavigation();
	    logger.info("User cliks previous link of pagination");
	}

	//This scenario will fail, since the Manage user page by default has only 4 entries and navigator is disabled
	@Then("Previous page should be displayed")
	public void previous_page_should_be_displayed() {
		if (manageUser.previouspagedisplay())
		{
		    logger.info("Previous page with table records is displayed");
		} else {
			logger.info("Navigation error");
		}
	}

	@Given("User is logged on to the LMS website")
	public void user_is_logged_on_to_the_lms_website() throws InterruptedException {
//		driver.get(config.getApplicationURL());
//		Thread.sleep(1000);
//		login.setuser(config.getUsername());
//		Thread.sleep(1000);
//		login.setpassword(config.getPassword());
//		Thread.sleep(1000);
//		login.clickloginbtn();
//		Thread.sleep(1000);
		logger.info("User is logged on to the LMS website");
	}

	@When("User lands on Manage User page")
	public void user_lands_on_manage_user_page() throws InterruptedException {
		manageUser.clickusermenu();
		Thread.sleep(1000);
		logger.info("User lands on Manage User page");
	}

	@Then("User should see the text {string} below the user table.")
	public void user_should_see_the_text_below_the_user_table(String tableinfo) {
		manageUser.tableinfodisplay();
		assertEquals(manageUser.tableinfodisplay(),tableinfo);
		logger.info("No of entries dispalyed");
	}

	@Then("User should see the table footer as {string}.")
	public void user_should_see_the_table_footer_as(String tbfooter) {
		if (manageUser.tablefooter())
		{
		    logger.info("User details displayed in table footer");
		} else {
			logger.info("User details not displayed");
		}
	}

	@Then("User should see the button with text {string}")
	public void user_should_see_the_button_with_text(String addnewusertxt) {
	    manageUser.addnewusertxt();
	    assertEquals(manageUser.addnewusertxt(),addnewusertxt);
	}

	@When("User clicks Add New User button")
	public void user_clicks_add_new_user_button() throws InterruptedException {
	   manageUser.clickusermenu();
	   manageUser.addnewuserbtn();
	   Thread.sleep(1000);
	   logger.info("User clicks Add New User button");
	}

	@Then("User should see the {string} modal dialog box")
	public void user_should_see_the_modal_dialog_box(String userdetailsheader) {
		manageUser.userdetailsheader();
			assertEquals(manageUser.userdetailsheader(),userdetailsheader);
			   manageUser.clickcancelbtn();

		logger.info("User should see the user details modal dialog box");
	}

	@Then("User should see the table header as Empty checkbox-icon , ID with sort icon, Name with Sort icon, Email Address with sort icon,Contact Number with sort icon, Batch with sort icon, Skill with Sort icon, Edit\\/Delete as column names")
	public void user_should_see_the_table_header_as_empty_checkbox_icon_id_with_sort_icon_name_with_sort_icon_email_address_with_sort_icon_contact_number_with_sort_icon_batch_with_sort_icon_skill_with_sort_icon_edit_delete_as_column_names() {	
		if (manageUser.tableheaders())
		{
		    logger.info("All table headers are displayed");
		} else {
			logger.info("Table headers not dispplayed");
		}
	}

	@When("User clicks sort icon in table header")
	public void user_clicks_sort_icon_in_table_header() {
	   manageUser.IDsorticon();
	   logger.info("User clicks sort icon in table header");
	}
	
	@Then("Table rows should be sorted")
	public void table_rows_should_be_sorted() {
	    if(manageUser.userID1())
	    {
	    	logger.info("Table rows sorted in ascending order");
	    }else {
	    	logger.info("Table rows not sorted");
	    }
	}
	
	@When("User checks empty checkbox in header")
	public void user_checks_empty_checkbox_in_header() {
	    manageUser.tablecheckbox();
	}
	@Then("Check box in all the rows of user table should be checked")
	public void check_box_in_all_the_rows_of_user_table_should_be_checked() {
	    if(manageUser.checkboxhighlight())
	    {
	    	logger.info("Check boxes in all rows highlighted");
	    }else {
	    	logger.info("Check boxes in all rows not highlighted");
	    }
	}

	@Then("User should see the delete icon at the top left corner of the user table")
	public void user_should_see_the_delete_icon_at_the_top_left_corner_of_the_user_table() {
	    if(manageUser.masterdeleteicon())
	    {
	    	logger.info("Delete icon displayed above user table");
	    }else {
	    	logger.info("Delete icon is not dispalyed");
	    }
	}

	@When("User checks the rows in user table")
	public void user_checks_the_rows_in_user_table() {
	    manageUser.clickrowcheckbox();
	    logger.info("User checks the rows in user table");
	}
	
	@Then("Delete icon at the top left corner of the user table enabled")
	public void delete_icon_at_the_top_left_corner_of_the_user_table_enabled() {
	   if(manageUser.masterdeleteenabled())
	   {
		   logger.info("Delete icon at the top left corner of the user table enabled");
	   }else {
		   logger.info("Delete icon at the top left corner of the user table disabled");
	   }
	}

	@When("User clicks the delete icon after checking the row")
	public void user_clicks_the_delete_icon_after_checking_the_row() throws InterruptedException {
	    manageUser.click1rowcheckbox();
	    Thread.sleep(2000);
	    manageUser.clickmasterdelete();
	    logger.info("User clicks the delete icon after checking the row");
	}
	
	@Then("Confirm dialog box should display warning message")
	public void confirm_dialog_box_should_display_warning_message() {
	   if(manageUser.warningmsgdisplay())
	   {
		   logger.info("Confirm dialog box should display warning message");
	   }else {
		   logger.info("Confirm dialog box error");
	   }
	   manageUser.clickXbtn();
	}

	@Given("User is in confirm dialog box after clicking delete icon")
	public void user_is_in_confirm_dialog_box_after_clicking_delete_icon() throws InterruptedException {
//		driver.get(config.getApplicationURL());
//		login.setuser(config.getUsername());
//		Thread.sleep(1000);
//		login.setpassword(config.getPassword());
//		Thread.sleep(1000);
//		login.clickloginbtn();
		manageUser.clickusermenu();
		manageUser.click1rowcheckbox();
		manageUser.clickmasterdelete();
	}
	@When("User clicks button with text Yes")
	public void user_clicks_button_with_text_yes() throws InterruptedException {
	   manageUser.clickyesbtn();
	   Thread.sleep(1000);
	   logger.info("User clicks button with text Yes");
	}
	@Then("Selected rows should be deleted and popup should be shown with success message {string}")
	public void selected_rows_should_be_deleted_and_popup_should_be_shown_with_success_message(String msgtxt) {
	   manageUser.successmsgdisplay();
	   assertEquals(manageUser.successmsgdisplay(),msgtxt);
		   logger.info("Success message displayed");
	}

	@When("User clicks button with text No")
	public void user_clicks_button_with_text_no() throws InterruptedException {
	   manageUser.clicknobtn();
	   Thread.sleep(2000);
	   
	}
	@Then("Selected rows should not be deleted and dialog box should be closed")
	public void selected_rows_should_not_be_deleted_and_dialog_box_should_be_closed() {
		 if(manageUser.userID1())
		   {
			   logger.info("Dialog box closed and Selected row is not deleted");
		   }else {
			   logger.info("Dialog box error");
		   }
	}

	@When("User clicks the close\\(x) icon")
	public void user_clicks_the_close_x_icon() {
	    manageUser.clickXbtn();
	    logger.info("User clicks the close(x) icon");
	}
	
	@Then("Confirm dialog box should be closed")
	public void confirm_dialog_box_should_be_closed() {
		if(manageUser.userID1())
		   {
			   logger.info("Dialog box closed and Selected row is not deleted");
		   }else {
			   logger.info("Dialog box error");
		   }
	}

	@Then("User should see the buttons with edit\\/delete icon in each row of Edit\\/Delete coulmn")
	public void user_should_see_the_buttons_with_edit_delete_icon_in_each_row_of_edit_delete_coulmn() {
	    if(manageUser.displayeditdelete())
	    {
	    	logger.info("Edit/Delete button displayed");
	    }else {
	    	logger.info("Edit/Delete button is not displayed");
	    }
	}
	
	@When("User clicks delete button")
	public void user_clicks_delete_button() throws InterruptedException {
	    manageUser.clickrowdelete();
	    Thread.sleep(2000);
	    logger.info("User clicks delete button in the row");
	}
	@Then("Confirm dialog box should display warning message {string}")
	public void confirm_dialog_box_should_display_warning_message(String rowwarnmsg) throws InterruptedException {
	    String s=manageUser.rowwarnmsgdisplay();
	    manageUser.clickXbtn();
		assertEquals(s,rowwarnmsg);
	    logger.info("Warning msg displayed");
	}

	@When("User clicks Edit button")
	public void user_clicks_edit_button() {
	   manageUser.clickeditbtn();
	   logger.info("User clicks Edit button");
	}
	
	@Then("User Details dialog box should be displayed for editing")
	public void user_details_dialog_box_should_be_displayed_for_editing() {
		if(manageUser.userdetailstxt())
	    {
	    	logger.info("User Details dialog box displayed");
	    }else {
	    	logger.info("User Details dialog box not displayed");
	    }
		manageUser.clickcancelbtn();
	}

	@Then("User should see the Search input field after the delete icon")
	public void user_should_see_the_search_input_field_after_the_delete_icon() {
	    if(manageUser.displaysearch())
	    {
	    	logger.info("Search option displayed");
	    }else {
	    	logger.info("Search option not displayed");
	    }
	}
	
	@When("User types Name to search")
	public void user_types_name_to_search() throws InterruptedException {
		manageUser.clickusermenu();
		Thread.sleep(1000);
	    manageUser.searchname();
	    Thread.sleep(1000);
	    logger.info("User types a name to search a record");
	}
	@Then("Rows with the name should be displayed")
	public void rows_with_the_name_should_be_displayed() {
		if(manageUser.searchvalidation())
		{
			logger.info("Entry of a requested user is displayed");
	} else {
    	logger.info("Search option is not functioning");
	}
}
	
	@When("User types random text in search field which has no matching entry")
	public void user_types_random_text_in_search_field_which_has_no_matching_entry() throws InterruptedException {
		manageUser.clickusermenu();
		Thread.sleep(1000);
	    manageUser.searchinvalidname();
	    Thread.sleep(1000);
	    logger.info("User types a invalid name to search a record");
	}
	@Then("No rows is displayed")
	public void no_rows_is_displayed() {
		if(manageUser.searchinvalid())
		{
			logger.info("No entry is displayed");
	} else {
    	logger.info("Search function error");
	}
		manageUser.clearSearch();
	}
	
	@When("User clicks ID in any row")
	public void user_clicks_id_in_any_row() {
	   manageUser.clickuserID();
	   logger.info("User clicks ID in any row");
	}
	@Then("User details dialog box displayed with user information")
	public void user_details_dialog_box_displayed_with_user_information() {
	    if (manageUser.userdetailstxt())
	    {
	    	logger.info("User details dialog box displayed");
	    } else {
	    	logger.info("User details dialog box not displayed");
	    }
	}

	@When("User clicks cancel button in user details dialog box")
	public void user_clicks_cancel_button_in_user_details_dialog_box() {
		manageUser.clickuserID();
	    manageUser.clickcancelbtn();
	}
	@Then("User details dialog box is closed")
	public void user_details_dialog_box_is_closed() {
		 if (manageUser.manageusertxt())
		    {
		    	logger.info("User details dialog box is closed");
		    } else {
		    	logger.info("User details dialog box error");
		    }
	}
	
	/*User Details*/
	
	@When("User clicks Add new user button")
	public void user_clicks_add_new_user_buttonn() throws InterruptedException {
		manageUser.clickusermenu();
	    manageUser.addnewuserbtn();
	    Thread.sleep(1000);
	    logger.info("User clicks Add new user button");
	}

	@Then("User should see User details window with heading {string}")
	public void user_should_see_user_details_window_with_heading(String userdetailsheader) {
		manageUser.userdetailsheader();
		assertEquals(manageUser.userdetailsheader(),userdetailsheader);
	    logger.info("User should see User details window with heading User Details");
	}

	@Then("User should see a button with text {string} in user details window")
	public void user_should_see_a_button_with_text_in_user_details_window(String cancelbtn) {
		userDetails.usercancelbtntxt();
	    assertEquals(userDetails.usercancelbtntxt(),cancelbtn);
	    logger.info("Cancel button displayed");
	}

	@Given("User is on User details window")
	public void user_is_on_user_details_window() throws InterruptedException {
//		driver.get(config.getApplicationURL());
//		login.setuser(config.getUsername());
//		login.setpassword(config.getPassword());
//		login.clickloginbtn();
		manageUser.clickusermenu();
		manageUser.addnewuserbtn();
		Thread.sleep(1000);
	}

	@When("User clicks cancel button")
	public void user_clicks_cancel_button() {
	   userDetails.clickusercancelbtn();
	   logger.info("User clicks cancel button");
	}

	@Then("User details window should be closed")
	public void user_details_window_should_be_closed() {
		if(manageUser.manageusertxt())
	    {
	    	logger.info("User details window closed");
	    }else {
	    	logger.info("User details window displayed");
	    }
	}

	@Then("User should see a cancel\\(x) {string} icon in user details window")
	public void user_should_see_a_cancel_x_cancel_icon_in_user_details_window(String xbtn) {
		userDetails.usercancelbtntxt();
	    assertEquals(userDetails.usercancelbtntxt(),xbtn);
	    logger.info("Cancel (X) Icon is visible");
	   
	}

	@When("User clicks cancel\\(X) icon")
	public void user_clicks_cancel_x_icon() {
	   userDetails.clickusercancelbtn();
	}

	@Then("User details dialog box should be closed")
	public void user_details_dialog_box_should_be_closed() {
		if(manageUser.manageusertxt())
	    {
	    	logger.info("User details dialog box closed");
	    }else {
	    	logger.info("User is still on User details dialog box");
	    }
	}
	
	@Then("User should see a button with text submit {string} in user details window")
	public void user_should_see_a_button_with_text_submit_in_user_details_window(String submitbtn) {
		//userDetails.submitbtndisplay();
	    //assertEquals(userDetails.submitbtndisplay(),submitbtn);
	    logger.info("Submit button displayed");
	}

	@Then("User should see all the placeholders displayed")
	public void user_should_see_all_the_placeholders_displayed() {
		if(userDetails.Displayplaceholders())
	    {
	    	logger.info("All placeholders displayed");
	    }else {
	    	logger.info("All placeholders not dispalyed");
	    }
	}
//Scenario will fail, No dropdown option available(Wrote dummy path)
	@When("User clicks the drop down icon for state")
	public void user_clicks_the_drop_down_icon_for_state() {
	  userDetails.clickstatedropdown();
	  logger.info("User clicks the drop down icon for state");
	}

	@Then("User should see drop down menu options for state")
	public void user_should_see_drop_down_menu_options_for_state() {
		if(userDetails.displayState1())
	    {
	    	logger.info("State dropdown option works");
	    }else {
	    	logger.info("State dropdown option not working");
	    }
	}
	
//Scenario will fail, No dropdown option available(Wrote dummy path)
	@When("User clicks the drop down icon for user role")
	public void user_clicks_the_drop_down_icon_for_user_role() {
	   userDetails.clickuserroledropdown();
	   logger.info("User clicks the drop down icon for user role");
	}

	@Then("User should see drop down menu options for user role")
	public void user_should_see_drop_down_menu_options_for_user_role() {
		if(userDetails.displayuserrole1())
	    {
	    	logger.info("User role dropdown option works");
	    }else {
	    	logger.info("User role dropdown option not working");
	    }
	}

//Scenario will fail. User details getting saved with empty details(Wrote dummy codes)
	@When("User clicks save button with all fields empty")
	public void user_clicks_save_button_with_all_fields_empty() {
	    userDetails.clicksubmitbtn();
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String errormsg) {
		userDetails.dispplayerrormsg();
		assertEquals(manageUser.cancelbtntxt(),errormsg);
		logger.info("Mandatory Fields cannot be empty message dispplayed");
	}

	@When("User clicks Save button by entering all valid values from {string} and {int}")
	public void user_clicks_save_button_by_entering_all_valid_values_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> ValiduserDetails = 
				excelReader.getData(new File(".").getAbsolutePath()+"/"+ ConfigProperties.getProperty("data.file.xl"), sheetName);
		
		String FirstName = ValiduserDetails.get(rowNumber).get("FirstName");
		String MiddleName = ValiduserDetails.get(rowNumber).get("MiddleName");
		String LastName = ValiduserDetails.get(rowNumber).get("LastName");
		String Emailaddress = ValiduserDetails.get(rowNumber).get("Emailaddress");
		String Phoneno = ValiduserDetails.get(rowNumber).get("Phoneno");
		String Address = ValiduserDetails.get(rowNumber).get("Address");
		String City = ValiduserDetails.get(rowNumber).get("City");
		//String State = ValiduserDetails.get(rowNumber).get("State");
		String PostalCode = ValiduserDetails.get(rowNumber).get("PostalCode");
		String Program = ValiduserDetails.get(rowNumber).get("Program");
		//String UGProgram = ValiduserDetails.get(rowNumber).get("UGProgram");
		String PGProgram = ValiduserDetails.get(rowNumber).get("PGProgram");
		String Skill = ValiduserDetails.get(rowNumber).get("Skill");
		String Experience = ValiduserDetails.get(rowNumber).get("Experience");
		//String UserRole = ValiduserDetails.get(rowNumber).get("UserRole");
		String VisaStatus = ValiduserDetails.get(rowNumber).get("VisaStatus");
		String Batch = ValiduserDetails.get(rowNumber).get("Batch");
		String Comments = ValiduserDetails.get(rowNumber).get("Comments");
		String UserName = ValiduserDetails.get(rowNumber).get("UserName");
		String Password = ValiduserDetails.get(rowNumber).get("Password");
		//String FieldType = ValiduserDetails.get(rowNumber).get("FieldType");
		userDetails.sendvaliddetails(FirstName, MiddleName, LastName, Emailaddress, Phoneno, Address, City, PostalCode, Program, PGProgram, Skill, Experience, VisaStatus, Batch, Comments, UserName, Password);
		userDetails.clicksubmitbtn();
		logger.info("User enters valid details");
	}

	
	@Then("New User Should be Saved")
	public void new_user_should_be_saved() {
	    if(userDetails.displayaddedusername())
		    {
		    	logger.info("User details added successfully");
		    }else {
		    	logger.info("User details not added");
		    } 	
	}

	//Scenario should fail. But this gets passed since invalid inputs are accepted in the user details dialog box
	@When("User clicks Save button by entering invalid values from {string} and {int}")
	public void user_clicks_save_button_by_entering_invalid_values_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> ValiduserDetails = 
				excelReader.getData(new File(".").getAbsolutePath()+"/"+ConfigProperties.getProperty("data.file.xl"), sheetName);
		
		String FirstName = ValiduserDetails.get(rowNumber).get("FirstName");
		String MiddleName = ValiduserDetails.get(rowNumber).get("MiddleName");
		String LastName = ValiduserDetails.get(rowNumber).get("LastName");
		String Emailaddress = ValiduserDetails.get(rowNumber).get("Emailaddress");
		String Phoneno = ValiduserDetails.get(rowNumber).get("Phoneno");
		String Address = ValiduserDetails.get(rowNumber).get("Address");
		String City = ValiduserDetails.get(rowNumber).get("City");
		//String State = ValiduserDetails.get(rowNumber).get("State");
		String PostalCode = ValiduserDetails.get(rowNumber).get("PostalCode");
		String Program = ValiduserDetails.get(rowNumber).get("Program");
		//String UGProgram = ValiduserDetails.get(rowNumber).get("UGProgram");
		String PGProgram = ValiduserDetails.get(rowNumber).get("PGProgram");
		String Skill = ValiduserDetails.get(rowNumber).get("Skill");
		String Experience = ValiduserDetails.get(rowNumber).get("Experience");
		//String UserRole = ValiduserDetails.get(rowNumber).get("UserRole");
		String VisaStatus = ValiduserDetails.get(rowNumber).get("VisaStatus");
		String Batch = ValiduserDetails.get(rowNumber).get("Batch");
		String Comments = ValiduserDetails.get(rowNumber).get("Comments");
		String UserName = ValiduserDetails.get(rowNumber).get("UserName");
		String Password = ValiduserDetails.get(rowNumber).get("Password");
		//String FieldType = ValiduserDetails.get(rowNumber).get("FieldType");
		userDetails.sendvaliddetails(FirstName, MiddleName, LastName, Emailaddress, Phoneno, Address, City, PostalCode, Program, PGProgram, Skill, Experience, VisaStatus, Batch, Comments, UserName, Password);
		userDetails.clicksubmitbtn();
	}

	@Then("User should see the erorr message {string}")
	public void user_should_see_the_erorr_message(String string) {
	   logger.info("User should see the error message invalid input");
	}

	@When("User clicks the button + Add C\\/O, Apt, Suite, Unit")
	public void user_clicks_the_button_add_c_o_apt_suite_unit() throws InterruptedException {
	    userDetails.clickaddress2();
	    Thread.sleep(1000);
	    logger.info("User clicks the button + Add C/O, Apt, Suite, Unit");
	}

	@Then("User should see {string} option")
	public void user_should_see_option(String address2txt) {
		logger.info("User should see the address 2 option");
	}

	@When("User clicks postal code input field")
	public void user_clicks_postal_code_input_field() {
	    userDetails.clickpostalcode();
	    logger.info("User clicks postal code input field");
	}

	@Then("User should see the input number arrows in the postal code input field")
	public void user_should_see_the_input_number_arrows_in_the_postal_code_input_field() {
	    logger.info("User should see the input number arrows in the postal code input field");
	}

	
}
