Feature: Test login functionality
 Scenario Outline: check login is successful with valid login credentials
    Given browser is open
    And user is on login page
    When users enters <username> and <password>
    And user click on login button
    Then user is navigate to home page
   Examples:
     | username | password |
     | admin    | 123      |
     | rangoli  | 12345    |




