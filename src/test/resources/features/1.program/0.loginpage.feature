Feature: Login Page
 Background:
    Given User is on the Login Page
    
     
    Scenario Outline: Validating Login process for User with invalid data
    When User clicks on Login button with entering invalid "<username>" and "<password>"
    Then User should receive the message "Invalid username and password Please try again"
   
    Examples: 
      |username|password| 
      |abcd||
    
    
  Scenario Outline: Validating Login process for User with valid data
    When User clicks on Login button with entering valid "<username>" and "<password>"
    Then User should see the LMS Home page.
   
    Examples: 
      |username|password| 
      | lms | lms  | 
    
