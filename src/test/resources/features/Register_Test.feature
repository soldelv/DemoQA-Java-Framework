Feature: Register flow process in DemoQA

  Scenario: Successfully register in DemoQA website
    Given The user access to the Register page
    When The user fills the register form and proceeds to register
    Then The user is successfully registered