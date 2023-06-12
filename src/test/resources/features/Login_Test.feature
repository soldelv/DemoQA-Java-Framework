Feature: Login flow in DemoQA

  Scenario Outline: Successfully login in DemoQA website
    Given The user access to the Books page
    When The user clicks on Login page
    And The user enters user <username> and password <password>
    Then The user is on the Home page
    Examples:
      |   username  |  password  |
      | testdemoqa1 | Test1234*+ |


  Scenario Outline: Unsuccessfully login with invalid user or password
    Given The user access to the Books page
    When The user clicks on Login page
    And The user enters user <username> and password <password>
    Then An Error message should be displayed
    Examples:
      | username |  password |
      | test_xxx | xxx1234*+ |


  Scenario: A user without credentials accesses for first time
    Given The user access to the Books page
    When The user clicks on Login page
    And The user clicks on New User button
    Then The user is on Register page and goes back to Login page