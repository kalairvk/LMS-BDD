#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then Batch-steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Edit batch
  
   Background: User is logged on to LMS website
  	Given User is logged on to LMS website
  	When Batch-User is on Batch page 
  	
  @tag6
  Scenario: Edit Batch Name
    Given User is on Batch details page
    When Batch-User edits Name
    Then Batch-User can see edited Name
    
   @tag7
  Scenario: Edit  Batch Description
    Given User is on Batch details page
    When Batch-user edits description
    Then Batch-User can see edited descricption
    
  @tag8
  Scenario: Edit program name
    Given User is on Batch details page
    When Batch-user edits program name
    Then Batch-user can see edited program name
    
  @tag9
  Scenario: change status
    Given User is on Batch details page
    When Batch-user changes status
    Then Batch-User can see updated Status

     @tag10
  Scenario: Edit No of classes
    Given User is on Batch details page
    When Batch-user edits No of classes
    Then Batch-user can see updated No of classes
    
     @tag11
  Scenario: Click Cancel
    Given User is on Batch details page
    When Batch-user clicks cancel button
    Then Batch-User can see Batch Details are not updated 
    
    @tag12
  Scenario: click save
    Given User is on Batch details page
    When Batch-user clicks save button
    Then Batch-User can see 'Successful Batch Updated' alert
    
     @tag13
  Scenario: Verify Edited Batch details
    Given User is on Batch page
    When Batch-User searches with newly updated "Batch Name"
    Then Batch-User verifies that the details are correctly updated.
    
     @tag14
  Scenario: Select Batch
    Given User is on Batch page
    When Batch-User selects more than one Batch using checkbox
    Then Batch-Baches gets selected
    
     @tag15
  Scenario: Delete  multiple batches 
    Given User is on Batch page
    When Batch-User clicks on Delete button
    Then Batch-User lands on Confirm Deletion form.
    
     @tag16
  Scenario: Click Yes
    Given user is on Batch Confirm Deletion page
    When Batch-User clicks Yes button
    Then Batch-User can see 'Successful BatchDeleted' message

     @tag17
  Scenario: Verify deleted batches
    Given User is on Batch page
    When Batch-User Searches for "Deleted Batch names"
    Then Batch-There should be zero results

    @tag18
  Scenario: click no
    Given User is on Batch Confirm Deletion Page after selecting multiple batches
    When Batch-User clicks No button
    Then Batch-User can see Batches are still selected and not deleted
    
    @tag19
  Scenario: delete feature
    Given user is on the Batch page
    When Batch-user clicks delete  button for any batch
    Then Batch-user will get confirm deletion popup
    
      @tag20
  Scenario: Click Yes
    Given user is on Batch Confirm Deletion page
    When Batch-User clicks Yes button
    Then Batch-User can see 'Successful BatchDeleted' message
    
      @tag21
  Scenario: Verify deleted batch
    Given user is on the Batch page
    When Batch-User Searches for "Deleted Batch name"
    Then Batch-There should be zero results
    
     @tag22
  Scenario: click no
    Given User is on Batch Confirm Deletion Page after selecting a batch to delete
    When Batch-User clicks No button
    Then Batch-User can see Batch is not deleted
    
        @tag23
  Scenario: validate add new batch
    Given User is on Batch page
    When Batch-User clicks A New Batch button
    Then Batch-user can see Batch details form
    
        @tag24
  Scenario: Empty form submission
  
    Given User is on Batch details page by clicking A New Batch
    When Batch-User clicks Save button without entering data
    Then Batch-User gets message 'Name is required.'

        @tag25
  Scenario: Click Cancel
    Given User is on Batch details page by clicking A New Batch
    When Batch-user clicks cancel button
    Then Batch-User can see Batch Details form disappears
    
        @tag26
  Scenario: Enter Batch Name
    Given User is on Batch details page by clicking A New Batch
    When Batch-user enters name in text box
    Then Batch-User can see 'Batch Name' entered

    
        @tag27
  Scenario: Enter Batch Description
    Given User is on Batch details page by clicking A New Batch
    When Batch-User enters Description in text box
    Then Batch-User can see 'Description' entered
    
           @tag28
  Scenario: Enter Program name
    Given User is on Batch details page by clicking A New Batch
    When Batch-User selects Program name
    Then Batch-User can see 'Program Name' selected

       @tag29
  Scenario: Select Status
    Given User is on Batch details page by clicking A New Batch
    When Batch-User selects Status using radiobutton
    Then Batch-User can see 'Active/Inactive' status selected

           @tag30
  Scenario: Enter No of classes
    Given User is on Batch details page by clicking A New Batch
    When Batch-User enters No of classes in text box
    Then Batch-User can see 'No of classes' entered

           @tag31
  Scenario: Click Save
    Given User is on Batch details page by clicking A New Batch
    When Batch-user clicks save button
    Then Batch-User gets message 'Successful batch created'

      @tag32
  Scenario: Verify Added Batch is created
    Given User is on Batch page
    When Batch-User searches with newly created "Batch Name"
    Then Batch-records of the newly created  "Batch Name" is displayed
    
    

    
    


