#Author: Kalaipriya
#Keywords Summary : Validate the footer feature for Manage Program page


Feature: Manage Program footer

  Background:
     Given User is logged on to LMS website
     When User is on Program page

  @tag2
  Scenario: Validate the text below the table
    Then User should see the text as "Showing [0-9]+ to [0-9]+ of [0-9]+ entries" below the table. 

  Scenario: Validate the footer
    Then User should see the footer as "In total there are [0-9]+ programs."