package com.lms.stepdef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lms.model.LoginPage;
import com.lms.model.ProgramEditor;
import com.lms.model.ProgramPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPageStepDef {
	
	private LoginPage loginpage = new LoginPage();
	private ProgramPage programPage = new ProgramPage();
	private ProgramEditor programEditor = new ProgramEditor();
	private static Logger logger = LogManager.getLogger(ProgramPageStepDef.class);
	

	@Given("User is logged on to LMS website")
	public void user_is_logged_on_to_lms_website() {
		loginpage.OpenURL();
		loginpage.Login();
		
	}

	@When("User is on Program page")
	public void user_is_on_program_page() {
		if(!programPage.isOpen()) {
			loginpage.OpenURL();
			loginpage.Login();
		} else {
			programPage.loadProgramPage();
		}
	}

	@Then("User should see a heading with text {string} on the page")
	public void user_should_see_a_heading_with_text_on_the_page(String headerTxt) {
		String tableHeader = programPage.getTableHeader();
		logger.info("Program page table header is {}",tableHeader);
		assertEquals(tableHeader, headerTxt);
	}
	
	@Then("User should see the text as {string} below the table.")
	public void user_should_see_the_text_as_below_the_table(String paginationRegex) {
		String paginationText = programPage.getTableFooterPaginationText();
		logger.info("Program Page pagination text is {}",paginationText);
		assertTrue(paginationText.matches(paginationRegex), paginationText);
	}

	@Then("User should see the footer as {string}")
	public void user_should_see_the_footer_as(String footerRegex) {
		String footerText = programPage.getTableFooterText();
		logger.info("Program Page footer text is {}",footerText);
		assertTrue(footerText.matches(footerRegex), footerText);	
	}
	
	@Then("User should see the Delete button on the top left hand side as Disabled")
	public void user_should_see_the_delete_button_on_the_top_left_hand_side_as_disabled() {
		boolean deleteButtonEnabled = programPage.isDeleteButtonEnabled();
		assertFalse(deleteButtonEnabled);
	}
	
	@Then("Verify the number of records displayed on the page are {int}")
	public void verify_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer size) {
		int numberofRecords = programPage.getNumberofRecordsOnTable();
		logger.info("Number of Records on table is {}",numberofRecords);
		assertEquals(numberofRecords, size);

	}
	
	@Then("Text box used for search has text as {string}")
	public void text_box_used_for_search_has_text_as(String searchBoxTxt) {
		String searchKeyword = programPage.verifySearchBox();
		assertEquals(searchKeyword, searchBoxTxt); 
		
	}
	
	@When("User enters program name {string} into search box.")
	public void user_enters_program_name_into_search_box(String programname) {
	     programPage.search(programname);
	}

	@Then("Entries for name {string} are shown.")
	public void entries_for_name_are_shown(String programname) {
		  boolean searchNameKeywordExists = programPage.allTableRowsContain(programname);
		  assertTrue(searchNameKeywordExists, "Search Keyword programName found in some of the table rows");
		  programPage.goToFirstPage();
	}

	@When("User enters program description {string} into search box.")
	public void user_enters_program_description_into_search_box(String description) {
	     programPage.search(description);
	}

	@Then("Entries for description {string} are shown.")
	public void entries_for_description_are_shown(String description) {
		 boolean searchDescriptionKeywordExists = programPage.allTableRowsContain(description);
		 assertTrue(searchDescriptionKeywordExists, "Search Keyword progDescription found in some of the table rows");
		  programPage.goToFirstPage();
	}

	@When("User enters program status {string} into search box.")
	public void user_enters_program_status_into_search_box(String status) {
		programPage.search(status);

	}

	@Then("Entries for status {string} are shown.")
	public void entries_for_status_are_shown(String status) {
	   boolean searchStatusKeywordExists = programPage.allTableRowsContain(status);
	   assertTrue(searchStatusKeywordExists, "Search Keyword progStatus found in some of the table rows");
	   programPage.goToFirstPage();
	   programPage.search("");
	}
	
	@Given("User is on Program page table")
	public void user_is_on_program_page_table() {
		logger.info("User is on Manage program table");

	}

	@When("User clicks on Edit button")
	public void user_clicks_on_edit_button() {
		programEditor.clickEditBtn();

	}

	@Then("User lands on Program Details form.")
	public void user_lands_on_program_details_form() {
		String dialogHeader = programEditor.getProgramDetailsDialogHeader();
		assertEquals(dialogHeader, "Program Details");
		
	}

	@Given("User is on Program Details form")
	public void user_is_on_program_details_form() {
		//programEditor.clickEditBtn();
		logger.info("Program Details dialog box opened after clicking Edit");
	}

	@When("User edits Name and selects the Save button")
	public void user_edits_name_and_selects_the_save_button(DataTable dataTable1) {
		String progName = dataTable1.cell(0, 0);
	    programEditor.setfield("programName", progName);
	    programEditor.clickSave("Save");
	}

	@Then("User can see updated Name")
	public void user_can_see_updated_name() {
		String updatedProgName = programEditor.checkUpdatedProgramName();
		assertEquals(updatedProgName, "TestProgram");
	}

	@When("User edits Description and selects the Save button")
	public void user_edits_description_and_selects_the_save_button(DataTable dataTable2) {
	   programEditor.clickEditBtn();
	   String progDescription = dataTable2.cell(0, 0);
	   programEditor.setfield("programDescription", progDescription);
	   programEditor.clickSave("Save");
	}

	@Then("User can see updated Description")
	public void user_can_see_updated_description() {
		String updatedProgDesc = programEditor.checkUpdatedProgramDesc();
		assertEquals(updatedProgDesc, "Testdata");

	}

	@When("User changes status and selects the Save button")
	public void user_changes_status_and_selects_the_save_button() {
		programEditor.clickEditBtn();
		programEditor.selectStatus("Active");
		programEditor.clickSave("Save");
	}

	@Then("User can see updated Status")
	public void user_can_see_updated_status() {
		String updatedStatus= programEditor.checkUpdatedStatus();
		assertEquals(updatedStatus, "Active");
	}

	@When("User clicks {string} x button")
	public void user_clicks_x_button(String btnName) {
		programEditor.clickEditBtn();
		programEditor.clickCancel(btnName);
	}

	@Then("User can see Program Details form disappears")
	public void user_can_see_program_details_form_disappears() {
		assertFalse(programEditor.isDialogOpen());
	}

	
	@When("User clicks {string} button")
	public void user_clicks_button(String btnName) {
		programEditor.clickEditBtn();
		programEditor.clickSave(btnName);
	}

	@Then("User can see {string} message")
	public void user_can_see_message(String updateAlertMsg) {
		assertEquals(programEditor.getSuccessAlertMsg().replaceAll("\\n", " "), updateAlertMsg);
	}

	@When("User clicks on Delete button on the table")
	public void user_clicks_on_button_on_the_table() {
		programPage.clickDeleteBtn();
		logger.info("Confirm Dialog for Delete program opens");
	}

	@Then("User lands on Confirm Deletion form.")
	public void user_lands_on_confirm_deletion_form() {
		assertEquals(programPage.getConfirmDialog(), "Confirm");
	}

	@Given("User is on Confirm Deletion form")
	public void user_is_on_confirm_deletion_form() {
		logger.info("Confirm Dialog for Delete program opened ");

	}

	@When("User clicks {string} button on the dialog")
	public void user_clicks_button_on_the_dialog(String yesBtn) {
		programPage.clickYesBtn(yesBtn);
		
	}

	@Then("User can see {string} message for deletion")
	public void user_can_see_message_for_deletion(String deleteAlertMsg) {
		assertEquals(programPage.getSuccessDeletionAlert().replaceAll("\\n", " "), deleteAlertMsg);
		
	}

	@When("User clicks {string} no button")
	public void user_clicks_no_button(String noBtn) {
		programPage.clickDeleteBtn();
		programPage.clickNoBtn(noBtn);
	}

	@Then("User can see Confirm Deletion form disappears")
	public void user_can_see_confirm_deletion_form_disappears() {
		assertFalse(programPage.isConfirmDialogOpen());
	}

	@When("User selects more than one Program using checkbox")
	public void user_selects_more_than_one_program_using_checkbox() {
		programPage.selectCheckboxes();
		logger.info("Selected more than one program");
	}

	@Then("Programs get selected")
	public void programs_get_selected() {
		assertTrue(programPage.isProgramSelected(), "Programs not selected");
	}

	@When("User clicks on Delete button on top left corner")
	public void user_clicks_on_delete_button_on_top_left_corner() {
		programPage.clickCommonDeleteOption();
	}

	@Then("User lands on Confirm Deletion dialog.")
	public void user_lands_on_confirm_deletion_dialog() {
		assertEquals(programPage.getConfirmDialog(), "Confirm");
	}

	@When("User clicks {string} yes button")
	public void user_clicks_yes_button(String yesBtn) {
		programPage.clickYesBtn(yesBtn);
	}

	@Then("User can see {string} message for more deletion")
	public void user_can_see_message_for_more_deletion(String deleteAlertMsg) {
		assertEquals(programPage.getSuccessDeletionAlert().replaceAll("\\n", " "), deleteAlertMsg);

	}

	@When("User clicks {string} no button on the dialog")
	public void user_clicks_no_button_on_the_dialog(String noBtn) {
		programPage.selectCheckboxes();
		programPage.clickCommonDeleteOption();
		programPage.clickNoBtn(noBtn);

	}

	@Then("User can see Confirm Deletion dialog disappears")
	public void user_can_see_confirm_deletion_dialog_disappears() {
		assertFalse(programPage.isConfirmDialogOpen());
	}
	
	@When("User is on first page of Manage Program")
	public void user_is_on_first_page_of_manage_program() {
		programPage.loadProgramPage();
		programPage.goToFirstPage();
	}

	@Then("Verify that previous link is disabled")
	public void verify_that_previous_link_is_disabled() {
		assertFalse(programPage.isPrevLinkEnabled());
	}

	@Given("User is on the page number {string}")
	public void user_is_on_the_page_number(String pageNo) {
		programPage.goToPage(pageNo);

	}

	@When("User clicks navigate > button")
	public void user_clicks_navigate_next_button() {
		programPage.goToNextPage();
	}

	@Then("User navigated to page number {string}")
	public void user_navigated_to_page_number(String pageNo) {
		assertTrue(programPage.isInPage(pageNo));
	}

	@When("User clicks navigate < button")
	public void user_clicks_navigate_previous_button() {
		programPage.goToPreviousPage();
	}

	@When("User is on last page of Manage Program")
	public void user_is_on_last_page_of_manage_program() {
		programPage.goToLastPage();
	}

	@Then("Verify that next link is disabled")
	public void verify_that_next_link_is_disabled() {
		assertFalse(programPage.isNextLinkEnabled());
	}
		
}
