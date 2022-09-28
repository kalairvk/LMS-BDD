#Author: Kalaipriya
#Keywords Summary : Adding new program in program page

Feature: Add new program

  @tag9
  Scenario: Validate Add New Program	
    Given User is on Manage Program page	
    When User clicks "A New Program" button in program page
    Then User lands on Program Details Page dialog.

  Scenario: Empty form submission	
     Given User is on Program Details Dialog	
     When User clicks "Save" button without entering data	
     Then User gets message 'Name is required.'  
    
  Scenario Outline: Enter Program details
    Given User is on Program Details Dialog	
    When User enters "<name>" and "<description>" in the corresponding text boxes
    Then User can see the "<name>" and "<description>" entered

    Examples: 
      | name  | description | 
      | lmstest | testing   | 
      
  Scenario: Select Status	
    Given User is on Program Details Dialog	
    When User selects Status using radiobutton	
    Then User can see Active or Inactive status selected 
    
  Scenario: Click Save	
    Given User is on Program Details Dialog	
    When User clicks "Save" button on new program page
    Then User gets success message 'Successful Program Created'  
    
   Scenario: Click Cancel	
    Given User is on Program Details Dialog	
    When User clicks "Cancel" or close button	
    Then User can see new Program Details form disappears   
      
    

