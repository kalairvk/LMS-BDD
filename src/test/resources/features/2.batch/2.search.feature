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
Feature: search and Edit feature
Background: User is logged on to LMS website
  	Given User is logged on to LMS website
  
 	@tag4
  Scenario: Search by Batch Name
    Given User is on Batch page
    When Batch-user clicks on search box with Batch Name entered in it
    Then Batch-records of that "Batch Name" are displayed

 	@tag5
  Scenario: Edit Feature
    Given User is on Batch page
    When Batch-User clicks on Edit button
    Then Batch-User lands on Batch Details form
    

