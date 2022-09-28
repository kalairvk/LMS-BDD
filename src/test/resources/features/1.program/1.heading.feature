#Author: Kalaipriya
#Keywords Summary : Validate the heading feature for Manage Program page


Feature: ManageProgram Heading

  @tag1
  Scenario: Validate the heading
    Given User is logged on to LMS website
    When User is on Program page
    Then User should see a heading with text "Manage Program" on the page

