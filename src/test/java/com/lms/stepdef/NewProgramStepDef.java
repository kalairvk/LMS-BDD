package com.lms.stepdef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lms.model.LoginPage;
import com.lms.model.ProgramEditor;
import com.lms.model.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewProgramStepDef {
	
	private LoginPage loginpage = new LoginPage();
	private ProgramPage programPage = new ProgramPage();
	private ProgramEditor programEditor = new ProgramEditor();
	private static Logger logger = LogManager.getLogger(ProgramPageStepDef.class);
	

	@Given("User is on Manage Program page")
	public void user_is_on_manage_program_page() {
		if(!programPage.isOpen()) {
			loginpage.OpenURL();
			loginpage.Login();
		} else {
			programPage.loadProgramPage();
		}
		
	}

	@When("User clicks {string} button in program page")
	public void user_clicks_a_program_button(String addBtn) {
		programEditor.addNewProgram(addBtn);
	}

	@Then("User lands on Program Details Page dialog.")
	public void user_lands_on_program_details_page_dialog() {
		assertEquals(programEditor.getProgramDetailsDialogHeader(), "Program Details");
	}
	
	@Given("User is on Program Details Dialog")
	public void user_is_on_program_details() {
		logger.info("Program Details dialog box opened after clicking add new program");
		programEditor.open();
	}

	@When("User clicks {string} button without entering data")
	public void user_clicks_button_without_entering_data(String saveBtn) {
		programEditor.clickSave(saveBtn);
	}

	@Then("User gets message {string}")
	public void user_gets_message(String errorMsg) {
		logger.error(programEditor.getErrorMsgUnderNameField());
		assertEquals(programEditor.getErrorMsgUnderNameField(), errorMsg);
	}

	@When("User enters {string} and {string} in the corresponding text boxes")
	public void user_enters_and_in_the_corresponding_text_boxes(String name, String description) {
		//programEditor.addProgram();
		programEditor.setfield("programName", name);
		programEditor.setfield("programDescription", description);
	}

	@Then("User can see the {string} and {string} entered")
	public void user_can_see_the_and_entered(String name, String description) {
		String progName= programEditor.checkPrognameEntered();
		String progDesc = programEditor.checkProgdescEntered();
		assertEquals(progName, name);
		assertEquals(progDesc, description);
	}

	@When("User selects Status using radiobutton")
	public void user_selects_status_using_radiobutton() {
		programEditor.selectStatus("Inactive");
	}

	@Then("User can see Active or Inactive status selected")
	public void user_can_see_Active_or_Inactive_status_selected() {
         assertEquals(programEditor.checkStatusSelected(), "Inactive");
	}

	@When("User clicks {string} button on new program page")
	public void user_clicks_button_on_new_program_page(String saveBtn) {
		programEditor.clickSave(saveBtn);
	}

	@Then("User gets success message {string}")
	public void user_gets_success_message(String successAlertMsg) {
		assertEquals(programEditor.getSuccessAlertMsg().replaceAll("\\n", " "), successAlertMsg);
	}

	@When("User clicks {string} or close button")
	public void user_clicks_or_close_button(String cancelBtn) {
        programEditor.clickCancel(cancelBtn);
	}

	@Then("User can see new Program Details form disappears")
	public void user_can_see_new_program_details_form_disappears() {
		assertFalse(programEditor.isDialogOpen());
	}



}
