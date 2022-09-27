#Author: Kalaipriya
#Keywords Summary : Validating the Delete program functions

Feature: Delete Program in Manage Program

  @tag7
  Scenario: Delete Feature 
    Given User is on Program page
    When User clicks on Delete button on the table
    Then User lands on Confirm Deletion form.
    
  Scenario: Click Yes 
    Given User is on Confirm Deletion form
    When User clicks "Yes" button on the dialog
    Then User can see 'Successful Program Deleted' message for deletion  
    
  Scenario: Click No 
    Given User is on Confirm Deletion form
    When User clicks "No" no button
    Then User can see Confirm Deletion form disappears
    
  