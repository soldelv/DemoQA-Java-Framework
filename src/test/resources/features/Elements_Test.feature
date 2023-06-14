Feature: Interacting with several elements

  Background:
    Given The user access to DemoQA page
    When The user goes to "Elements" section
    Then The user is able to see the "elements" page

  Scenario Outline: Test for Text Box element
    Given The user clicks on "Text Box" option
    When fills the form with <full_name>, <email>, <current_address>, and <permanent_address>
    Then The information filled is displayed as an output
    Examples:
      | full_name |     email    |current_address|permanent_address|
      |John Smith |smith@john.com| fake st. 1234 |  fake st. 5678  |

  Scenario Outline: Web tables: End to End testing
    Given The user clicks on "Web Tables" option
    When Click on add button
    And Complete the form with <first_name>, <last_name>, <email>, <age>, <salary> and <department>
    And The user search a web table register as "Smith"
    And found it
    And The user edit a web table register
    And The user delete a web table register
    Then The web table is deleted
    Examples:
      |first_name |last_name |     email      |age |salary |department |
      |   John    |  Smith   | smith@john.com | 32 |  3000 |    IT     |