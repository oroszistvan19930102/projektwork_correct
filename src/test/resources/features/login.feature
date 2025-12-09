Feature: Log in
  Background:
    Given the user opens the Digital Bank login page
    And the user accepts the cookies

  @successful_login
  Rule: Users with valid credentials can log in successfully
    Scenario: Successful log in
      When the user enters valid username "oroszistvan1993" and password "Password1!"
      And the user logs in
      Then the main dashboard page should be displayed

  @unsuccessful_login
  Rule: Users with invalid credentials see an error message
    Scenario Outline: Unsuccessful log in
      When the user enters invalid username "<username>" and password "<password>"
      And the user logs in
      Then a login error message should be displayed

      Examples:
        | username  | password  |
        | admin1    | pass      |
        | user1     | pa55w0rd  |
