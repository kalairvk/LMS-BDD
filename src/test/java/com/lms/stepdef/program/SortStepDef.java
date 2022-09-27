package com.lms.stepdef.program;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Ordering;
import com.lms.model.program.LoginPage;
import com.lms.model.program.ProgramEditor;
import com.lms.model.program.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortStepDef {
	
	private LoginPage loginpage = new LoginPage();
	private ProgramPage programPage = new ProgramPage();
	private ProgramEditor programEditor = new ProgramEditor();
	private static Logger logger = LogManager.getLogger(ProgramPageStepDef.class);
	

	@Given("User is on the Program  page")
	public void user_is_on_the_program_page() {
		if(!programPage.isOpen()) {
			loginpage.OpenURL();
			loginpage.Login();
		} else {
			programPage.loadProgramPage();
		}
	}

	@When("User clicks on the Ascending arrow near to the {string}")
	public void user_clicks_on_the_ascending_arrow_down_near_to_the(String columnName) {
	    programPage.sortByColumn(columnName, "ascending");
	}

	@Then("User can see the results in Ascending order of {string}")
	public void user_can_see_the_results_in_ascending_order_of(String columnName) {
	    List<String> data = programPage.getColumnValues(columnName);
	    boolean isOrdered=Ordering.natural().isOrdered(data);
	    assertTrue(isOrdered, data.toString());
	}

	@When("User clicks on the Descending arrow near to the {string}")
	public void user_clicks_on_the_descending_arrow_down_near_to_the(String string) {
		programPage.sortByColumn(string, "descending");
	}

	@Then("User can see the results in Descending order of {string}")
	public void user_can_see_the_results_in_descending_order_of(String string) {
		List<String> data = programPage.getColumnValues(string);
	    boolean isOrdered=Ordering.natural().reverse().isOrdered(data);
	    assertTrue(isOrdered, data.toString());
	}




}
