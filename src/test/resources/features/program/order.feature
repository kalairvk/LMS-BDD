#Author: Kalaipriya
#Keywords Summary : validating pagination functions

Feature: Pagination

  @tag11
  Scenario: Verify that the results are displayed in Ascending order of Program name
    Given User is on the Program  page	
    When User clicks on the Ascending arrow near to the "Program Name" 
    Then User can see the results in Ascending order of "Program Name"
  
  Scenario: Verify that the results are displayed in Ascending order of Program Description
    Given User is on the Program  page	
    When User clicks on the Ascending arrow near to the "Program Description" 
    Then User can see the results in Ascending order of "Program Description"
  
   Scenario: Verify that the results are displayed in Ascending order of Program Status
    Given User is on the Program  page	
    When User clicks on the Ascending arrow near to the "Program Status" 
    Then User can see the results in Ascending order of "Program Status"
    
  Scenario: Verify that the results are displayed in Descending order of Program name
    Given User is on the Program  page	
    When User clicks on the Descending arrow near to the "Program Name" 
    Then User can see the results in Descending order of "Program Name"
  
  Scenario: Verify that the results are displayed in Descending order of Program Description
    Given User is on the Program  page	
    When User clicks on the Descending arrow near to the "Program Description" 
    Then User can see the results in Descending order of "Program Description"
  
   Scenario: Verify that the results are displayed in Descending order of Program Status
    Given User is on the Program  page	
    When User clicks on the Descending arrow near to the "Program Status" 
    Then User can see the results in Descending order of "Program Status"
    
    