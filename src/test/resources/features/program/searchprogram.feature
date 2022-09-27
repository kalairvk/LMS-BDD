#Author: Kalaipriya
#Keywords Summary : Validate search button and searching by program name,description,status

Feature: Search Program in program page

  @tag5
  Scenario: Validate Search Feature
    Given User is logged on to LMS website
    When User is on Program page
    Then Text box used for search has text as 'Search...'

  Scenario Outline: Search Program By Name
    Given User is on Program page
    When User enters program name "<name phrase>" into search box.
    Then Entries for name "<name phrase>" are shown.
    
    Examples:
     |name phrase|
     |test|
    
  Scenario Outline: Search Program By Description
     Given User is on Program page
     When User enters program description "<description phrase>" into search box.
     Then Entries for description "<description phrase>" are shown.
     
     Examples:
      |description phrase|
      |program|
     
   Scenario Outline: Search Program By Status
      Given User is on Program page
      When User enters program status "<status phrase>" into search box.
      Then Entries for status "<status phrase>" are shown.  
      
      Examples:
      |status phrase|
      |Inactive|
      |Active|
  
  
