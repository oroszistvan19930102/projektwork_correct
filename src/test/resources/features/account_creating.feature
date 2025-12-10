Feature: New Checking
  Background:
    Given the user is logged in to the Digital Bank System

  @successful_account_creation
  Rule: User with successful checking creation see the newly created check
  Scenario Outline: Successful checking creation
    When the user opens the "<type>" creation page
    And the user selects account type "<accountType>"
    And the user selects ownership "<ownership>"
    And the user enters account name "<accountName>"
    And the user enters initial deposit amount "<depositAmount>"
    And the user creates the new account
    Then the account "<accountName>" of the user should be displayed
    And a confirmation message should be displayed

    Examples:
      | accountType          | ownership     | accountName      | depositAmount     | type      |
      | Standard Checking    | Individual    | MyChecking1      | 100               | Checking  |
      | Standard Checking    | Joint         | MyChecking2      | 500               | Checking  |
      | Interest Checking    | Individual    | MyChecking3      | 1000              | Checking  |
      | Interest Checking    | Joint         | MyChecking4      | 2000              | Checking  |
      | Savings              | Individual    | MySaving1        | 100               | Savings   |
      | Savings              | Joint         | MySaving2        | 500               | Savings   |
      | Money Market         | Individual    | MySaving3        | 2500              | Savings   |
      | Money Market         | Joint         | MySaving4        | 3000              | Savings   |

  @unsuccessful_account_creation
  Rule: User with unsuccessful checking creation see an error message
  Scenario Outline: Unsuccessful checking creation
    When the user opens the "<type>" creation page
    And the user selects account type "<accountType>"
    And the user selects ownership "<ownership>"
    And the user enters account name "<accountName>"
    And the user enters initial deposit amount "<depositAmount>"
    And the user creates the new account
    Then an initial deposit error message should be displayed

    Examples:
      | accountType          | ownership     | accountName           | depositAmount    | type      |
      | Standard Checking    | Individual    | MyWrongChecking1      | 1                | Checking  |
      | Standard Checking    | Joint         | MyWrongChecking2      | 5                | Checking  |
      | Interest Checking    | Individual    | MyWrongChecking3      | 10               | Checking  |
      | Interest Checking    | Joint         | MyWrongChecking4      | 20               | Checking  |
      | Savings              | Individual    | MyWrongSaving1        | 1                | Savings   |
      | Savings              | Joint         | MyWrongSaving2        | 5                | Savings   |
      | Money Market         | Individual    | MyWrongSaving3        | 10               | Savings   |
      | Money Market         | Joint         | MyWrongSaving4        | 20               | Savings   |