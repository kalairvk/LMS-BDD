#Author: Kalaipriya
#Keywords Summary : Common Delete button on program page

Feature: Delete button on Program page

  @tag3
  Scenario: Validating the default state of Delete button 
    Given User is logged on to LMS website
    When User is on Program page
    Then User should see the Delete button on the top left hand side as Disabled

 
