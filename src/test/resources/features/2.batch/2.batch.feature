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
Feature: Heading

  @tag1
  Scenario: Validate the heading
    Given User is logged on to LMS website
    When Batch-User is on Batch page
    Then Batch-User should see a heading with text "Manage Batch" on the page
  
  @tag2
  Scenario: Validating the default state of Delete button 
    Given User is logged on to LMS website
    When Batch-User is on Batch page
    Then Batch-Verify that the Delete button next to the search box is Disabled
    
  @tag3
  Scenario: Validate that number of records (rows of data in the table) displayed 
    Given User is logged on to LMS website
    When Batch-User is on Batch page
    Then Batch-Verify that number of records (rows of data in the table) displayed on the page are 5
  
  


   
   
  
  
    
   


  

   


 