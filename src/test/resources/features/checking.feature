Feature: New Checking
  Background:
    Given the user is logged in to the Digital Bank System
    And the user opens the checking creation page

  @successful_checking
  Rule: User with successful checking creation see the newly created check
    Scenario Outline: Successful checking creation
      When the user selects account type "<accountType>"
      And the user selects ownership "<ownership>"
      And the user enters account name "<accountName>"
      And the user enters initial deposit amount "<depositAmount>"
      And the user creates the new checking
      Then the checkings "<accountName>" of the user should be displayed
      And a confirmation message should be displayed

      Examples:
        | accountType          | ownership     | accountName      | depositAmount     |
        | Standard Checking    | Individual    | MyChecking1      | 100               |
        | Standard Checking    | Joint         | MyChecking2      | 500               |
        | Interest Checking    | Individual    | MyChecking3      | 1000              |
        | Interest Checking    | Joint         | MyChecking4      | 2000              |

  @unsuccessful_checking
  Rule: User with unsuccessful checking creation see an error message
    Scenario Outline: Unsuccessful checking creation
      When the user selects account type "<accountType>"
      And the user selects ownership "<ownership>"
      And the user enters account name "<accountName>"
      And the user enters initial deposit amount "<depositAmount>"
      And the user creates the new checking
      Then an initial deposit error message should be displayed

      Examples:
        | accountType          | ownership     | accountName           | depositAmount    |
        | Standard Checking    | Individual    | MyWrongChecking1      | 1                |
        | Standard Checking    | Joint         | MyWrongChecking2      | 5                |
        | Interest Checking    | Individual    | MyWrongChecking3      | 10               |
        | Interest Checking    | Joint         | MyWrongChecking4      | 20               |
