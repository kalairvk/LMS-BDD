#Author: Kalaipriya
#Keywords Summary : Validate the Edit function in program page

Feature: Edit program details

  @tag6
  Scenario: Edit Feature
    Given User is on Program page table
    When User clicks on Edit button
    Then User lands on Program Details form.
      
  Scenario Outline: Edit Program Name
    Given User is on Program Details form
    When User edits Name and selects the Save button
       | TestProgram | 
    Then User can see updated Name  
    
  Scenario Outline: Edit Program Description
    Given User is on Program Details form
    When User edits Description and selects the Save button
       | Testdata |
    Then User can see updated Description 
    
  Scenario: Change Program Status
    Given User is on Program Details form
    When User changes status and selects the Save button
    Then User can see updated Status  
  
    
  Scenario: Click Cancel
    Given User is on Program Details form
    When User clicks "Cancel" x button
    Then User can see Program Details form disappears     
    
  Scenario: Click Save
    Given User is on Program Details form
    When User clicks "Save" button
    Then User can see 'Successful Program Updated' message
    
