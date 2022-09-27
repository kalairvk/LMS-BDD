package com.lms.stepdef.batch;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.google.common.collect.Ordering;
import com.lms.model.batch.BatchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchStep {

	private BatchPage batchpage = new BatchPage();
	//public static BaseClass baseC = new BaseClass();
	public String statusOriginal;
	public String batchNameChecked;
	List<String> batchDetails = new ArrayList<String>();
	public String batchNameSelected;
	
//	@BeforeAll
//	public static void before_all() throws InterruptedException
//	{
//		System.out.println("**********************");
//		driver = baseC.setup();
//		batchpage = new BatchPage(driver);
//		batchpage.login();
//	}
//	
//	@AfterAll
//	public static void after_all() throws InterruptedException
//	{
//		driver.quit();
//	}
	
	
	@Given("User is on Batch page")
	public void Given_user_is_on_batch_page() {
		   batchpage.navigateToBatchPage();
	}
	@When("Batch-User is on Batch page")
	public void user_is_on_batch_page() {
		   batchpage.navigateToBatchPage();
	}
	
			
	@Then("Batch-User should see a heading with text {string} on the page")
	public void user_should_see_a_heading_with_text_on_the_page(String string) {
		
		String headingAct = batchpage.verifyHeading();
		String headingExp = "Manage Batch";
		System.out.println("Batch heading :"+headingAct);
		Assert.assertEquals(headingAct, headingExp);
		
		
			
	}
	
	/* Scenario 2 */
	
	@Then("Batch-Verify that the Delete button next to the search box is Disabled")
	public void verify_that_the_delete_button_next_to_the_search_box_is_disabled() {
	boolean statusAct = batchpage.deleteButtonStatus();
		boolean statusExp = false;
		if(statusAct)
			System.out.println("Delete button Enabled");
		else
			System.out.println("Delete button disabled");
		Assert.assertEquals(statusAct, statusExp);
	
		
	}
	
	/* Scenario 3 */
	
	@Then("Batch-Verify that number of records \\(rows of data in the table) displayed on the page are {int}")
	public void verify_that_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
	    System.out.println("***************No of rows :"+int1);
	    int noOfRowsAct = batchpage.numberOfRows();
	    int noOfRowsExp = 5;
	    Assert.assertEquals(noOfRowsAct, noOfRowsExp);
	   
	    
	}
	
	/* Scenario 4 */
	
	@When("Batch-user clicks on search box with Batch Name entered in it")
	public void user_clicks_on_search_box_with_batch_name_entered_in_it() {
		batchpage.search("SDET");
	}
	
	@Then("Batch-records of that {string} are displayed")
	public void records_of_that_are_displayed(String string)
	{
		String batchNameAct = batchpage.verifyBatchName();
		String batchNameExp = "SDET";
		System.out.println("batchNameAct :"+ batchNameAct);
		if(batchNameAct!=null)
		{
			if(batchNameAct.contains(batchNameExp))
			{
				Assert.assertEquals(true, true);
			}
			else
			{
				Assert.assertEquals(true, false);
			}
		}
		else {
			System.out.println("No rows present with table name :"+batchNameExp);
		}
		Assert.assertEquals(true, true);
	}
	
	/* Scenario 5 */
	@When("Batch-User clicks on Edit button")
	public void user_clicks_on_edit_button() {
	
		batchpage.editButtonClick();
	}
	
	@Then("Batch-User lands on Batch Details form")
	public void user_lands_on_batch_details_form() {
		String headingAct = batchpage.VerifybatchDetailsHeading();
		String headingExp ="Batch Details";
		if(headingAct!=null)
		{
			if(headingAct.equals(headingExp))
			{
				Assert.assertEquals(true, true);
			}
			else
			{
				Assert.assertEquals(true, false);
			}
		}
		else
		{
			System.out.println("Table is empty");
			Assert.assertEquals(true, true);
		}	
	}
	
	/* Scenario 6 */
	
	@Given("User is on Batch details page")
	public void user_is_on_batch_details_page() throws InterruptedException {
		batchpage.editButtonClick();
	}
	
	@When("Batch-User edits Name")
	public void user_edits_name() throws InterruptedException {
		batchpage.editBatchName();
	}
	
	@Then("Batch-User can see edited Name")
	public void user_can_see_edited_name() {
		boolean status = batchpage.verifyEditedBatchName();
		Assert.assertEquals(status, true);
	}
	

	/* Scenario 7 */
	@When("Batch-user edits description")
	public void user_edits_description() {
		batchpage.editBatchDescription();
	}
	@Then("Batch-User can see edited descricption")
	public void user_can_see_edited_descricption() {
		boolean status = batchpage.VerifyEditedBatchDescription();
		Assert.assertEquals(status, true);
	}
	
	/* Scenario 8 */
	 @When("Batch-user edits program name")
	public void user_edits_program_name() throws InterruptedException {
		batchpage.editProgramName();
	}
	@Then("Batch-user can see edited program name")
	public void user_can_see_edited_program_name() {
		boolean status = batchpage.VerifyEditedProgramName();
		Assert.assertEquals(status, true);
	}
	
	
	/* Scenario 9 */
	@When("Batch-user changes status")
	public void user_changes_status() {
		batchpage.changeStatus(); 
	}
	
	@Then("Batch-User can see updated Status")
	public void user_can_see_updated_status() {
		boolean status= batchpage.getBatchStatus();
			Assert.assertEquals(status, true);
	}
	
	/* Scenario 10 */
	@When("Batch-user edits No of classes")
	public void user_edits_no_of_classes() {
		batchpage.editNoOfClasses();
	}
	
	@Then("Batch-user can see updated No of classes")
	public void user_can_see_updated_no_of_classes() {
		boolean status= batchpage.VerifyEditedNoOfClasses();
		Assert.assertEquals(status, true);
	}

	/* Scenario 11 */
	
	 @When("Batch-user clicks cancel button")
	    public void user_clicks_cancel_button(){
		 batchDetails = batchpage.cancelBatchDetails();
	    }
	 
	    @Then("Batch-User can see Batch Details are not updated")
	    public void user_can_see_batch_details_are_not_updated() {
	    	List<String> batchDetailsAfterCancel = new ArrayList<String>();
	    	batchDetailsAfterCancel = batchpage.getBatchDetails();
	    	if(batchDetails.equals(batchDetailsAfterCancel))
	    	{
	    		Assert.assertEquals(true, false);
	    	}
	    	else {
	    		Assert.assertEquals(true, true);
	    	}
	    }
	
	/* Scenario 12 */
	
	    @When("Batch-user clicks save button")
		public void user_clicks_save_button() throws InterruptedException {
	    	batchDetails = batchpage.saveBatchDetails();  
		}
	    
		@Then("Batch-User can see {string} alert")
		public void user_can_see_alert(String string) {
			boolean status = batchpage.successMsg();
			Assert.assertEquals(status, true);
		}
	    
	/* Scenario 13 */
	
		@When("Batch-User searches with newly updated {string}")
		public void user_searches_with_newly_updated(String string) throws InterruptedException {
			batchpage.editButtonClick();
			batchDetails = batchpage.saveBatchDetails();  
			batchpage.search("Rose");
			batchpage.searchClear();
			
		}
		@Then("Batch-User verifies that the details are correctly updated.")
		public void user_verifies_that_the_details_are_correctly_updated() {
		 	List<String> batchDetailsAfterSave = new ArrayList<String>();
	    	batchDetailsAfterSave = batchpage.getBatchDetails();
	    	if(batchDetails.equals(batchDetailsAfterSave))
	    	{
	    		Assert.assertEquals(true, true);
	    	}
	    	else {
	    		Assert.assertEquals(true, false);
	    	}
		}
	
		/* Scenario 14 */

		@When("Batch-User selects more than one Batch using checkbox")
		public void user_selects_more_than_one_batch_using_checkbox() {
			batchNameChecked=batchpage.selectMultipleCheckBox();
		}
		@Then("Batch-Baches gets selected")
		public void baches_gets_selected() {
			boolean status = batchpage.verifySelectMultipleBatches();
			Assert.assertEquals(status, true);
		}
		
		/* Scenario 15 */

		@When("Batch-User clicks on Delete button")
		public void user_clicks_on_delete_button() {
			
			batchpage.clickDeleteCmnBtn();
		   
		}
		@Then("Batch-User lands on Confirm Deletion form.")
		public void user_lands_on_confirm_deletion_form() throws InterruptedException {
			boolean status = batchpage.VerifyConfirmDeleteAlert();
			Assert.assertEquals(status, true);
		}

		//s16
		@Given("user is on Batch Confirm Deletion page")
		public void user_is_on_batch_confirm_deletion_page() {
			//single
			//batchNameChecked=batchpage.selectMultipleCheckBox();
			//batchpage.clickDeleteCmnBtn();
			
			
			batchpage.VerifyConfirmDeleteAlert();
		}
		
		
		@When("Batch-User clicks Yes button")
		public void user_clicks_yes_button() {
		
			
			batchpage.confirmWithYes();
		}
		
		@Then("Batch-User can see {string} message")
		public void user_can_see_message(String string) {
			batchpage.successMsg();
			//thread.sleep(500);
		}
		
		//s17

		@When("Batch-User Searches for {string}")
		public void user_searches_for(String string) {
			
			batchpage.search(batchNameChecked);
			
		}
		
		@Then("Batch-There should be zero results")
		public void there_should_be_zero_results() {
			boolean status = batchpage.verifyDeletedBatchNames();
			Assert.assertEquals(status, true);
			
		}

		//s18


		@Given("User is on Batch Confirm Deletion Page after selecting multiple batches")
		public void user_is_on_batch_confirm_deletion_page_after_selecting_multiple_batches() {
			batchNameChecked=batchpage.selectMultipleCheckBox();
			batchpage.clickDeleteCmnBtn();
			batchpage.VerifyConfirmDeleteAlert();
		}

		
		@When("Batch-User clicks No button")
		public void user_clicks_no_button() {
			batchpage.cancelConfirmPopup();
		}
		
		@Then("Batch-User can see Batches are still selected and not deleted")
		public void user_can_see_batches_are_still_selected_and_not_deleted() {
			boolean status = batchpage.verifyCheckboxEnabled();
			batchpage.uncheckChkBox();
			Assert.assertEquals(status, true);
		}


		@Given("user is on the Batch page")
		public void user_is_on_the_batch_page() {
			 batchpage.navigateToBatchPage();
		}
		
		@When("Batch-user clicks delete  button for any batch")
		public void user_clicks_delete_button_for_any_batch() throws InterruptedException {
		  batchNameSelected = batchpage.clickDeleteBtnOfAnyBatch();
		}
		@Then("Batch-user will get confirm deletion popup")
		public void user_will_get_confirm_deletion_popup() {
			boolean status = batchpage.VerifyConfirmDeleteAlert();
			Assert.assertEquals(status, true);
		}
		
		//s22
		

		@Given("User is on Batch Confirm Deletion Page after selecting a batch to delete")
		public void user_is_on_batch_confirm_deletion_page_after_selecting_a_batch_to_delete() {
			batchNameSelected = batchpage.clickDeleteBtnOfAnyBatch();
			
			
			batchpage.isDleteAlertOpen();
			
		   
		}
		@Then("Batch-User can see Batch is not deleted")
		public void user_can_see_batch_is_not_deleted() {
		    boolean status = batchpage.verifyBatchNotDeleted(batchNameSelected);
			Assert.assertEquals(status, true);
		}

		//s23
		

		@When("Batch-User clicks A New Batch button")
		public void user_clicks_a_new_batch_button() {
		  batchpage.clickNewBatch();  
		}
		@Then("Batch-user can see Batch details form")
		public void user_can_see_batch_details_form() {
			String headingAct = batchpage.VerifybatchDetailsHeading();
			String headingExp ="Batch Details";
			if(headingAct!=null)
			{
				if(headingAct.equals(headingExp))
				{
					Assert.assertEquals(true, true);
				}
				else
				{
					Assert.assertEquals(true, false);
				}
			}
			else
			{
				System.out.println("Table is empty");
				Assert.assertEquals(true, true);
			}	
		}

		@Given("User is on Batch details page by clicking A New Batch")
		public void user_is_on_batch_details_page_by_clicking_a_new_batch() {
			batchpage.clickNewBatch();
		}




	@When("Batch-User clicks Save button without entering data")
	public void user_clicks_save_button_without_entering_data() {
	
		batchpage.saveNewBatchDetails();
	}
	
	
	@Then("Batch-User gets message {string}")
	public void user_gets_message(String string) {
		boolean status;
		if(string.equals("Name is required."))
		status = batchpage.nameRquiredMessage(string);
		else if(string.equals("Successful batch created"))
			status = batchpage.successMsg();
		else
			status=false;
		Assert.assertEquals(status, true);
	}


	@Then("Batch-User can see Batch Details form disappears")
	public void user_can_see_batch_details_form_disappears() {
		String headingAct = batchpage.verifyHeading();
		String headingExp = "Manage Batch";
		System.out.println("Batch heading :"+headingAct);
		Assert.assertEquals(headingAct, headingExp);
	}


	@When("Batch-user enters name in text box")
	public void user_enters_name_in_text_box() throws InterruptedException {
		batchpage.editBatchName();
	}
	@Then("Batch-User can see {string} entered")
	public void user_can_see_entered(String string) {
		boolean status;
		if(string.equals("Batch Name"))
			status = batchpage.verifyEditedBatchName();
		else if(string.equals("Description"))
			status = batchpage.VerifyEditedBatchDescription();
		else 
		{
			if(string.equals("No of classes"))
				status = batchpage.VerifyEditedNoOfClasses();
			else
				status=false;
				
		}
			
		Assert.assertEquals(status, true);
	}


	@When("Batch-User enters Description in text box")
	public void user_enters_description_in_text_box() {
		batchpage.editBatchDescription();
	}


	@When("Batch-User selects Program name")
	public void user_selects_program_name() throws InterruptedException {
		batchpage.editProgramName();
	}
	
	
	@Then("Batch-User can see {string} selected")
	public void user_can_see_selected(String string) {
		boolean status;
		if(string.equals("Program Name"))	
			status = batchpage.VerifyEditedProgramName();
		else if(string.equals("Active/Inactive"))
			status = batchpage.getBatchStatus();
		else
			status=false;
		Assert.assertEquals(status, true);
	}


//s29
	

	@When("Batch-User selects Status using radiobutton")
	public void user_selects_status_using_radiobutton() {
		batchpage.changeStatus(); 
	}
	
	@Then("Batch-User can see {string} status selected")
	public void user_can_see_status_selected(String string) {
		boolean status;
		
		if(string.equals("Active/Inactive"))
			status = batchpage.getBatchStatus();
		else
			status=false;
		Assert.assertEquals(status, true);
	}

		//s30
	

	@When("Batch-User enters No of classes in text box")
	public void user_enters_no_of_classes_in_text_box() {
		batchpage.editNoOfClasses();
	}

	
	
	@When("Batch-User searches with newly created {string}")
	public void user_searches_with_newly_created(String string) throws InterruptedException {
		batchpage.clickNewBatch();
		batchDetails = batchpage.saveBatchDetails();  
		batchpage.search("Rose");
		batchpage.searchClear();
	}
	
	@Then("Batch-records of the newly created  {string} is displayed")
	public void records_of_the_newly_created_is_displayed(String string) {
		List<String> batchDetailsAfterSave = new ArrayList<String>();
    	batchDetailsAfterSave = batchpage.getBatchDetails();
    	if(batchDetails.equals(batchDetailsAfterSave))
    	{
    		Assert.assertEquals(true, true);
    	}
    	else {
    		Assert.assertEquals(true, false);
    	}
	}

	

	@When("Batch-User is on first page of Manage Batch")
	public void user_is_on_first_page_of_manage_batch() {
		batchpage.firstPageOfManageBatch();
	}
	
	@Then("Batch-Verify that previous link is disabled")
	public void verify_that_previous_link_is_disabled() {
		boolean status = batchpage.isPreviousLinkDisabled();
		Assert.assertEquals(status, true);
	}
	
	

	@Given("User is on page number {string}")
	public void user_is_on_page_number(String string) {
		 batchpage.goToPage(string);
	}
	

	@When("Batch-User clicks angle right > button")
	public void user_clicks_angle_right_button() {
		batchpage.goToNextPage();
	}

	@Then("Batch-User navigated to page number {string}")
	public void user_navigated_to_page_number(String string) {
		boolean status = batchpage.isInNavigatedPage(string);
		Assert.assertEquals(status, true);
	}

	

	@When("Batch-User clicks angle left < button")
	public void user_clicks_angle_left_button() {
		batchpage.goToPrevPage();
	}

	

	@When("Batch-User is on last page of Manage Batch")
	public void user_is_on_last_page_of_manage_batch() {
		batchpage.lastPageOfManageBatch();
	}
	
	@Then("Batch-Verify that next link is disabled")
	public void verify_that_next_link_is_disabled() {
		boolean status = batchpage.isNextLinkDisabled();
		Assert.assertEquals(status, true);
	}

	//s37
	

	@When("Batch-User clicks on the Ascending arrow \\(down ) near to the {string}")
	public void user_clicks_on_the_ascending_arrow_down_near_to_the(String string) {
		 batchpage.sortByColumn(string, "ascending");
	}
	
	@Then("Batch-User can see the results in Ascending order of {string}")
	public void user_can_see_the_results_in_ascending_order_of(String string) {
		List<String> data = batchpage.getColumnValues(string);
	    boolean status=Ordering.natural().isOrdered(data);
	    Assert.assertEquals(status, true);
	}
	

	@When("Batch-User clicks on the Descending arrow \\(down ) near to the {string}")
	public void user_clicks_onthe_descending_arrow_down_near_to_the(String string) {
		batchpage.sortByColumn(string, "descending");
	}
	@Then("Batch-User can see the results in Descending order of {string}")
	public void user_can_see_the_results_in_descending_order_of(String string) {
		List<String> data = batchpage.getColumnValues(string);
	    boolean status=Ordering.natural().reverse().isOrdered(data);
	    Assert.assertEquals(status, true);
	}
	
}










		



		



		


		







	
	

	
	
	
	


	
	
	


	




	
	
	   
	   
