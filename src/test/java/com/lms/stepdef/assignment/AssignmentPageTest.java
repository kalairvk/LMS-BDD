package com.lms.stepdef.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.lms.utils.ConfigProperties;
import com.lms.utils.DriverProvider;
import com.lms.utils.XLUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignmentPageTest {
	

	Logger logger = LogManager.getLogger(AssignmentPageTest.class);

	private com.lms.model.assignment.AssignmentPage assignmentPage = new com.lms.model.assignment.AssignmentPage();
	private XLUtility utility = new XLUtility("DataFiles/AssignmentDetails.xlsx");

	private WebDriver driver = DriverProvider.getdriver();
	

//	
	@Given("user is on Confirm Deletion Form")
	public void user_is_on_confirm_deletion_form() throws InterruptedException {
		assignmentPage.clickAssignmentHeader();
		assignmentPage.clickDeleteBtn();
	}

	@Given("user is on Assignment Details Form")
	public void user_is_on_assignment_details_form() throws InterruptedException {

		assignmentPage.clickAssignmentHeader();
		assignmentPage.clickNewAssnBtn();
	}

	@Given("user is on Manage Assignment page")
	public void user_is_on_manage_assignment_page() throws InterruptedException {

		assignmentPage.clickAssignmentHeader();
	}

	@When("user clicks on Assignment menu option")
	public void user_clicks_on_Assignment_menu_option() {
		assignmentPage.clickAssignmentHeader();
	}

	@When("user is on Assignment page")
	public void user_is_on_assignment_page() {

	}

	@When("user selects assignment using checkbox")
	public void user_selects_assignment_using_checkbox() throws InterruptedException {
		assignmentPage.clickCheckBox();
	}

	@When("user clicks on search with {string} into search box")
	public void user_clicks_on_search_with_into_search_box(String string) {
		assignmentPage.insertTextInSearch(ConfigProperties.getAssignmentSeacrhText());
	}

	
	@When("user clicks on {string} button after selecting an assignment")
	public void user_clicks_on_button_after_selecting_an_assignment(String string) throws InterruptedException {
	assignmentPage.clickDeleteAssignment();
	}
	
	@When("user clicks on {string} button")
	public void user_clicks_on_button(String button) throws InterruptedException {
		if(button.equalsIgnoreCase("Edit")) {
			assignmentPage.clickEditBtn();
		}
		else if(button.equalsIgnoreCase("Save")) {
			assignmentPage.clickSaveBtn();
		}
		else if(button.equalsIgnoreCase("New Assignment")) {
			assignmentPage.clickNewAssnBtn();
		}
		else if(button.equalsIgnoreCase("Yes")) {
			assignmentPage.clickYesBtn();
		}
		else if(button.equalsIgnoreCase("No")) {
			assignmentPage.clickNoBtn();
		}
		else if(button.equalsIgnoreCase("Delete")) {
			assignmentPage.clickDeleteBtn();
		}
		else if(button.equalsIgnoreCase("Cancel")) {
			assignmentPage.clickCancel();
		}
				
	}

	
	@When("user enters Assignment {string}, {string}, {string}, {string} taken from excel and click save")
	public void user_enters_assignment_taken_from_excel_and_click_save(String name, String desc, String grade, String duedate) throws InterruptedException {
		assignmentPage.clickNewAssnBtn();
		name= utility.getCellData("AssignmentDetails",1 , 0);
		assignmentPage.enterAssnName(name);
		desc=utility.getCellData("AssignmentDetails", 1, 1);
		assignmentPage.enterAssnDescription(desc);
		grade=utility.getCellData("AssignmentDetails", 1, 2);
		assignmentPage.enterAssnGrade(grade);
		duedate=utility.getCellData("AssignmentDetails", 1, 3);
		assignmentPage.enterAssnDueDate(duedate);
		assignmentPage.clickSaveBtn();
	}

	@When("user selects an assignment")
	public void user_selects_an_assignment() {

	}

	@When("user selects more than one assignment using checkbox")
	public void user_selects_more_than_one_assignment_using_checkbox() {
		assignmentPage.clickMultipleAssnChkbox();
	}

	@When("user clicks on Delete button on top left corner")
	public void user_clicks_on_delete_button_on_top_left_corner() {

	}
	
	@When("user edits {string}, {string}, {string}, {string} taken from excel")
	public void user_edits_taken_from_excel(String name, String des, String grd, String ddate) throws InterruptedException {
		assignmentPage.clickEditBtn();
		name=utility.getCellData("AssignmentDetails",1 , 0);
		assignmentPage.enterAssnName(name);
		des=utility.getCellData("AssignmentDetails", 1, 1);
		assignmentPage.enterAssnDescription(des);
		grd=utility.getCellData("AssignmentDetails", 1, 2);
		assignmentPage.enterAssnGrade(grd);
		ddate=utility.getCellData("AssignmentDetails", 1, 3);
		assignmentPage.enterAssnDueDate(ddate);

	}

	@When("user clicks save button without entering data")
	public void user_clicks_save_button_without_entering_data() throws InterruptedException {
		assignmentPage.clickNewAssnBtn();
		assignmentPage.clickSaveBtn();
	}

	@When("user clicks on the Ascending arrow \\(down) near to the assignment name")
	public void user_clicks_on_the_ascending_arrow_down_near_to_the_assignment_name() {
		assignmentPage.clickAscDescArrowForName();
	}

	@When("user clicks on the Ascending arrow \\(down) near to the assignment description")
	public void user_clicks_on_the_ascending_arrow_down_near_to_the_assignment_description() {
		assignmentPage.clickAscDescArrowForDesc();
		
	}

	@When("user clicks on the Descending arrow \\(down) near to the assignment name")
	public void user_clicks_on_the_descending_arrow_down_near_to_the_assignment_name() {
		assignmentPage.clickAscDescArrowForName();
		assignmentPage.clickAscDescArrowForName();
	}

	@When("user clicks on the descending arrow \\(down) near to the assignment description")
	public void user_clicks_on_the_descending_arrow_down_near_to_the_assignment_description() {
		assignmentPage.clickAscDescArrowForDesc();
		assignmentPage.clickAscDescArrowForDesc();
	}
	
	@When("user enters Assignment {string} from excel")
	public void user_enters_assignment_from_excel(String string) {

	}
	
	@Then("user should be able to validate entered name")
	public void user_should_be_able_to_validate_entered_name() {
	  
	}
	
	

	@Then("user should be able to validate entered name, description, grade, and due date")
	public void user_should_be_able_to_validate_entered_name_description_grade_and_due_date() throws InterruptedException {
		String expName=assignmentPage.verifyAssnNameValue();
		System.out.println(expName);
		Assert.assertEquals(expName, "Test");
		String expDesc=assignmentPage.verifyAssnDescValue();
		Assert.assertEquals(expDesc, "Test Assignment");
		String expGrade=assignmentPage.verifyAssnGradeValue();
		Assert.assertEquals(expGrade, "2");
		String expDuedate=assignmentPage.verifyAssnDuedate();
		Assert.assertEquals(expDuedate, "26/09/2022");
	}

	@Then("user lands on Assignment Details Form")
	public void user_lands_on_assignment_details_form() {
		assignmentPage.verifyAssnDetailsForm();
	}

	@Then("user should see a heading with text Manage Assignment on the page")
	public void user_should_see_a_heading_with_text_manage_assignment_on_the_page() {
		boolean headerText = assignmentPage.verifyManageAssn();
		Assert.assertEquals(headerText, true);
	}

	@Then("user should see and verify the number of entries below the table")
	public void user_should_see_and_verify_the_number_of_entries_below_the_table() {
		String numEntries = assignmentPage.getTextofNumEntries();
		Assert.assertEquals(numEntries, "Showing 1 to 3 of 3 entries");
	}

	@Then("user should see and verify the total number of programs text")
	public void user_should_see_and_verify_the_total_number_of_programs_text() {
		String totalNumTxt = assignmentPage.getTextofTotalNumOfEntries();
		Assert.assertTrue(totalNumTxt.contains("In total there are"));
	}

	@Then("user should see and verify the search box has a text as {string}")
	public void user_should_see_and_verify_the_search_box_has_a_text_as(String string) {
		boolean search = assignmentPage.verifySearchText();
		Assert.assertEquals(search, true);
	}

	@Then("user should be able to see the name entered")
	public void user_should_be_able_to_see_the_name_entered() {
		boolean txt = assignmentPage.verifyTxtInSearch();
		Assert.assertEquals(txt, true);
	}

	@Then("assignment gets selected")
	public void assignment_gets_selected() throws InterruptedException {
		boolean att = assignmentPage.verifyCheckboxSelected();
		Assert.assertEquals(att, true);

	}

	@Then("user should see {string} message")
	public void user_should_see_message(String message) {
		switch(message) {
		case "updatedMessage":
		String actualMsg=assignmentPage.verifyUpdatedMsg();
		Assert.assertEquals(actualMsg, "Assignment Updated");
	
		case "createdMessage":
		String actualMsg2=assignmentPage.verifyCreatedMsg();
		Assert.assertEquals(actualMsg2, "Assignment Created");
		
		case "deletedMessage":
			String actualMsg3=assignmentPage.verifyDeletedMsg();
			Assert.assertEquals(actualMsg3, "Assignment Deleted");
	}
	}

	@Then("user should see Assignment Details Form disappear")
	public void user_should_see_assignment_details_form_disappear() {
		boolean form=assignmentPage.verifyAssnDetailsForm();
		Assert.assertEquals(form, false);
	}

	@Then("user should land on Confirm Deletion Form")
	public void user_should_land_on_confirm_deletion_form() {
		assignmentPage.verifyConfirmDeletionForm();
	}

	@Then("user can see Confirm Deletion Form disappear")
	public void user_can_see_confirm_deletion_form_disappear() {
		boolean form=assignmentPage.verifyConfirmDeletionForm();
		Assert.assertEquals(form, false);
	}

	@Then("user can see assigntmnets get selected")
	public void user_can_see_assigntmnets_get_selected() {
		assignmentPage.verifyMultiCheckboxSelected();
	}

	@Then("user gets message {string}")
	public void user_gets_message(String string) {
		String expTxt=assignmentPage.getNameReqMsg();
		Assert.assertEquals(expTxt, "Name is required.");
	}

	@Then("user should see need to fill required fields")
	public void user_should_see_need_to_fill_required_fields() {

	}

	@Then("user should see Submit Assignment Successfully")
	public void user_should_see_submit_assignment_successfully() {

	}

	@Then("user should see the results in ascending order of the assignment name")
	public void user_should_see_the_results_in_ascending_order_of_the_assignment_name() {
		 List actualList=new ArrayList();
		 List<WebElement>nameList=driver.findElements(By.xpath("//tbody/tr/td[2]"));
		 
		 for(WebElement e:nameList) {
			 String names=e.getText();
			 actualList.add(names);
		 }
		 List tempList=new ArrayList();
		 tempList.addAll(actualList);
		 Collections.sort(tempList);
		 Assert.assertTrue(actualList.equals(tempList));
	}

	@Then("user should see the results in ascending order of the assignment description")
	public void user_should_see_the_results_in_ascending_order_of_the_assignment_description() {
		
		 List actualList=new ArrayList();
		 List<WebElement>descList=driver.findElements(By.xpath("//tbody/tr/td[3]"));

		 
		 for(WebElement e:descList) {
			 String desc=e.getText();
			 System.out.println(desc);
			 actualList.add(desc);
			 System.out.println(actualList);
		 }
		 List tempList=new ArrayList();
		 tempList.addAll(actualList);
	//	 Collections.sort(tempList);
		 System.out.println(tempList);
		 Assert.assertTrue(actualList.equals(tempList));
		
	}

	@Then("user should see the results in descending order of the assignment name")
	public void user_should_see_the_results_in_descending_order_of_the_assignment_name() {
		 List actualList=new ArrayList();
		 List<WebElement>nameList=driver.findElements(By.xpath("//tbody/tr/td[2]"));
		 
		 for(WebElement e:nameList) {
			 String names=e.getText();
			 actualList.add(names);
		 }
		 List tempList=new ArrayList();
		 tempList.addAll(actualList);
		 Collections.sort(tempList, Collections.reverseOrder());
		 Assert.assertTrue(actualList.equals(tempList));
	}

	@Then("user should see the results in descending order of the assignment description")
	public void user_should_see_the_results_in_descending_order_of_the_assignment_description() {
		 List actualList=new ArrayList();
		 List<WebElement>descList=driver.findElements(By.xpath("//tbody/tr/td[3]"));
		 
		 for(WebElement e:descList) {
			 String desc=e.getText();
			 System.out.println(desc);
			 actualList.add(desc);
			 System.out.println(actualList);
		 }
		 List tempList=new ArrayList();
		 tempList.addAll(actualList);
//		 Collections.sort(tempList, Collections.reverseOrder());
		 System.out.println(tempList);
		 Assert.assertTrue(actualList.equals(tempList));
	}

}
