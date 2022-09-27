#Author: Kalaipriya
#Keywords Summary :Validate that number of records (rows of data in the table) displayed 


Feature: Number of Records in program table 

  @tag4
  Scenario: Validate that number of records (rows of data in the table) displayed
    Given User is logged on to LMS website
    When User is on Program page
    Then Verify the number of records displayed on the page are 5


 
