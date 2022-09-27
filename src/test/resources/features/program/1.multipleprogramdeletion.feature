#Author: Kalaipriya
#Keywords Summary : Multiple program deletion in program page

Feature: Multiple Program deletion in Manage Program

  @tag8
  Scenario: Select multiple Program
     Given User is on Program page
     When User selects more than one Program using checkbox
     Then Programs get selected  
  
  Scenario: Commom Delete Feature 
    Given User is on Program page
    When User clicks on Delete button on top left corner
    Then User lands on Confirm Deletion dialog.
    
  Scenario: Click Yes 
    Given User is on Confirm Deletion form
    When User clicks "Yes" yes button 
    Then User can see 'Successful Programs Deleted' message for more deletion  
    
  Scenario: Click No 
    Given User is on Confirm Deletion form
    When User clicks "No" no button on the dialog 
    Then User can see Confirm Deletion dialog disappears
    
  