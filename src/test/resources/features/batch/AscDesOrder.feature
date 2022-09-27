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
Feature: Ascending and Descending order
  

  Background: User is logged on to LMS website
  	Given User is logged on to LMS website
  	
  @tag37
  Scenario: Verify that the results are displayed in Ascending order of Batch name
    Given User is on Batch page
    When Batch-User clicks on the Ascending arrow (down ) near to the "Batch Name"
    Then Batch-User can see the results in Ascending order of "Batch Name"
  
  @tag38
  Scenario: Verify that the results are displayed in Ascending order of batch Description
    Given User is on Batch page
    When Batch-User clicks on the Ascending arrow (down ) near to the "Batch Description"
    Then Batch-User can see the results in Ascending order of "Batch Description"
  
  @tag39
  Scenario: Verify that the results are displayed in Ascending order of Batch Status
    Given User is on Batch page
    When Batch-User clicks on the Ascending arrow (down ) near to the "Batch Status"
    Then Batch-User can see the results in Ascending order of "Batch Status"
  
  @tag40
    Scenario: Verify that the results are displayed in Ascending order No of Classes
    Given User is on Batch page
    When Batch-Verify that the results are displayed in Ascending order "No Of Classes" 
    Then Batch-User can see the results in Ascending order of "No Of Classes"
    
   @tag41
  Scenario: Verify that the results are displayed in Ascending order of Program Name
    Given User is on Batch page
    When Batch-User clicks on the Ascending arrow (down ) near to the "Program Name"
    Then Batch-User can see the results in Ascending order of "Program Name"
  
    @tag42
  Scenario: Verify that the results are displayed in Descending order of Batch name
    Given User is on Batch page
    When Batch-User clicks onthe Descending arrow (down ) near to the "Batch Name"
    Then Batch-User can see the results in Descending order of "Batch Name"
  
  @tag43
  Scenario: Verify that the results are displayed in Descending order of Batch Description
    Given User is on Batch page
    When Batch-User clicks onthe Descending arrow (down ) near to the "Batch Description"
    Then Batch-User can see the results in Descending order of "Batch Description"
  
  @tag44
  Scenario: Verify that the results are displayed in Descending order of Batch Status
    Given User is on Batch page
    When Batch-User clicks onthe Descending arrow (down ) near to the "Batch Status"
    Then Batch-User can see the results in Descending order of "Batch Status"
  
  @tag45
    Scenario: Verify that the results are displayed in Descending order No of Classes
    Given User is on Batch page
    When Batch-User clicks on the Descending arrow (down ) near to the "No Of Classes" 
    Then Batch-User can see the results in Descending order of "No Of Classes"
    
   @tag46
  Scenario: Verify that the results are displayed in Descending order of Program Name
    Given User is on Batch page
    When Batch-User clicks on the Descending arrow (down ) near to the "Program Name"
    Then Batch-User can see the results in Descending order of "Program Name"
  
   
