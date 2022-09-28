Feature: Assignment Functioonality Validation

Scenario: User should be able to validate the heading
    Given User is logged on to LMS website
    When user clicks on Assignment menu option
    Then user should see a heading with text Manage Assignment on the page

Scenario: User should be able to validate the text below the table
    Given User is logged on to LMS website
    When user clicks on Assignment menu option
    Then user should see and verify the number of entries below the table

Scenario: User should be able to validate the footer
    Given User is logged on to LMS website
    When user clicks on Assignment menu option
    Then user should see and verify the total number of programs text

Scenario: User should be able to validate the search box
    Given User is logged on to LMS website
    When user clicks on Assignment menu option
    Then user should see and verify the search box has a text as "Search"

Scenario: User should be able to search assignment by name
    Given user is on Manage Assignment page
    When user clicks on search with "name phrase" into search box
    Then user should be able to see the name entered

Scenario: User should be able to select assignment
    Given user is on Manage Assignment page
    When user selects assignment using checkbox
    Then assignment gets selected

#Scenario: User should be able to validate the edit feature
    #Given user is on Manage Assignment page
    #When user clicks on "Edit" button
    #Then user lands on Assignment Details Form
 
 Scenario: User should be able to edit and validate assignement details form
    Given user is on Assignment Details Form
    When user edits "name", "description", "grade", "due date" taken from excel
    Then user should be able to validate entered name, description, grade, and due date
   
Scenario: User should be able to click and verify save button
    Given user is on Assignment Details Form
    When user clicks on "Save" button
    Then user should see "Assignment Updated" message
    
Scenario: User should be able to click on new assignment button
    Given user is on Manage Assignment page
    When user clicks on "New Assignment" button
    Then user lands on Assignment Details Form

#Scenario: User should not be able to submit empty form
    #Given user is on Assignment Details Form
    #When user clicks save button without entering data
    #Then user gets message "Name is required."

Scenario: User should be able to add a new assignment with valid details
    Given user is on Manage Assignment page
    When user enters Assignment "name", "description", "grade", "due date" taken from excel and click save
    Then user should see "Assignment Created" message

Scenario: User should be able to click and verify delete button
    Given user is on Manage Assignment page
    When user clicks on "Delete" button after selecting an assignment
    Then user should land on Confirm Deletion Form

Scenario: User should be able to click yes option for assignment deletion and verify
    Given user is on Confirm Deletion Form
   	When user clicks on "Yes" button
    Then user should see "Assignment Deleted" message

Scenario: User should be able to click no option single assignment deletion and verify
    Given user is on Confirm Deletion Form
    When user clicks on "No" button
    Then user can see Confirm Deletion Form disappear
    
Scenario: User should be able to select multiple assignment
    Given user is on Manage Assignment page
    When user selects more than one assignment using checkbox
    Then user can see assigntmnets get selected
       
 Scenario: User should be able to click yes option for multiple assigment deletion
    Given user is on Confirm Deletion Form
    When user clicks on "Yes" button
    Then user should see "Assignment Deleted" message
    
Scenario: User should be able to click no option for multiple assignment deletion
    Given user is on Confirm Deletion Form
    When user clicks on "No" button
    Then user can see Confirm Deletion Form disappear

Scenario: User should be able verify the ascending order of assignment name
    Given user is on Manage Assignment page
    When user clicks on the Ascending arrow (down) near to the assignment name
    Then user should see the results in ascending order of the assignment name
  
  Scenario: User should be able verify the ascending order of description
   Given user is on Manage Assignment page
    When user clicks on the Ascending arrow (down) near to the assignment description
    Then user should see the results in ascending order of the assignment description

  Scenario: User should be able verify the descending order of assignment name
    Given user is on Manage Assignment page
    When user clicks on the Descending arrow (down) near to the assignment name
    Then user should see the results in descending order of the assignment name

  Scenario: User should be able verify the descending order of assignment description
   Given user is on Manage Assignment page
    When user clicks on the descending arrow (down) near to the assignment description
    Then user should see the results in descending order of the assignment description
    
   #Scenario: User should be able to click and verify cancel button
    #Given user is on Assignment Details Form
    #When user clicks on "Cancel" button
    #Then user should see Assignment Details Form disappear

  #Scenario: User should not be able submit form without filling
    #Given user is on Assignment page
    #When user clicks on "Submit" button
    #Then user should see need to fill required fields

  #Scenario: User should be able submit form with valid data
  #Given user is on Assignment page
  #When user clicks on "Submit" button
  #Then user should see Submit Assignment Successfully
